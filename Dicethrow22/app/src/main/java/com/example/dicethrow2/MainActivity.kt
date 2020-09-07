package com.example.dicethrow2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import kotlin.random.Random
import com.example.dicethrow2.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnLess = binding.btnLess
        btnLess.setOnClickListener {
            diceLess()
        }

        val btnEqual = binding.btnEqual
        btnEqual.setOnClickListener {
            diceEqual()
        }

        val btnMore = binding.btnMore
        btnMore.setOnClickListener {
            diceMore()
        }
    }
    fun diceLess(){
        val side = Random.nextInt(0,6) + 1
        val lastThrow = binding.lastThrow
        if(lastThrow.text.toString().toInt() > side) {
            Toast.makeText(this@MainActivity, "You guessed correct!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "You guessed incorrect", Toast.LENGTH_SHORT).show()
        }
        updateUI(side)
    }

    fun diceEqual(){
        val side = Random.nextInt(0,6) + 1
        val lastThrow = binding.lastThrow
        if(lastThrow.text === "$side") {
            Toast.makeText(this@MainActivity, "You guessed correct!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "You guessed incorrect", Toast.LENGTH_SHORT).show()
        }
        updateUI(side)
    }

    fun diceMore(){
        val side = Random.nextInt(0,6) + 1
        val lastThrow = binding.lastThrow
        if(lastThrow.text.toString().toInt() < side) {
            Toast.makeText(this@MainActivity, "You guessed correct!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "You guessed incorrect", Toast.LENGTH_SHORT).show()
        }
        updateUI(side)
    }

    fun updateUI(side: Number){
        val lastThrow = binding.lastThrow
        lastThrow.text = "$side"
        val diceImg = binding.imgDice
        when(side){
            1-> diceImg.setImageResource(R.drawable.dice1)
            2-> diceImg.setImageResource(R.drawable.dice2)
            3-> diceImg.setImageResource(R.drawable.dice3)
            4-> diceImg.setImageResource(R.drawable.dice4)
            5-> diceImg.setImageResource(R.drawable.dice5)
            6-> diceImg.setImageResource(R.drawable.dice6)

        }
    }
}
