package mx.pemg.guesswho

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView

class DialogBoxAccesories(contexto: Context?, private val interfaz: EndDialogBox) {
    interface EndDialogBox {
        fun ResultDialogBox(mensaje: String?)
    }

    init {
        val dialogo = Dialog(contexto!!)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(false)
        dialogo.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogo.setContentView(R.layout.activity_dialog_box_accesories)

        val btnSombrero = dialogo.findViewById<View>(R.id.btnSombrero) as Button
        val btnCadena = dialogo.findViewById<View>(R.id.btnCadena) as Button
        val btnPelo = dialogo.findViewById<View>(R.id.btnPelo) as Button
        val btnAretes = dialogo.findViewById<View>(R.id.btnAretes) as Button
        val btnLentes = dialogo.findViewById<View>(R.id.btnLentes) as Button

        val aceptar = dialogo.findViewById<View>(R.id.aceptar) as ImageView
        val cancelar = dialogo.findViewById<View>(R.id.cancelar) as ImageView

        var mensaje = " "
        var bandSombrero = 0
        var bandCadena = 0
        var bandPelo = 0
        var bandAretes = 0
        var bandLentes = 0


        btnSombrero.setOnClickListener{
            if(bandSombrero == 0){
                btnSombrero.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnCadena.setBackgroundColor(Color.TRANSPARENT)
                btnPelo.setBackgroundColor(Color.TRANSPARENT)
                btnAretes.setBackgroundColor(Color.TRANSPARENT)
                btnLentes.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tiene Sombrero?"
                bandSombrero = 1
                bandCadena = 0
                bandPelo = 0
                bandAretes = 0
                bandLentes = 0
            }
            else{
                btnSombrero.setBackgroundColor(Color.TRANSPARENT)
                bandSombrero = 0
                mensaje = "Elige una pregunta"
            }

        }

        btnCadena.setOnClickListener{
            if(bandCadena == 0){
                btnCadena.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnSombrero.setBackgroundColor(Color.TRANSPARENT)
                btnPelo.setBackgroundColor(Color.TRANSPARENT)
                btnAretes.setBackgroundColor(Color.TRANSPARENT)
                btnLentes.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tiene Cadena?"
                bandCadena = 1
                bandSombrero = 0
                bandPelo = 0
                bandAretes = 0
                bandLentes = 0
            }
            else{
                btnCadena.setBackgroundColor(Color.TRANSPARENT)
                bandCadena = 0
                mensaje = "Elige una pregunta"
            }
        }

        btnPelo.setOnClickListener{
            if(bandPelo == 0){
                btnPelo.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnSombrero.setBackgroundColor(Color.TRANSPARENT)
                btnCadena.setBackgroundColor(Color.TRANSPARENT)
                btnAretes.setBackgroundColor(Color.TRANSPARENT)
                btnLentes.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tiene Pelo?"
                bandPelo = 1
                bandSombrero = 0
                bandCadena = 0
                bandAretes = 0
                bandLentes = 0
            }
            else{
                btnPelo.setBackgroundColor(Color.TRANSPARENT)
                bandPelo = 0
                mensaje = "Elige una pregunta"
            }
        }

        btnAretes.setOnClickListener{
            if(bandAretes == 0){
                btnAretes.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnSombrero.setBackgroundColor(Color.TRANSPARENT)
                btnCadena.setBackgroundColor(Color.TRANSPARENT)
                btnPelo.setBackgroundColor(Color.TRANSPARENT)
                btnLentes.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tienes Aretes?"
                bandAretes = 1
                bandSombrero = 0
                bandCadena = 0
                bandPelo = 0
                bandLentes = 0
            }
            else{
                btnAretes.setBackgroundColor(Color.TRANSPARENT)
                bandAretes = 0
                mensaje = "Elige una pregunta"
            }
        }

        btnLentes.setOnClickListener{
            if(bandLentes == 0){
                btnLentes.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnSombrero.setBackgroundColor(Color.TRANSPARENT)
                btnCadena.setBackgroundColor(Color.TRANSPARENT)
                btnPelo.setBackgroundColor(Color.TRANSPARENT)
                btnAretes.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tienes Lentes?"
                bandLentes = 1
                bandSombrero = 0
                bandCadena = 0
                bandPelo = 0
                bandAretes = 0
            }
            else{
                btnLentes.setBackgroundColor(Color.TRANSPARENT)
                bandLentes = 0
                mensaje = "Elige una pregunta"
            }
        }

        aceptar.setOnClickListener {
            interfaz.ResultDialogBox(mensaje)
            dialogo.dismiss()
        }
        cancelar.setOnClickListener { dialogo.dismiss() }
        dialogo.show()
    }
}