package com.dji.dicerollapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DiceRollViewModel: ViewModel() {

    private val _diceRoll = MutableLiveData(Pair(1, 1))
    val diceRoll: LiveData<Pair<Int, Int>> = _diceRoll

    fun rollDice() {
        val roll1 = Random.nextInt(1, 7)
        val roll2 = Random.nextInt(1, 7)
        _diceRoll.value = Pair(roll1, roll2)
    }
}