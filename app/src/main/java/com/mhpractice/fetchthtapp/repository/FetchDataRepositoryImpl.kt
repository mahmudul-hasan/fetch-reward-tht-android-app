package com.mhpractice.fetchthtapp.repository

import android.util.Log
import com.mhpractice.fetchthtapp.api.FetchDataService
import com.mhpractice.fetchthtapp.api.RetrofitInstance
import com.mhpractice.fetchthtapp.model.Item
import com.mhpractice.fetchthtapp.model.Items
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.SortedMap

/**
 * This is the repository implementation class that implements [FetchDataRepository].
 *
 * @author Mahmudul Hasan.
 */
class FetchDataRepositoryImpl : FetchDataRepository {

    override suspend fun loadData() : Response<Items> {
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(FetchDataService::class.java)
        return retrofitService.getFetchData()
    }
}