package mx.com.fullcomputer.guesswho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import mx.com.fullcomputer.guesswho.databinding.ActivityEnterRoomBinding

class EnterRoom : AppCompatActivity() {

    private lateinit var binding: ActivityEnterRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnEnterRoom.setOnClickListener {
            val roomName : String = binding.txtRoomID.text.toString()
            if(roomName.isNullOrEmpty()){
                Toast.makeText(this, "Debés colocar un nombre de sala!!", Toast.LENGTH_LONG).show()
            }else{
                //Conectando con el servidor
                SocketHandler.setSocket(roomName)
                SocketHandler.establishConnection()

                // Se le asigan un personaje aleatorio al usuario
                val character : Int = (1..24).random()

                // Se define un intent con el personaje y el nombre de la sala a la cual se van a conectar
                val intent = Intent(this, GuessWho::class.java)
                intent.putExtra("character", character)
//                intent.putExtra("roomname", roomName)

                // Pasa al juego
                startActivity(intent)
            }
        }

        binding.btnExit.setOnClickListener {
            finish()
        }
    }
}