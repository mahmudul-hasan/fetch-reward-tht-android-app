package com.mhpractice.fetchthtapp.repository

import com.mhpractice.fetchthtapp.model.Item
import com.mhpractice.fetchthtapp.model.Items
import retrofit2.Response
import java.util.SortedMap

/**
 * This is the repository interface that is implemented by the [FetchDataRepositoryImpl]
 *
 * @author Mahmudul Hasan.
 */
interface FetchDataRepository {
    suspend fun loadData() : Response<Items>
}