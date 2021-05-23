package com.example.mobile_project_3a.presentation.list


data class Coin(
    val id: Int,
    val symbol: String,
    val name: String,
    val slug: String,
    val rank: Int,
    val last_historical_data: String
)