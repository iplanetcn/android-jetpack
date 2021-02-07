package com.cherry.score

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

/**
 * MainViewModel
 *
 * @author john
 * @since 2020-08-05
 */
class MainViewModel : ViewModel() {
    private val stackScore: Stack<Pair<Int?,Int?>> by lazy {
        Stack<Pair<Int?,Int?>>()
    }

    val scoreTeamA: MutableLiveData<Int> by lazy {
        MutableLiveData(0)
    }

    val scoreTeamB: MutableLiveData<Int> by lazy {
        MutableLiveData(0)
    }

    fun addScoreTeamA(n: Int) {
        stackScore.push(Pair(scoreTeamA.value, scoreTeamB.value))
        scoreTeamA.value = scoreTeamA.value?.plus(n)
    }

    fun addScoreTeamB(n: Int) {
        stackScore.push(Pair(scoreTeamA.value, scoreTeamB.value))
        scoreTeamB.value = scoreTeamB.value?.plus(n)
    }

    fun undo() {
        if (stackScore.empty()) {
            return
        }

        val pop = stackScore.pop()
        scoreTeamA.value = pop.first
        scoreTeamB.value = pop.second
    }

    fun reset() {
        scoreTeamA.value = 0
        scoreTeamB.value = 0
        stackScore.clear()
    }
}