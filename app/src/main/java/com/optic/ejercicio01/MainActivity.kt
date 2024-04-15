package com.optic.ejercicio01

import android.os.Bundle
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }

        val btnCambioTexto = findViewById<Button>(R.id.BtnCambioText)
        val texto1 = findViewById<TextView>(R.id.texto1)
        val texto2 = findViewById<TextView>(R.id.texto2)



        btnCambioTexto.setOnClickListener(){

            val random = Random
            val randomNumber = random.nextInt(2)

            if (randomNumber == 0) {
                val ramdomText = generateRandomText()
                texto1.text = ramdomText


            } else {
                val ramdomText = generateRandomText()
                texto2.text = ramdomText

            }

        }
    }
    private fun generateRandomText(): String {

        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val textLength = Random.nextInt(10, 500)
        return (1..textLength)
            .map { Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")

    }

}