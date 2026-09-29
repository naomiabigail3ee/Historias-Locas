package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var introducciones : Array<String>
    lateinit var desarrollos : Array<String>
    lateinit var finales:  Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        introducciones= resources.getStringArray(R.array.introducciones)
        desarrollos = resources.getStringArray(R.array.desarrollos)
        finales = resources.getStringArray(R.array.finales)


        val boton = findViewById<Button>(R.id.boton)
        val titulo = findViewById<TextView>(R.id.titulo)
        boton.setOnClickListener { val historia = generarHistoria()
            titulo.text=historia
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }



    fun generarIntroduccion() : String{
        return introducciones.random();
    }

    fun generarDesarrollo() : String{

        return desarrollos.random();
    }

    fun generarFinal() : String{
        return finales.random();
    }
    fun generarHistoria() : String{
        return generarIntroduccion()+" "+generarDesarrollo()+" "+ generarFinal()

    }
}