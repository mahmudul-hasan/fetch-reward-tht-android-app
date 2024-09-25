package com.mhpractice.fetchthtapp.viewmodel

import com.mhpractice.fetchthtapp.model.Item
import java.util.SortedMap

/**
 * This is the usecase interface that the ViewModel implements. This contains the usecases that
 * the viewmodel performs as the business logic.
 *
 * @author Mahmudul Hasan.
 */
interface FetchDataDisplayUseCase {
    fun getSortedResult(): HashMap<Int, List<Item>>
    fun loadDataFromServer()
}