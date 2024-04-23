package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val control = ManejadorArchivo(this)
        val contenido = control.leerArchivo()
        Toast.makeText(this, "Lo que tiene:  $contenido",
            Toast.LENGTH_LONG).show()
    }
    fun guardar(v: View){
        //Hace referencia al nombre de la clase
        val control = ManejadorArchivo(this)
        val contenidoProvisional = "Esta es una prueba"
        val resp = control.guardar(contenidoProvisional)
        val msg = if(resp) "Se guardó correctamente"
        else "Ocurrió un error"
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()



    }
}