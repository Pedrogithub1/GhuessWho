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

class DialogBoxSkin(contexto: Context?, private val interfaz: EndDialogBox) {
    interface EndDialogBox {
        fun ResultDialogBox(mensaje: String?)
    }

    init {
        val dialogo = Dialog(contexto!!)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(false)
        dialogo.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogo.setContentView(R.layout.activity_dialog_box_skin)

        val btnMoreno = dialogo.findViewById<View>(R.id.btnMoreno) as Button
        val btnBlanco = dialogo.findViewById<View>(R.id.btnBlanco) as Button
        val btnNegro = dialogo.findViewById<View>(R.id.btnNegro) as Button

        val aceptar = dialogo.findViewById<View>(R.id.aceptar) as ImageView
        val cancelar = dialogo.findViewById<View>(R.id.cancelar) as ImageView

        var mensaje = " "
        var bandMoreno = 0
        var bandBlanco = 0
        var bandNegro = 0

        btnMoreno.setOnClickListener{
            if(bandMoreno == 0){
                btnMoreno.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnBlanco.setBackgroundColor(Color.TRANSPARENT)
                btnNegro.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Es Moreno?"
                bandMoreno = 1
                bandBlanco = 0
                bandNegro = 0
            }
            else{
                btnMoreno.setBackgroundColor(Color.TRANSPARENT)
                bandMoreno = 0
                mensaje = "Elige una pregunta"
            }

        }

        btnBlanco.setOnClickListener{
            if(bandBlanco == 0){
                btnBlanco.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnMoreno.setBackgroundColor(Color.TRANSPARENT)
                btnNegro.setBackgroundColor(Color.TRANSPARENT)
                mensaje = "¿Es Blanco?"

                bandBlanco = 1
                bandMoreno = 0
                bandNegro = 0
            }
            else{
                btnBlanco.setBackgroundColor(Color.TRANSPARENT)
                bandBlanco = 0
                mensaje = "Elige una pregunta"
            }
        }

        btnNegro.setOnClickListener{
            if(bandNegro == 0){
                btnNegro.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnMoreno.setBackgroundColor(Color.TRANSPARENT)
                btnBlanco.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Es Negro?"
                bandNegro = 1
                bandMoreno = 0
                bandBlanco = 0
            }
            else{
                btnNegro.setBackgroundColor(Color.TRANSPARENT)
                bandNegro = 0
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