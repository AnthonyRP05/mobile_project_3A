package com.example.mobile_project_3a.presentation.detail

import com.example.mobile_project_3a.presentation.list.Coin
import com.example.mobile_project_3a.presentation.list.CryptoModel

sealed class DetailModel

data class DetailSuccess(
    val detailList : String?,
    val logo : String?
) : DetailModel()
object DetailError : DetailModel()
object DetailLoader : DetailModel()
