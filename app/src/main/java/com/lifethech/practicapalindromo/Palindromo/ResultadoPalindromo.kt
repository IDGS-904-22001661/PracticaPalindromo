package com.lifethech.practicapalindromo.Palindromo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lifethech.practicapalindromo.R

class ResultadoPalindromo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_palindromo)

        val tvOriginal = findViewById<TextView>(R.id.tvOriginal)
        val tvInvertido = findViewById<TextView>(R.id.tvInvertido)
        val tvVocales = findViewById<TextView>(R.id.tvVocales)
        val tvConsonantes = findViewById<TextView>(R.id.tvConsonantes)

        val textOriginal: String = intent.extras?.getString("original").orEmpty()
        val textInvertido: String = intent.extras?.getString("invertido").orEmpty()
        val textVocales: String = intent.extras?.getString("vocales").orEmpty()
        val numConsonantes: String = intent.extras?.getString("consonantes").orEmpty()

        tvOriginal.text = "Original: " + textOriginal
        tvInvertido.text = "Invertido: " + textInvertido
        tvVocales.text = "Vocales: " + textVocales
        tvConsonantes.text = "Consonantes: "+ numConsonantes

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}