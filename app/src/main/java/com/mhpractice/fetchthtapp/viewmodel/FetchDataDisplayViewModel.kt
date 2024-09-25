package com.mhpractice.fetchthtapp.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhpractice.fetchthtapp.model.Item
import com.mhpractice.fetchthtapp.repository.FetchDataRepository
import com.mhpractice.fetchthtapp.repository.FetchDataRepositoryImpl
import kotlinx.coroutines.launch
import java.util.SortedMap

/**
 * This is the ViewModel class that access the data layer through the repository and contains the
 * business logic.
 *
 * @author Mahmudul Hasan.
 */
class FetchDataDisplayViewModel() : ViewModel(), FetchDataDisplayUseCase {

    private var _mutableItemMap = mutableStateMapOf<Int, List<Item>>()
    private val mutableItemMap: Map<Int, List<Item>> get() = _mutableItemMap

    private val repository: FetchDataRepository = FetchDataRepositoryImpl()

    override fun getSortedResult(): HashMap<Int, List<Item>> {
        val resultMap = HashMap<Int, List<Item>>()
        resultMap.clear()
        mutableItemMap.keys.forEach {
            resultMap[it] = mutableItemMap[it]?.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) {
                item -> item.name })!!
        }
        return resultMap
    }

    override fun loadDataFromServer() {
        viewModelScope.launch {
            val response = repository.loadData()

            if (response != null) {

                //Filtering up the result where name is blank or null
                val items = response.body()
                items?.removeIf { it.name.isNullOrEmpty() }
                val groupedAndSortedItemsMap = items?.groupBy { it.listId }!!
                Log.d("TESTEST", groupedAndSortedItemsMap.toString())
                Log.d("TESTEST", groupedAndSortedItemsMap?.size.toString())

                _mutableItemMap.clear()
                _mutableItemMap.putAll(groupedAndSortedItemsMap)
            }
        }
    }
}