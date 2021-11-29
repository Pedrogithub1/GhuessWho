package mx.com.fullcomputer.guesswho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.com.fullcomputer.guesswho.SocketHandler.mSocket
import mx.com.fullcomputer.guesswho.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlayPVP.setOnClickListener {
            val intent = Intent(this, WaitingRoom::class.java)
            intent.putExtra("id", 1)
            startActivity(intent)
        }

        binding.btnEnterRoom.setOnClickListener {
            val intent = Intent(this, EnterRoom::class.java)
            startActivity(intent)
        }

        binding.btnPlayAI.setOnClickListener {
            val intent = Intent(this, GuessWho2::class.java)
            startActivity(intent)
        }

        binding.btnHelp.setOnClickListener {
            val intent = Intent(this, Help::class.java)
            startActivity(intent)
        }
    }
}