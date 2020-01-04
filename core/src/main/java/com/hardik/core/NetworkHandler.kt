package com.hardik.core

import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import java.io.IOException

class NetworkHandler<T> {

    fun makeCall(response: Response<T>): MutableLiveData<Result<T>> {

        val result: MutableLiveData<Result<T>> =
            MutableLiveData()

        result.value = Result.Loading

        if (response.isSuccessful) {
            result.value = Result.Success(response.body())
        } else {
            result.value =
                Result.Error(IOException("Error in API Response : ${response.code()} ${response.message()}"))
        }

        return result
    }

}