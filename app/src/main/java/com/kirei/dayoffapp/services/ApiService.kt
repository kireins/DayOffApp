package com.kirei.dayoffapp.services

import com.kirei.dayoffapp.model.ResponseMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("movie")
    fun getMovieData(
            @Query("api_key") apiKey: String?,
            @Query("language") lang: String?
    ): Call<ResponseMovies>
}