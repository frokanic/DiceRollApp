package com.dji.dicerollapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dji.dicerollapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DiceRollViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[DiceRollViewModel::class.java]

        binding.btnRoll.setOnClickListener {
            viewModel.rollDice()
        }

        viewModel.diceRoll.observe(this) { rolls ->
            binding.ivDice1.setImageResource(diceDrawable(rolls.first))
            binding.ivDice2.setImageResource(diceDrawable(rolls.second))
        }
    }

    private fun diceDrawable(diceRoll: Int) = when (diceRoll) {
        1 -> R.drawable.dice1
        2 -> R.drawable.dice2
        3 -> R.drawable.dice3
        4 -> R.drawable.dice4
        5 -> R.drawable.dice5
        6 -> R.drawable.dice6
        else -> throw IllegalArgumentException("Dice roll should be between 1 and 6")
    }
}