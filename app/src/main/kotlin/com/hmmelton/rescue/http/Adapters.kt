package com.hmmelton.rescue.http

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.threeten.bp.Instant

/** Moshi adapter for ISO-8601 date string & Instant. */
class InstantAdapter {
    @ToJson
    fun toJson(instant: Instant) = instant.toString()
    @FromJson
    fun fromJson(text: String): Instant = Instant.parse(text)
}