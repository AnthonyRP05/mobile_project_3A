package com.example.mobile_project_3a.presentation.list

data class Coin(
    val id: Int,
    val name: String,
    val symbol: String,
    val slug: String,
    val rank: String,
    val is_active: String,
    val first_historical_data: String,
    val last_historical_data: String
)