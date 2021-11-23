package mx.pemg.guesswho

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GuessWho : AppCompatActivity(), DialogBox.EndDialogBox {

    var contexto: Context? = null
    var txtMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guesswho)

        contexto = this
        val boton = findViewById<View>(R.id.btnMessage) as RadioButton
        txtMessage = findViewById<View>(R.id.txtMessage) as TextView
        boton.setOnClickListener { DialogBox(contexto, this, "hola") }
    }

    override fun ResultDialogBox(mensaje: String?) {
        txtMessage!!.text = mensaje
    }
}