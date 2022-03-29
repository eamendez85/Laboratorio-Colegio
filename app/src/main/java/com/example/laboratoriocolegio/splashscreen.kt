package com.example.laboratoriocolegio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}