package com.example.numberguessinggame

import android.app.admin.FactoryResetProtectionPolicy
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    lateinit var textViewTitle: TextView
    lateinit var textViewHint: TextView
    lateinit var textViewCount: TextView
    lateinit var textViewAnswer: TextView
    lateinit var editText: EditText
    lateinit var buttonCheck: Button
//    lateinit var buttonReset: Button

    var random: Int = Random.nextInt(1, 1000)
    var count: Int = 0
    var blank: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textViewTitle = findViewById(R.id.textViewTitle)
        textViewHint = findViewById(R.id.textViewHint)
        textViewCount = findViewById(R.id.textViewCount)
        textViewAnswer = findViewById(R.id.textViewAnswer)
        editText = findViewById(R.id.editText)
        buttonCheck = findViewById(R.id.buttonCheck)

        textViewTitle.text = "Try to Guess the number I'm thinking of from 1 - 1000!"
        buttonCheck.text = "CHECK"

        buttonCheck.setOnClickListener {

            if (editText.text.isEmpty()){
                textViewHint.text = ""
                buttonCheck.text = "CHECK"
                textViewCount.text = ""
                textViewAnswer.text = ""
                blank++


            } else {
                val number: Int = editText.text.toString().toInt()
                blank = 0
                textViewHint.text= ""

                if (number > random){

                    textViewHint.text = "Hint: it's higher!"
                    count+=1
                    editText.text.clear()

                } else if (number < random) {

                    textViewHint.text = "Hint: it's lower!"
                    count+=1
                    editText.text.clear()

                } else {

                    textViewHint.text = "Correct Answer!!!"
                    textViewCount.text = "total number guessed: $count"
                    textViewAnswer.text = "Answer: $random"
                    editText.text.clear()
                    reset()
                }
            }

            if (blank > 1) {
                textViewHint.text = "Please, Entry your number!"
            }

        }


    }

    fun reset() {
        random = Random.nextInt(1, 1000)
        count = 0
        textViewTitle.text = "Try to Guess the number I'm thinking of from 1 - 1000!"
        buttonCheck.text = "PLAY AGAIN"
        editText.text.clear()
    }

}



