package com.lifethech.practicapalindromo.Palindromo

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lifethech.practicapalindromo.R

class PalindromoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)

        val editText = findViewById<EditText>(R.id.et1)
        val btnPalindromo = findViewById<android.widget.Button>(R.id.btn1)
        val viewText = findViewById<android.widget.TextView>(R.id.tv1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnPalindromo.setOnClickListener {
            val inputText = editText.text.toString()
            if (comprobarPalindromo(inputText)) {
                viewText.text = "Es un palíndromo"
                val textoInvertido = invertirTexto(inputText)
                val vocalesEnTexto = obtenerVocales(inputText)
                val numConsonates = contarConsonantes(inputText).toString()
                val intent = Intent(this, ResultadoPalindromo::class.java)
                intent.putExtra("original", inputText)
                intent.putExtra("invertido", textoInvertido)
                intent.putExtra("vocales", vocalesEnTexto)
                intent.putExtra("consonantes", numConsonates)
                startActivity(intent)
            } else {
                viewText.text = inputText + " No es un palíndromo"
            }
        }


    }

    private fun comprobarPalindromo(texto: String): Boolean {
        val textoLimpio = texto.replace(" ", "").lowercase()
        val textoInvertido = invertirTexto(textoLimpio)
        return textoLimpio == textoInvertido
    }

    private fun invertirTexto(texto: String): String {
        var i = texto.length - 1
        var textoInvertido = ""

        while (i >= 0) {
            textoInvertido += texto[i]
            i--
        }


        return textoInvertido
    }

    private fun obtenerVocales(texto: String): String {
        var vocales = ""
        for (letra in texto.lowercase()) {
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                vocales += "$letra "
            }
        }
        return vocales
    }

    private fun contarConsonantes(texto: String): Int {
        var num = 0
        for (letra in texto.lowercase()) {
            if (letra in 'a'..'z' && letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u') {
                num++
            }
        }
        return num
    }
}