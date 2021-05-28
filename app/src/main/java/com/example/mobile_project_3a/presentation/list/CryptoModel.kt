package com.example.mobile_project_3a.presentation.list

sealed class CryptoModel

data class CryptoSuccess(
    val cryptoList : List<Coin>
) : CryptoModel()
object CryptoError : CryptoModel()
object CryptoLoader : CryptoModel()
