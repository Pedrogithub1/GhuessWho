package mx.com.fullcomputer.guesswho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import mx.com.fullcomputer.guesswho.databinding.ActivityWaitingRoomBinding

class WaitingRoom : AppCompatActivity() {

    private lateinit var binding: ActivityWaitingRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWaitingRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recibimos el id del usuario
        var id : Int = intent.getIntExtra("id", 0)


        val name = "Lalo"

        // Creamos un ID para la sala
        if(id != 0){ id = (0..1024).random() }

        //Definicion del room
        val roomName: String = name + id

        binding.txtRoomName.text = roomName


        //Conectando con el servidor
        SocketHandler.setSocket(roomName)
        SocketHandler.establishConnection()
        val mSocket = SocketHandler.getSocket()


        binding.btnEnter.setOnClickListener {
            //Se le asigan un personaje aleatorio al usuario
            val character : Int = (1..24).random()

            // Se define un intent con el personaje y el nombre de la sala a la cual se van a conectar
            val intent = Intent(this, GuessWho::class.java)
            intent.putExtra("character", character)
            intent.putExtra("roomname", roomName)
            startActivity(intent)
        }


        binding.btnExit.setOnClickListener {
            mSocket.disconnect()
            finish()
        }


        mSocket.on("ready") { args ->
            if (args[0] != null) {
                runOnUiThread{
                    binding.btnEnter.isEnabled = true;
                }
            }
        }

    }
}