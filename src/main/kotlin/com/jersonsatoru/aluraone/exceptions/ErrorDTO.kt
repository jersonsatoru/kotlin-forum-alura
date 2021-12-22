package com.jersonsatoru.aluraone.exceptions

data class ErrorDTO(
        val message: String,
        val path: String,
        val fields: MutableMap<String, String?>? = mutableMapOf()
)
