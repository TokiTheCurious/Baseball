package com.example.baseball

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ArrayAdapter.createFromResource(this, R.array.difficulty_strings, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                adapter.notifyDataSetChanged()
                difficulty_spinner.adapter = adapter
            }
        difficulty_spinner.setSelection(2)
        var spinner = findViewById<Spinner>(R.id.difficulty_spinner)
        val ad = spinner.adapter as BaseAdapter
        ad.notifyDataSetChanged()
        init()
    }

    fun addRow(a: String, b: String, c: String){
        val row = TableRow(this)
        //row.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        val first = TextView(this)
        val second = TextView(this)
        val third = TextView(this)
        first.text = a
        second.text = b
        third.text = c
        row.addView(first)
        row.addView(second)
        row.addView(third)
        table_layout.addView(row)
    }

    fun init(){
        val manager = GameManager(difficulty_spinner.selectedItemPosition + 1)
        answer_length_text.text = "Guess ${manager.codeLength} numbers"
        guess_button.setOnClickListener { checkInputGuess(manager) }
        clearGuesses()
        clearGuessText()
        resetButtons()
        guess_text.filters = arrayOf(InputFilter.LengthFilter(manager.codeLength))

    }

    fun resetButtons(){
        for(i in 0..9){
            val button = findViewById<Button>(getResources().getIdentifier("button"+i, "id", getPackageName()))
            clearButtonColor(button)
        }
    }

    fun clearGuesses(){
        if(table_layout.childCount > 1)
            table_layout.removeViews(1,table_layout.childCount-1)
    }

    fun clearGuessText(){
        guess_text.text.clear()
    }

    fun checkInputGuess(manager: GameManager){
        val guess = guess_text.text.toString()
        val guess_list = guess.map { c -> Character.getNumericValue(c) }
        if(guess_list.distinct().count() != manager.codeLength)
            Toast.makeText(this,"Bad entry, must have ${manager.codeLength} unique values", Toast.LENGTH_LONG).show()
        else {
            val result = manager.checkGuess(guess_list)
            addRow(table_layout.childCount.toString(),guess, result.toString())
            clearGuessText()
            Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show()
        }
    }


    fun startNewGame(v: View){
        init()
    }

    fun clearButtonColor(v: View){
        val newButton = Button(this)
        v.background = newButton.background
    }

    fun ToggleButtonColor(v: View){
        if(v.background is ColorDrawable)
            clearButtonColor(v)
        else
            v.setBackgroundColor(Color.RED)
    }

}
