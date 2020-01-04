package com.hardik.repository.network

import androidx.lifecycle.MutableLiveData
import com.hardik.core.NetworkHandler
import com.hardik.core.Result
import com.hardik.repository.model.Hero
import retrofit2.Retrofit
import javax.inject.Inject


class ApiManager @Inject constructor(var mRetrofit: Retrofit) {

    suspend fun getAllHeroes(): MutableLiveData<Result<Hero>> {
        val mHeroesApi = mRetrofit.create(HeroesApi::class.java)
        return NetworkHandler<Hero>().makeCall(mHeroesApi.getAllHeroes(2))
    }
}