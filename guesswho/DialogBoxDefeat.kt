package mx.com.fullcomputer.guesswho

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView

class DialogBoxDefeat(contexto: Context?) {

    init {
        val dialogo = Dialog(contexto!!)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(false)
        dialogo.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogo.setContentView(R.layout.activity_dialog_box_defeat)
        val aceptar = dialogo.findViewById<View>(R.id.aceptar) as ImageView

        aceptar.setOnClickListener { dialogo.dismiss() }
        dialogo.show()
    }
}