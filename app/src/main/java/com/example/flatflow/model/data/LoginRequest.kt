package com.example.flatflow.model.data

data class LoginRequest(
    val email: String,
    val password: String,
)

data class LoginResponse(
    val token: String?,
    val success: Boolean,
    val message: String,
)
