#!/usr/bin/env okscript

import com.baulsupp.oksocial.kotlin.client
import com.baulsupp.oksocial.kotlin.query
import com.baulsupp.oksocial.kotlin.showOutput
import com.baulsupp.oksocial.output.ConsoleHandler
import com.baulsupp.oksocial.output.ResponseExtractor
import com.baulsupp.oksocial.output.isInstalled
import com.baulsupp.oksocial.output.process.exec
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpServer
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import okhttp3.MediaType
import okhttp3.Response
import okhttp3.ResponseBody
import okio.BufferedSource
import okio.Okio
import java.io.PrintWriter
import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets

val server = HttpServer.create(InetSocketAddress("localhost", 0), 10)

val outputHandler = ConsoleHandler.instance(object : ResponseExtractor<HttpExchange> {
  override fun filename(response: HttpExchange): String? {
    return null
  }

  override fun mimeType(response: HttpExchange): String? {
    return response.requestHeaders["media-type"]?.firstOrNull() ?: "application/json"
  }

  override fun source(response: HttpExchange): BufferedSource {
    return Okio.buffer(Okio.source(response.requestBody))
  }
})

server.createContext("/") { exchange ->
  exchange.responseHeaders.add("Content-Type", "application/json; charset=utf-8")
  exchange.sendResponseHeaders(200, 0)

  runBlocking {
    outputHandler.showOutput(exchange)
  }

  PrintWriter(exchange.responseBody).use { out -> out.println("{}") }
}

server.start()

println("Started on ${server.address}")

data class Config(val inspect: Boolean, val addr: String)
data class Tunnels(val public_url: String, val proto: String, val name: String, val uri: String, val config: Config)
data class TunnelsResponse(val tunnels: List<Tunnels>, val uri: String)

runBlocking {
  if (isInstalled("ngrok")) {
    launch {
      exec(listOf("ngrok", "http", "-bind-tls=true", "--log=stdout", server.address.port.toString())) {
        redirectOutput(System.out)
      }
    }

    delay(1000)

    val response = client.query<TunnelsResponse>("http://127.0.0.1:4040/api/tunnels")
    val tunnel = response.tunnels.find { it.config.addr == "localhost:${server.address.port}" }

    if (tunnel != null) {
      println("Exposed ${tunnel.public_url}")
    } else {
      println("No tunnel found")
    }
  }

  delay(Int.MAX_VALUE)
}
