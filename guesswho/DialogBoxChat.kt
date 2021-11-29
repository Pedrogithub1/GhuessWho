package mx.com.fullcomputer.guesswho


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView

class DialogBoxChat(contexto: Context?, val msg: String?, val resp: String) {

    init {
        val dialogo = Dialog(contexto!!)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(false)
        dialogo.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogo.setContentView(R.layout.activity_dialog_box_chat)
        val mensajeChat = dialogo.findViewById<View>(R.id.mensajeChat) as TextView
        val respuestaChat = dialogo.findViewById<View>(R.id.respuestaChat) as TextView
        val cancelar = dialogo.findViewById<View>(R.id.cancelar) as ImageView
        mensajeChat.setText(msg).toString()
        respuestaChat.setText(resp).toString()

        cancelar.setOnClickListener { dialogo.dismiss() }
        dialogo.show()
    }
}