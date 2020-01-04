package com.hardik.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class UseCase<in P, R> {


    /***
     * Execute the usecase asynchronously and return mutable live result
     */
    suspend operator fun invoke(parameter: P, result: MutableLiveData<Result<R>>) {

    }

    suspend operator fun invoke(parameter: P): MutableLiveData<Result<R>> {
        val liveResult: MutableLiveData<Result<R>> = MutableLiveData()
        this(parameter, liveResult)
        return liveResult
    }

    suspend fun executeNow(parameter: P): Result<R> {
        return try {
            Result.Success(execute(parameter))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    abstract suspend fun execute(parameter: P): R
}

suspend operator fun <R> UseCase<Unit, R>.invoke(): LiveData<Result<R>> = this(Unit)
suspend operator fun <R> UseCase<Unit, R>.invoke(result: MutableLiveData<Result<R>>) = this(Unit, result)