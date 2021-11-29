package mx.com.fullcomputer.guesswho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import mx.com.fullcomputer.guesswho.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
        //Definicion del room
//        val nameRoom: String = "LaloRoom"

        // Conectando con el servidor
//        SocketHandler.setSocket(nameRoom)
//        SocketHandler.establishConnection()

//        val counterBtn = findViewById<Button>(R.id.counterBtn)
//        val countTextView = findViewById<TextView>(R.id.countTextView)
//        val next = findViewById<Button>(R.id.btn_signin)

//        val mSocket = SocketHandler.getSocket()

//        counterBtn.setOnClickListener{
////            mSocket.emit("event", arrayListOf("Hola", "Como", "Estas?"))
//            mSocket.emit("event", "Hola como estas?")
//        }

//        next.setOnClickListener{
//            val intent = Intent(this, SignIn::class.java)
//            startActivity(intent)
//        }

//        mSocket.on("event") { args ->
//            if (args[0] != null) {
//                val counter = args[0] as String
//                runOnUiThread {
//                    countTextView.text = counter.toString()
//                }
//            }
//        }

    }
}