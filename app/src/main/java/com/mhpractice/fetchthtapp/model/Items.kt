package com.mhpractice.fetchthtapp.model

import androidx.compose.runtime.Stable

/**
 * This is the list of [Item].
 * Making the class Immutable for the list performance optimization purpose.
 *
 * @author Mahmudul Hasan.
 */

@Stable
class Items : ArrayList<Item>() {
}