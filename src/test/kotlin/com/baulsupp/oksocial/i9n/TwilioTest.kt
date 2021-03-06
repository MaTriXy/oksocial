package com.baulsupp.oksocial.i9n

import com.baulsupp.oksocial.credentials.DefaultToken
import com.baulsupp.oksocial.Main
import com.baulsupp.oksocial.authenticator.BasicCredentials
import com.baulsupp.oksocial.output.TestOutputHandler
import com.baulsupp.oksocial.services.twilio.TwilioAuthInterceptor
import kotlinx.coroutines.experimental.runBlocking
import okhttp3.Response
import org.junit.Ignore
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TwilioTest {
  private val main = Main()
  private val output = TestOutputHandler<Response>()
  private val credentialsStore = TestCredentialsStore()
  private val service = TwilioAuthInterceptor().serviceDefinition()

  init {
    main.outputHandler = output
    main.credentialsStore = credentialsStore
  }

  @Test
  @Ignore
  fun completeEndpointWithReplacements() {
    credentialsStore.set(service, DefaultToken.name, BasicCredentials("ABC", "PW"))

    main.arguments = mutableListOf("https://api.twilio.com/")
    main.urlComplete = true

    runBlocking {
      main.run()
    }

    assertEquals(mutableListOf(), output.failures)
    assertTrue(output.stdout[0].contains("/Accounts/ABC/Calls.json"))
  }
}
