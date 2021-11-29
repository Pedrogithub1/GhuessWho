package mx.com.fullcomputer.guesswho


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
import android.widget.TextView

class DialogBoxSex(contexto: Context?, private val interfaz: EndDialogBox, personaje: String, arrayPersonaje: Array<Array<Int>>, index: Int) {
    interface EndDialogBox {
        fun ResultDialogBox(mensaje: String?, personaje:String, arrayPersonaje: Array<Array<Int>>, index: Int, resp: String)
    }


    init {
        val dialogo = Dialog(contexto!!)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(false)
        dialogo.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogo.setContentView(R.layout.activity_dialog_box_sex)

        val btnHombre = dialogo.findViewById<View>(R.id.btnHombre) as Button
        val btnMujer = dialogo.findViewById<View>(R.id.btnMujer) as Button

        val aceptar = dialogo.findViewById<View>(R.id.aceptar) as ImageView
        val cancelar = dialogo.findViewById<View>(R.id.cancelar) as ImageView

        var mensaje = "Elige una pregunta"
        var bandHombre = 0
        var bandMujer = 0


        btnHombre.setOnClickListener{
            if(bandHombre == 0){
                btnHombre.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnMujer.setBackgroundColor(Color.TRANSPARENT)
                mensaje = "¿Es Hombre?"
                bandMujer = 0
                bandHombre = 1
            }
            else{
                btnHombre.setBackgroundColor(Color.TRANSPARENT)
                bandHombre = 0
                mensaje = "Elige una pregunta"
            }

        }

        btnMujer.setOnClickListener{
            if(bandMujer == 0){
                btnMujer.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnHombre.setBackgroundColor(Color.TRANSPARENT)
                mensaje = "¿Es Mujer?"
                bandHombre = 0
                bandMujer = 1
            }
            else{
                btnMujer.setBackgroundColor(Color.TRANSPARENT)
                bandMujer = 0
                mensaje = "Elige una pregunta"
            }
        }

        aceptar.setOnClickListener {
            var resp = " "
            if(mensaje == "¿Es Hombre?"){
                if(arrayPersonaje[index][0] == 1){
                    resp = "Si"
                }
                else if(arrayPersonaje[index][0] == 0){
                    resp = "No"
                }
            }
            else if(mensaje == "¿Es Mujer?"){
                if(arrayPersonaje[index][1] == 1){
                    resp = "Si"
                }
                else if(arrayPersonaje[index][1] == 0){
                    resp = "No"
                }
            }

            interfaz.ResultDialogBox(mensaje, personaje, arrayPersonaje, index, resp)
            dialogo.dismiss()
        }
        cancelar.setOnClickListener { dialogo.dismiss() }
        dialogo.show()
    }
}