package com.mhpractice.fetchthtapp.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This class provides a Retrofit instance containing the base URL.
 *
 * @author Mahmudul Hasan.
 */
class RetrofitInstance {
    companion object {
        val baseUrl = "https://fetch-hiring.s3.amazonaws.com/"

        fun getRetrofitInstance() = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }
}