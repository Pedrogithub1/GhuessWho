package mx.pemg.guesswho

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import mx.pemg.guesswho.DialogBox.EndDialogBox

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnMensaje = findViewById<Button>(R.id.btnMensaje)
        btnMensaje.setOnClickListener{
            val intent = Intent(this, GuessWho2::class.java)
            startActivity(intent)
        }

    }
}