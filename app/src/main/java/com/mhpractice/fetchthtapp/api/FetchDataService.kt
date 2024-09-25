package com.mhpractice.fetchthtapp.api

import com.mhpractice.fetchthtapp.model.Items
import retrofit2.Response
import retrofit2.http.GET

/**
 * This is the service that gets the data from the server using Retrofit.
 *
 * @author Mahmdul Hasan.
 */
interface FetchDataService {

    @GET("hiring.json")
    suspend fun getFetchData(): Response<Items>
}