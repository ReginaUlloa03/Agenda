package com.example.agenda

import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.lang.StringBuilder

class ManejadorArchivo (val context: Context)

{

    val nombreArchivo = "datos.json"

    fun guardar(contenido: String): Boolean{

        var resp = false
        try {
            val archivo = File(context.getExternalFilesDir(null),
            nombreArchivo)
            val fos = FileOutputStream(archivo, false)
            val escribe = OutputStreamWriter(fos)
            escribe.write(contenido)
            escribe.close()
            resp=true

        }catch (e: Exception){
            Log.e("Error archivo", "Ocurrió un error")
        }
        return resp;
    }

    fun leerArchivo():String{
        val contenido = StringBuilder();
        try {
            val archivo = File(context.getExternalFilesDir(null),
                nombreArchivo)
            if (archivo.exists()){
                val fis = FileInputStream(archivo)
                val lector = InputStreamReader(fis);
                var buffer = CharArray(4096);
                var cantidad = lector.read(buffer);
                while (cantidad !=-1){
                    contenido.append(buffer, 0, cantidad)
                    cantidad = lector.read(buffer)
                }
                lector.close()
            }
        }catch (e: Exception){
            Log.e("Error archivo","Error lectura");
        }
        return contenido.toString()
    }
}