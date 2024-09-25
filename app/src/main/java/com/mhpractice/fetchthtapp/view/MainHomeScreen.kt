@file:OptIn(ExperimentalFoundationApi::class)

package com.mhpractice.fetchthtapp.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mhpractice.fetchthtapp.model.Item
import com.mhpractice.fetchthtapp.viewmodel.FetchDataDisplayViewModel
import java.util.SortedMap

/**
 * This is the home screen where the list is displayed by listId category. Under each category
 * the data is sorted by the name string lexicographically.
 *
 * @author Mahmudul Hasan.
 */

@Composable
fun MainHomeScreen() {

    val viewModel = viewModel<FetchDataDisplayViewModel>()
    viewModel.loadDataFromServer()

    CategorizedItemsLazyColumn(
        viewModel.getSortedResult()
    )
}

/**
 * This is the header UI composable that shows the category, which is listId.
 */
@Composable
private fun CategoryHeader(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    )
}

/**
 * This is the view for each item that is shown as an element of the list below the category.
 */
@Composable
private fun EachItem(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 14.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
}

/**
 * This is the LazyColumn list implementation. It uses a stickyHeader to display the category header
 * as sticky when scrolled up.
 */
@Composable
private fun CategorizedItemsLazyColumn(
    itemsMap: Map<Int, List<Item>>
) {
    LazyColumn {
        itemsMap.forEach { category ->

            stickyHeader {
                CategoryHeader("ListId: ${category.key}")
            }

            items(category.value, key = { item -> item.id }) {
                EachItem("Id: ${it.id}    ListId: ${it.listId}    Name: ${it.name}")
            }
        }
    }
}