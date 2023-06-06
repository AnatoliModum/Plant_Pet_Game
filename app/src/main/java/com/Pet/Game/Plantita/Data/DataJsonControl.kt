package com.Pet.Game.Plantita.Data

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class LectorJson(private val contexto: Context) {

    // Función para leer el archivo JSON y devolver una lista
    fun leerArchivoJson(): List<DataJsonControl> {
        val PlantData = "Datos_Planta.json"
        val contenidoJson = cargarJsonDesdeAssets(PlantData)
        return analizarJson(contenidoJson)
    }

    // Función para cargar el contenido del archivo JSON desde el directorio "assets"
    private fun cargarJsonDesdeAssets(PlantData: String): String {
        val json: String
        try {
            val inputStream = contexto.assets.open(PlantData)
            val tamaño = inputStream.available()
            val buffer = ByteArray(tamaño)
            inputStream.read(buffer)
            inputStream.close()
            json = buffer.toString(Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            return "No se pudo encontrar el archivo o hay algun error"
         }
        println("Contenido JSON: $json")
        return json
    }

    // Función para analizar el contenido JSON y crear una lista de personas
    private fun analizarJson(contenidoJson: String): List<DataJsonControl> {
        val listaPlanta = mutableListOf<DataJsonControl>()
        try {
            val jsonArray = JSONArray(contenidoJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)

                val TipoPlanta = jsonObject.getString("TipoPlanta")

                val Hidratacion = jsonObject.getInt("Hidratacion")
                val Salud = jsonObject.getInt("Salud")
                val NivelSolar = jsonObject.getInt("NivelSolar")
                val First = jsonObject.getInt("First")

                val Planta = DataJsonControl(Hidratacion, TipoPlanta, Salud, NivelSolar, First)
                listaPlanta.add(Planta)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return listaPlanta
    }
}

data class DataJsonControl(val Hidratacion: Int, val TipoPlanta: String, val Salud: Int, val NivelSolar: Int, val First: Int)