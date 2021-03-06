package com.baulsupp.oksocial.i9n

import com.baulsupp.oksocial.Main
import com.baulsupp.oksocial.output.TestOutputHandler
import com.baulsupp.oksocial.security.CertificatePin
import kotlinx.coroutines.experimental.runBlocking
import okhttp3.Response
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.internal.tls.SslClient
import org.junit.Rule
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import javax.net.ssl.SSLHandshakeException
import javax.net.ssl.SSLPeerUnverifiedException
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class WebServerTest {
  @Rule
  @JvmField
  var server = MockWebServer()

  private val main = Main()
  private val output = TestOutputHandler<Response>()

  init {
    main.outputHandler = output
  }

  private val sslClient = SslClient.localhost()

  @Test
  fun httpsRequestInsecureFails() {
    server.useHttps(sslClient.socketFactory, false)
    server.enqueue(MockResponse().setBody("Isla Sorna"))

    main.arguments = mutableListOf(server.url("/").toString())

    runBlocking {
      main.run()
    }

    assertEquals(0, output.responses.size)
    assertEquals(1, output.failures.size)
    assertTrue(output.failures[0] is SSLHandshakeException)
  }

  @Test
  fun httpsRequestInsecure() {
    server.useHttps(sslClient.socketFactory, false)
    server.enqueue(MockResponse().setBody("Isla Sorna"))

    main.arguments = mutableListOf(server.url("/").toString())
    main.allowInsecure = true

    runBlocking {
      main.run()
    }

    assertEquals(1, output.responses.size)
    assertEquals(200, output.responses[0].code())
  }

  @Test
  @Disabled
  fun httpsRequestSecure() {
    server.useHttps(sslClient.socketFactory, false)
    server.enqueue(MockResponse().setBody("Isla Sorna"))

    main.arguments = mutableListOf(server.url("/").toString())

    runBlocking {
      main.run()
    }

    assertEquals(1, output.responses.size)
    assertEquals(200, output.responses[0].code())
  }

  @Test
  fun rejectedWithPin() {
    server.useHttps(sslClient.socketFactory, false)
    server.enqueue(MockResponse().setBody("Isla Sorna"))

    main.arguments = mutableListOf(server.url("/").toString())
    main.certificatePins = listOf(CertificatePin(server.hostName + ":" +
        "sha256/WoiWRyIOVNa9ihaBciRSC7XHjliYS9VwUGOIud4PB18=")) as java.util.List<CertificatePin>
    main.allowInsecure = true

    runBlocking {
      main.run()
    }

    assertEquals(0, output.responses.size)
    assertEquals(1, output.failures.size)
    assertTrue(output.failures[0] is SSLPeerUnverifiedException)
  }
}
