package com.example.quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val questions = listOf(
        "¿Android Studio es un IDE de desarrollo?",
        "¿Java es un lenguaje de programación?",
        "¿XML se utiliza para diseñar interfaces en Android?",
        "¿Kotlin es oficialmente compatible con Android?",
        "¿Android es desarrollado por Apple?"
    )

    private val answers = listOf(
        true, true, true, true, false
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)

        showQuestion()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun showQuestion() {
        findViewById<TextView>(R.id.questionTextView).text = questions[currentIndex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentIndex]

        if (userAnswer == correctAnswer) {
            showToast("¡Respuesta Correcta!")
        } else {
            showToast("Respuesta Incorrecta :(")
        }

        currentIndex++

        if (currentIndex < questions.size) {
            showQuestion()
        } else {
            currentIndex = 0
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
