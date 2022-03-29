package com.example.laboratoriocolegio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadosActivity : AppCompatActivity() {

    var operaciones: Operaciones? = null
    var campoNombre:TextView ?=null
    var campoMaterias:TextView ?=null
    var campoNotas:TextView ?=null
    var campoPromedio:TextView ?=null
    var campoEstado:TextView ?=null
    var btnInicio:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        val miBundle: Bundle?=this.intent.extras
        iniciarComponentes(miBundle!!)
    }

    fun iniciarComponentes(miBundle:Bundle) {
        campoNombre=findViewById(R.id.textViewNombreResultado )
        campoMaterias=findViewById(R.id.textViewMateriasresultado )
        campoNotas=findViewById(R.id.textViewNotasResultado )
        campoPromedio=findViewById(R.id.textViewPromedioResultado )
        campoEstado=findViewById(R.id.textViewEstadoResultado )

        btnInicio=findViewById(R.id.btnInicioResultado)

        setComponentes(miBundle!!)
    }

    fun setComponentes(miBundle: Bundle){

        if(miBundle!=null){
            campoNombre?.setText("Nombre: ${miBundle.getString("nombre")}")

            campoMaterias?.setText("${miBundle.getString("materia1")}\n" +
                    "\n${miBundle.getString("materia2")}\n"+
                    "\n${miBundle.getString("materia3")}\n"+
                    "\n${miBundle.getString("materia4")}\n"+
                    "\n${miBundle.getString("materia5")}\n")

            campoNotas?.setText("${miBundle.getString("n1")}\n" +
                    "\n${miBundle.getString("n2")}\n"+
                    "\n${miBundle.getString("n3")}\n"+
                    "\n${miBundle.getString("n4")}\n"+
                    "\n${miBundle.getString("n5")}\n")

            campoPromedio?.setText("Promedio: ${miBundle.getDouble("prom")}")

            if(miBundle?.getString("estado")=="Aprobado"){
                campoEstado?.setText("Aprobado")
            }else{
                when (miBundle?.getBoolean("poRecuperar")){
                    true -> campoEstado?.setText("Reprobado (Posibilidad de recuperar)")
                    false -> campoEstado?.setText("Reprobado (Sin posibilidad de recuperar)")
                }
            }
        }

        btnInicio?.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
    }
}