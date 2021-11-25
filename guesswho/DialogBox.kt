package mx.pemg.guesswho

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.InputType
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class DialogBox(contexto: Context?, private val interfaz: EndDialogBox, val msg: String) {
    interface EndDialogBox {
        fun ResultDialogBox(mensaje: String?)
    }

    init {
        val dialogo = Dialog(contexto!!)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(false)
        dialogo.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogo.setContentView(R.layout.dialog_box_response)
        val mensaje = dialogo.findViewById<View>(R.id.mensaje) as TextView
        val aceptar = dialogo.findViewById<View>(R.id.aceptar) as ImageView
        val cancelar = dialogo.findViewById<View>(R.id.cancelar) as ImageView
    
        mensaje.setText(msg)
        aceptar.setOnClickListener {
            interfaz.ResultDialogBox(mensaje.text.toString())
            dialogo.dismiss()
        }
        cancelar.setOnClickListener { dialogo.dismiss() }
        dialogo.show()
    }
}
