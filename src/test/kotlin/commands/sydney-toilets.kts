#!/usr/bin/env okscript

import com.baulsupp.oksocial.kotlin.*
import com.baulsupp.oksocial.location.Location
import com.baulsupp.oksocial.services.datasettes.model.DatasetteResultSet

fun queryPostcode(postcode: String) =
  query<DatasetteResultSet>("https://australian-dunnies.now.sh/dunnies-92a33eb/dunnies.json?Postcode=$postcode")

fun staticMap(toilets: List<Location>): String {
  val markers = mutableListOf<String>()

  toilets.forEach {
    markers.add("pin-s-hospital(" + it.longitude + "," + it.latitude + ")")
  }

  return "https://api.mapbox.com/v4/mapbox.dark/${markers.joinToString(",")}/auto/800x800.png"
}

val loc = location()

val toilets = queryPostcode("2037")

val map = staticMap(toilets.rows.map { Location(it[44] as Double, it[45] as Double) })
show(map)
