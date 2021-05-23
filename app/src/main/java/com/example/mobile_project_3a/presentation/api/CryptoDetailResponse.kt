package com.example.mobile_project_3a.presentation.api

import com.example.mobile_project_3a.presentation.detail.Detail

data class CryptoDetailResponse (
    val data: List<Id>
)

data class Id(
    val id: List<Detail>
)