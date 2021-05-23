package com.example.mobile_project_3a.presentation.detail

data class Detail(
    val id: Int,
    val name: String,
    val symbol: String,
    val category: String,
    val description: String, // gives price up&down 24H...
    val slug: String,
    val logo: String,
    val rank: Int,
    val last_historical_data: String
)