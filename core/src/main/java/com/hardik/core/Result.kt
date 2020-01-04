package com.hardik.core

sealed class Result<out T> {

    data class Success<out T>(val data: T?) : Result<T>()
    data class Error(val exception: Throwable?) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Loading -> "Loading"
        }
    }
}