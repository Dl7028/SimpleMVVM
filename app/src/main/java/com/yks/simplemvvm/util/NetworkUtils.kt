package com.yks.simplemvvm.util

import com.yks.simplemvvm.base.ResultData


/**
 * 网络请求捕获异常
 */
suspend fun <T : Any> safeApiCall(call: suspend () -> ResultData<T>): ResultData<T> {
    return try {
        call()
    } catch (e: Exception) {
        ResultData.Error(e)
    }
}




