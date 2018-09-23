package com.baulsupp.okurl.i9n

import com.baulsupp.okurl.credentials.CredentialsStore
import com.baulsupp.okurl.credentials.ServiceDefinition

// TODO use token set
class TestCredentialsStore : CredentialsStore {
  var tokens: MutableMap<String, String> = linkedMapOf()

  override suspend fun <T> get(serviceDefinition: ServiceDefinition<T>, tokenSet: String): T? {
    return tokens[serviceDefinition.apiHost()]
        ?.let { serviceDefinition.parseCredentialsString(it) }
  }

  override suspend fun <T> set(
    serviceDefinition: ServiceDefinition<T>,
    tokenSet: String,
    credentials: T
  ) {
    tokens[serviceDefinition.apiHost()] = serviceDefinition.formatCredentialsString(credentials)
  }

  override suspend fun <T> remove(serviceDefinition: ServiceDefinition<T>, tokenSet: String) {
    tokens.remove(serviceDefinition.apiHost())
  }
}
