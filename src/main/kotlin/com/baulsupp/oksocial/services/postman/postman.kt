package com.baulsupp.oksocial.services.postman

import com.baulsupp.oksocial.credentials.Token
import com.baulsupp.oksocial.kotlin.client
import com.baulsupp.oksocial.kotlin.query
import com.baulsupp.oksocial.services.postman.model.CollectionResult
import com.baulsupp.oksocial.services.postman.model.CollectionsResult
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async

suspend fun postmanCollectionUrls(tokenSet: Token): List<String> {
  val collections = client.query<CollectionsResult>(
    "https://api.getpostman.com/collections",
    tokenSet).collections.map { it.id }

  val jobs = collections.map {
    async(CommonPool) {
      client.query<CollectionResult>("https://api.getpostman.com/collections/$it", tokenSet)
    }
  }

  return jobs.flatMap {
    it.await().collection.item.flatMap { it.item.map { it.request?.urlString() } }.filterNotNull()
  }
}
