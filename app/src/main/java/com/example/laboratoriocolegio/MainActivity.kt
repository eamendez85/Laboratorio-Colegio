package com.example.laboratoriocolegio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val btnRegistrar:Button = findViewById(R.id.btnRegistrarHome)
        btnRegistrar.setOnClickListener{onClick(1)}
        val btnEstadisticas:Button = findViewById(R.id.btnEstadisticasHome)
        btnEstadisticas.setOnClickListener{onClick(2)}
        val btnAyuda:Button = findViewById(R.id.btnAyudaHome)
        btnAyuda.setOnClickListener{onClick(3)}
    }

    fun onClick(btn:Int){


        when(btn){
            1 -> startActivity(Intent(this, RegistroActivity::class.java))
            2 -> startActivity(Intent(this, EstadistidicasActivity::class.java))
            3 -> startActivity(Intent(this, AyudaActivity::class.java))
        }
    }
}