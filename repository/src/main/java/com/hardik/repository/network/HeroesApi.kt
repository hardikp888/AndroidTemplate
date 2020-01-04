package com.hardik.repository.network

import com.hardik.repository.model.Hero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroesApi {

    @GET("/api/users/{id}")
    suspend fun getAllHeroes(@Path("id") id: Long): Response<Hero>

}