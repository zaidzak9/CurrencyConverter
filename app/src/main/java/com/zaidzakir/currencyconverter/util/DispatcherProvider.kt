package com.zaidzakir.currencyconverter.util

import kotlinx.coroutines.CoroutineDispatcher

/**
 *Created by Zaid Zakir
 */
interface DispatcherProvider {
    val main:CoroutineDispatcher
    val io:CoroutineDispatcher
    val default:CoroutineDispatcher
    val unconfined:CoroutineDispatcher
}