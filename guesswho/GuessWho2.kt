package mx.pemg.guesswho

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class GuessWho2 : AppCompatActivity(), DialogBox.EndDialogBox {

    var contexto: Context? = null
    var txtMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_who2)

        contexto = this
        val boton = findViewById<View>(R.id.btnMessage) as Button
        txtMessage = findViewById<View>(R.id.txtMessage) as TextView
        boton.setOnClickListener { DialogBox(contexto, this, "hola") }
    }

    override fun ResultDialogBox(mensaje: String?) {
        txtMessage!!.text = mensaje
    }
}