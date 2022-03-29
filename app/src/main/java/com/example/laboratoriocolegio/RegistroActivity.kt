package com.example.laboratoriocolegio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegistroActivity : AppCompatActivity() {

    var campoNombre:EditText ?= null
    var campoDocumento:EditText ?= null
    var campoEdad:EditText ?= null
    var campoTelefono:EditText ?= null
    var campoDireccion:EditText ?= null
    var campoMateria1:EditText ?= null
    var campoMateria2:EditText ?= null
    var campoMateria3:EditText ?= null
    var campoMateria4:EditText ?= null
    var campoMateria5:EditText ?= null
    var campoNota1:EditText ?= null
    var campoNota2:EditText ?= null
    var campoNota3:EditText ?= null
    var campoNota4:EditText ?= null
    var campoNota5:EditText ?= null
    var estudiante:Estudiante ?= null

    var operaciones:Operaciones?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        operaciones=Globals.operaciones


        iniciarComponentes()
    }

    fun iniciarComponentes (){

        campoNombre=findViewById(R.id.editTextNombreRegistro)
        campoDocumento=findViewById(R.id.editTextDocumentoRegistro)
        campoEdad=findViewById(R.id.editTextEdadRegistro)
        campoTelefono=findViewById(R.id.editTextTelefonoRegistro)
        campoDireccion=findViewById(R.id.editTextDireccionRegistro)
        campoMateria1=findViewById(R.id.editTextMateria1)
        campoMateria2=findViewById(R.id.editTextMateria2)
        campoMateria3=findViewById(R.id.editTextMateria3)
        campoMateria4=findViewById(R.id.editTextMateria4)
        campoMateria5=findViewById(R.id.editTextMateria5)
        campoNota1=findViewById(R.id.editTextNota1)
        campoNota2=findViewById(R.id.editTextNota2)
        campoNota3=findViewById(R.id.editTextNota3)
        campoNota4=findViewById(R.id.editTextNota4)
        campoNota5=findViewById(R.id.editTextNota5)

        var btnRegistrar:Button =  findViewById(R.id.btnRegistrarRegistro)
        btnRegistrar.setOnClickListener{registrarEstudiante()}
    }

    fun registrarEstudiante(){
        estudiante=Estudiante()
        estudiante?.nombre=campoNombre?.text.toString()
        estudiante?.documento=campoDocumento?.text.toString()
        estudiante?.edad=campoEdad?.text.toString().toInt()
        estudiante?.telefono=campoTelefono?.text.toString()
        estudiante?.direccion=campoDireccion?.text.toString()

        //materias
        estudiante?.materia1=campoMateria1?.text.toString()
        estudiante?.materia2=campoMateria2?.text.toString()
        estudiante?.materia3=campoMateria3?.text.toString()
        estudiante?.materia4=campoMateria4?.text.toString()
        estudiante?.materia5=campoMateria5?.text.toString()


        //validacion Notas

        val notas= listOf(campoNota1?.text.toString().toDouble(), campoNota2?.text.toString().toDouble(), campoNota3?.text.toString().toDouble(), campoNota4?.text.toString().toDouble(), campoNota5?.text.toString().toDouble())

        var validacion= true

        for (i in notas){
            if (i < 0 || i > 5){
                validacion=false
                break
            }else{
                validacion=true
            }
        }

        when(validacion){
            true ->{
                //notas
                estudiante?.nota1=campoNota1?.text.toString().toDouble()
                estudiante?.nota2=campoNota2?.text.toString().toDouble()
                estudiante?.nota3=campoNota3?.text.toString().toDouble()
                estudiante?.nota4=campoNota4?.text.toString().toDouble()
                estudiante?.nota5=campoNota5?.text.toString().toDouble()



                estudiante?.promedio=operaciones!!.calcularPromedio(estudiante!!)

                if ((estudiante!!.promedio)>=3.5 ){
                    estudiante?.estado="Aprobado"

                }else{
                    estudiante?.estado="Reprobado"
                }

                if(estudiante!!.promedio >= 2.5){

                    if(estudiante!!.promedio >= 3.5){
                        estudiante?.poRecuperar=false
                    }else{
                        estudiante?.poRecuperar=true
                    }

                }else{
                    estudiante?.poRecuperar=false
                }

                operaciones?.registrarEstudiante(estudiante!!)
                operaciones?.imprimirListaEstudiantes()

                Toast.makeText(this, "Estudiante registrado", Toast.LENGTH_LONG).show()
                mostrarResultados()
            }
            false -> Toast.makeText(this, "Las notas no deben ser mayores a 5 ni menores que 0", Toast.LENGTH_LONG).show()
        }

    }

    fun mostrarResultados(){

        val miBundle:Bundle = Bundle()
        miBundle.putString("nombre", estudiante?.nombre)
        miBundle.putString("materia1", estudiante?.materia1)
        miBundle.putString("materia2", estudiante?.materia2)
        miBundle.putString("materia3", estudiante?.materia3)
        miBundle.putString("materia4", estudiante?.materia4)
        miBundle.putString("materia5", estudiante?.materia5)
        miBundle.putString("n1", estudiante?.nota1.toString())
        miBundle.putString("n2", estudiante?.nota2.toString())
        miBundle.putString("n3", estudiante?.nota3.toString())
        miBundle.putString("n4", estudiante?.nota4.toString())
        miBundle.putString("n5", estudiante?.nota5.toString())
        miBundle.putDouble("prom", estudiante!!.promedio)
        miBundle.putString("estado", estudiante?.estado)
        miBundle.putBoolean("poRecuperar", estudiante!!.poRecuperar)
        val intent=Intent(this, ResultadosActivity::class.java)
        intent.putExtras(miBundle)
        startActivity(intent)
    }
}