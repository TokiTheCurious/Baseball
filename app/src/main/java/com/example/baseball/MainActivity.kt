package com.example.baseball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = GameManager()
        answer_text.text = manager.printCode()
        guess_button.setOnClickListener { checkInputGuess(manager) }
    }

    fun checkInputGuess(manager: GameManager){
        val guess_list = guess_text.text.map { c -> Character.getNumericValue(c) }
        val result = manager.checkGuess(guess_list)
        print(result)
        Toast.makeText(this,result.toString(),Toast.LENGTH_LONG).show()
    }

}
