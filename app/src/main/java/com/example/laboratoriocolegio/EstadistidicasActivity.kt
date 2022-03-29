package com.example.laboratoriocolegio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class EstadistidicasActivity : AppCompatActivity() {

    var campoProcesados:TextView ?= null
    var campoAprobados:TextView ?= null
    var campoReprobados:TextView ?= null
    var campoRecuperar:TextView ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadistidicas)
    }

    override fun onStart() {
        super.onStart()

        campoProcesados=findViewById(R.id.textViewProcesados)
        campoAprobados=findViewById(R.id.textViewGanan)
        campoReprobados=findViewById(R.id.textViewPierden)
        campoRecuperar=findViewById(R.id.textViewRecuperar)

        setComponents()
    }

    fun setComponents(){

        campoProcesados?.setText("${Globals.operaciones.listaEstudiantes.size}")

        var aprobados:Int =0
        for( i in Globals.operaciones.listaEstudiantes){
            if(i.estado=="Aprobado"){
                aprobados +=1
            }
        }
        campoAprobados?.setText("${aprobados.toString()}")

        var reprobados:Int =0
        for( i in Globals.operaciones.listaEstudiantes){
            if(i.estado=="Reprobado"){
                reprobados +=1
            }
        }
        campoReprobados?.setText("${reprobados.toString()}")

        var estPoRecuperar:Int = 0
        for(i in Globals.operaciones.listaEstudiantes){
            if(i.poRecuperar==true){
                estPoRecuperar +=1
            }
        }
        campoRecuperar?.setText("Estudiantes con posibilidad de recuperar:  ${estPoRecuperar.toString()}")
    }
}