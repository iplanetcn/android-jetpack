package com.cherry.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModelWithLiveData
 *
 * @author john
 * @since 2020-08-05
 */
class ViewModelWithLiveData : ViewModel() {
    var likedNumber : MutableLiveData<Int> = MutableLiveData()

    init {
        likedNumber.value = 0
    }

    fun addLikeNumber(n:Int) {
        likedNumber.value = likedNumber.value?.plus(n)
    }
}