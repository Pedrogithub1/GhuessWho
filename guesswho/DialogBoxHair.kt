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

class DialogBoxHair(contexto: Context?, private val interfaz: EndDialogBox) {
    interface EndDialogBox {
        fun ResultDialogBox(mensaje: String?)
    }

    init {
        val dialogo = Dialog(contexto!!)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(false)
        dialogo.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogo.setContentView(R.layout.activity_dialog_box_hair)

        val btnLargo = dialogo.findViewById<View>(R.id.btnLargo) as Button
        val btnCorto = dialogo.findViewById<View>(R.id.btnCorto) as Button
        val btnBarba = dialogo.findViewById<View>(R.id.btnBarba) as Button
        val btnBigote = dialogo.findViewById<View>(R.id.btnBigote) as Button
        val btnCalvo = dialogo.findViewById<View>(R.id.btnCalvo) as Button
        val btnPeloNegro = dialogo.findViewById<View>(R.id.btnPeloNegro) as Button
        val btnRubio = dialogo.findViewById<View>(R.id.btnRubio) as Button

        val aceptar = dialogo.findViewById<View>(R.id.aceptar) as ImageView
        val cancelar = dialogo.findViewById<View>(R.id.cancelar) as ImageView

        var mensaje = " "
        var bandLargo = 0
        var bandCorto = 0
        var bandBarba = 0
        var bandBigote = 0
        var bandCalvo = 0
        var bandPeloNegro = 0
        var bandRubio = 0


        btnLargo.setOnClickListener{
            if(bandLargo == 0){
                btnLargo.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnPeloNegro.setBackgroundColor(Color.TRANSPARENT)
                btnCorto.setBackgroundColor(Color.TRANSPARENT)
                btnBarba.setBackgroundColor(Color.TRANSPARENT)
                btnBigote.setBackgroundColor(Color.TRANSPARENT)
                btnCalvo.setBackgroundColor(Color.TRANSPARENT)
                btnRubio.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tiene el pelo largo?"
                bandLargo = 1
                bandCorto = 0
                bandBarba = 0
                bandBigote = 0
                bandCalvo = 0
                bandPeloNegro = 0
                bandRubio = 0
            }
            else{
                btnLargo.setBackgroundColor(Color.TRANSPARENT)
                bandLargo = 0
                mensaje = "Elige una pregunta"
            }

        }

        btnCorto.setOnClickListener{
            if(bandCorto == 0){
                btnCorto.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnLargo.setBackgroundColor(Color.TRANSPARENT)
                btnPeloNegro.setBackgroundColor(Color.TRANSPARENT)
                btnBarba.setBackgroundColor(Color.TRANSPARENT)
                btnBigote.setBackgroundColor(Color.TRANSPARENT)
                btnCalvo.setBackgroundColor(Color.TRANSPARENT)
                btnRubio.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tiene el pelo corto?"
                bandCorto = 1
                bandLargo = 0
                bandBarba = 0
                bandBigote = 0
                bandCalvo = 0
                bandPeloNegro = 0
                bandRubio = 0
            }
            else{
                btnCorto.setBackgroundColor(Color.TRANSPARENT)
                bandCorto = 0
                mensaje = "Elige una pregunta"
            }
        }

        btnBarba.setOnClickListener{
            if(bandBarba == 0){
                btnBarba.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnLargo.setBackgroundColor(Color.TRANSPARENT)
                btnCorto.setBackgroundColor(Color.TRANSPARENT)
                btnPeloNegro.setBackgroundColor(Color.TRANSPARENT)
                btnBigote.setBackgroundColor(Color.TRANSPARENT)
                btnCalvo.setBackgroundColor(Color.TRANSPARENT)
                btnRubio.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tiene Barba?"
                bandBarba = 1
                bandLargo = 0
                bandCorto = 0
                bandBigote = 0
                bandCalvo = 0
                bandPeloNegro = 0
                bandRubio = 0
            }
            else{
                btnBarba.setBackgroundColor(Color.TRANSPARENT)
                bandBarba = 0
                mensaje = "Elige una pregunta"
            }
        }

        btnBigote.setOnClickListener{
            if(bandBigote == 0){
                btnBigote.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnLargo.setBackgroundColor(Color.TRANSPARENT)
                btnCorto.setBackgroundColor(Color.TRANSPARENT)
                btnBarba.setBackgroundColor(Color.TRANSPARENT)
                btnPeloNegro.setBackgroundColor(Color.TRANSPARENT)
                btnCalvo.setBackgroundColor(Color.TRANSPARENT)
                btnRubio.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tienes Bigote?"
                bandBigote = 1
                bandLargo = 0
                bandCorto = 0
                bandBarba = 0
                bandCalvo = 0
                bandPeloNegro = 0
                bandRubio = 0
            }
            else{
                btnBigote.setBackgroundColor(Color.TRANSPARENT)
                bandBigote = 0
                mensaje = "Elige una pregunta"
            }
        }

        btnCalvo.setOnClickListener{
            if(bandCalvo == 0){
                btnCalvo.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnLargo.setBackgroundColor(Color.TRANSPARENT)
                btnCorto.setBackgroundColor(Color.TRANSPARENT)
                btnBarba.setBackgroundColor(Color.TRANSPARENT)
                btnBigote.setBackgroundColor(Color.TRANSPARENT)
                btnPeloNegro.setBackgroundColor(Color.TRANSPARENT)
                btnRubio.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Es Calvo?"
                bandCalvo = 1
                bandLargo = 0
                bandCorto = 0
                bandBarba = 0
                bandBigote = 0
                bandPeloNegro = 0
                bandRubio = 0
            }
            else{
                btnCalvo.setBackgroundColor(Color.TRANSPARENT)
                bandCalvo = 0
                mensaje = "Elige una pregunta"
            }
        }

        btnPeloNegro.setOnClickListener{
            if(bandPeloNegro == 0){
                btnPeloNegro.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnLargo.setBackgroundColor(Color.TRANSPARENT)
                btnCorto.setBackgroundColor(Color.TRANSPARENT)
                btnBarba.setBackgroundColor(Color.TRANSPARENT)
                btnBigote.setBackgroundColor(Color.TRANSPARENT)
                btnCalvo.setBackgroundColor(Color.TRANSPARENT)
                btnRubio.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tienes el pelo negro?"
                bandPeloNegro = 1
                bandLargo = 0
                bandCorto = 0
                bandBarba = 0
                bandBigote = 0
                bandCalvo = 0
                bandRubio = 0
            }
            else{
                btnPeloNegro.setBackgroundColor(Color.TRANSPARENT)
                bandPeloNegro = 0
                mensaje = "Elige una pregunta"
            }
        }

        btnRubio.setOnClickListener {
            if(bandRubio == 0){
                btnRubio.setBackgroundColor(Color.parseColor("#A9DFBF"))
                btnLargo.setBackgroundColor(Color.TRANSPARENT)
                btnCorto.setBackgroundColor(Color.TRANSPARENT)
                btnBarba.setBackgroundColor(Color.TRANSPARENT)
                btnBigote.setBackgroundColor(Color.TRANSPARENT)
                btnCalvo.setBackgroundColor(Color.TRANSPARENT)
                btnPeloNegro.setBackgroundColor(Color.TRANSPARENT)

                mensaje = "¿Tiene el pelo rubio?"
                bandRubio = 1
                bandPeloNegro = 0
                bandLargo = 0
                bandCorto = 0
                bandBarba = 0
                bandBigote = 0
                bandCalvo = 0
            }
            else{
                btnRubio.setBackgroundColor(Color.TRANSPARENT)
                bandRubio = 0
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