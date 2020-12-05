package com.yks.simplemvvm.base

/**
 * @Description:
 * @Author:         Yu ki-r
 * @CreateDate:     2020/12/5 22:12
 */
data class BaseBean<T>(
    val data: T,
    val errorCode: Int = 0,
    val errorMsg: String = ""
)


/**
 * 返回的结果
 *
 * @param T
 */
sealed class ResultData<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultData<T>()
    data class Error(val exception: Exception) : ResultData<Nothing>()
    data class ErrorMessage(val message: String) : ResultData<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is ErrorMessage -> message
        }
    }
}
