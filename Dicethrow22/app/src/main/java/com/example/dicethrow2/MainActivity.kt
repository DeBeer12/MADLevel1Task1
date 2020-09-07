package com.example.dicethrow2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLess = findViewById(R.id.btnLess) as Button
        btnLess.setOnClickListener {
            diceLess()
        }

        val btnEqual = findViewById(R.id.btnEqual) as Button
        btnEqual.setOnClickListener {
            diceEqual()
        }

        val btnMore = findViewById(R.id.btnMore) as Button
        btnMore.setOnClickListener {
            diceMore()
        }
    }
    fun diceLess(){
        val side = Random.nextInt(0,6) + 1
        val lastThrow = findViewById(R.id.lastThrow) as TextView
        if(lastThrow.text.toString().toInt() > side) {
            Toast.makeText(this@MainActivity, "You guessed correct!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "You guessed incorrect", Toast.LENGTH_SHORT).show()
        }
        lastThrow.text = "$side"
    }

    fun diceEqual(){
        val side = Random.nextInt(0,6) + 1
        val lastThrow = findViewById(R.id.lastThrow) as TextView
        if(lastThrow.text === "$side") {
            Toast.makeText(this@MainActivity, "You guessed correct!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "You guessed incorrect", Toast.LENGTH_SHORT).show()
        }
        lastThrow.text = "$side"
    }

    fun diceMore(){
        val side = Random.nextInt(0,6) + 1
        val lastThrow = findViewById(R.id.lastThrow) as TextView
        if(lastThrow.text.toString().toInt() < side) {
            Toast.makeText(this@MainActivity, "You guessed correct!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "You guessed incorrect", Toast.LENGTH_SHORT).show()
        }
        lastThrow.text = "$side"
    }
}
