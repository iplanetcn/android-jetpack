package com.cherry.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * MainViewModel
 *
 * @author john
 * @since 2020-08-05
 */
class MainViewModel : ViewModel() {
    val number: MutableLiveData<Int> by lazy {
        MutableLiveData(0)
    }

    fun add() {
        number.value = number.value?.plus(1)
    }
}