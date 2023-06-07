package com.Pet.Game.Plantita

import android.app.Activity
import android.content.Intent
import android.view.View
import com.Pet.Game.Plantita.Data.DataJsonControl

class menuActivity: Activity() {

    fun onPlayButtonClick(view: View) {
        // Lógica para manejar el evento de clic del botón de imagen

        val lectorJson = DataJsonControl(this)
        val listaPlanta = lectorJson.leerArchivoJson()

        for (planta in listaPlanta) {

            val primerJuego = planta.First

            if (primerJuego == 0){

                val intent = Intent(this, SeleccionPlantita::class.java)
                startActivity(intent)

            }else{

            }

        }

    }

}