package com.mhpractice.fetchthtapp.model

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName

/**
 * This is the Item model.
 * Making the class Immutable for the list performance optimization purpose.
 *
 * @author Mahmudul Hasan
 */

@Stable
data class Item(
    @SerializedName("id")
    val id: Int,
    @SerializedName("listId")
    val listId: Int,
    @SerializedName("name")
    val name: String
)
