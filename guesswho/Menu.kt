package mx.com.fullcomputer.guesswho.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mx.com.fullcomputer.guesswho.R
import mx.com.fullcomputer.guesswho.api.APIService
import mx.com.fullcomputer.guesswho.api.RestApiService
import mx.com.fullcomputer.guesswho.api.ServiceBuilder
import mx.com.fullcomputer.guesswho.database.AppDatabase
import mx.com.fullcomputer.guesswho.database.table.Player
import mx.com.fullcomputer.guesswho.game.GuessWho
import mx.com.fullcomputer.guesswho.databinding.ActivityMenuBinding
import mx.com.fullcomputer.guesswho.game.GuessWhoIndividual
import mx.com.fullcomputer.guesswho.socket.SocketHandler

class Menu : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private var delete: Boolean = false
    private lateinit var database: AppDatabase
    private lateinit var player: Player
    private lateinit var playerLiveData: LiveData<Player>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Referencia a la base de datos SQLite
        database = AppDatabase.getDatabase(this)


        // Recuperado id del jugador
        var id: Int = intent.getIntExtra("id", 0)


        CoroutineScope(Dispatchers.IO).launch {
            val r = ServiceBuilder.buildService(APIService::class.java).getWL("wl/${id}")
            if(r.isSuccessful){
                runOnUiThread {
                    val res = r.body()
                    if(res?.status!!){
//                        showMessage(res.message)
                        binding.txtWins.text = res.won.toString()  // Coloca las partidas ganadas
                        binding.txtLoses.text = res.lost.toString() // Coloca las partidas perdidas
                    }
                }
            }
        }

        // Conectado con el Socket
        SocketHandler.setSocket("inicio")
        SocketHandler.establishConnection()
        // Obtenemos el socket
        val mSocket = SocketHandler.getSocket()

        // Eventos del socket
        mSocket.on("inicio") { args ->
            if (args[0] != null) {
                val counter = args[0] as Int
                runOnUiThread {
                    binding.txtViewPlayers.text = counter.toString()
                }
            }
        }

        mSocket.on("unavailable") { args ->
            if (args[0] != null) {
                val counter = args[0] as Int
                runOnUiThread {
                    binding.txtViewPlayers.text = counter.toString()
                }
            }
        }


        // Extraemos la informacion del ususario
        playerLiveData = database.players().get(id)


        playerLiveData.observe(this, Observer {
            player = it // Recuperamos el palyer
            binding.txtNickname.text = it.nickname // Colocamos el nombre del player
            binding.txtScore.text = it.score.toString() // Colocamos su score
        })


        binding.btnPlayPVP.setOnClickListener {
            mSocket.disconnect()
            val roomName = player.nickname + (1..1024).random()
            val intent = Intent(this, WaitingRoom::class.java)
            intent.putExtra("idp", player.id)
            intent.putExtra("roomname", roomName)
            startActivity(intent)
        }

        binding.btnEnterRoom.setOnClickListener {
            mSocket.disconnect()
            val intent = Intent(this, EnterRoom::class.java)
            intent.putExtra("idp", player.id)
            startActivity(intent)
        }

        binding.btnPlayAI.setOnClickListener {
            mSocket.disconnect()
            val intent = Intent(this, GuessWhoIndividual::class.java)
            startActivity(intent)
        }

        binding.btnHelp.setOnClickListener {
            val intent = Intent(this, Help::class.java)
            startActivity(intent)
        }
        binding.btnExit.setOnClickListener {
            mSocket.disconnect()
            finish()
        }

    }


    private fun showMessage(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


    fun showPopup(v : View){
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.popup_menu, popup.menu)
        popup.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId){
                R.id.logout -> {
                    // Obtenemos el socket
                    val mSocket = SocketHandler.getSocket()
                    mSocket.disconnect()
                    playerLiveData.removeObservers(this)
                    CoroutineScope(Dispatchers.IO).launch {
                        database.players().deleteAll()
                        //finish()
                        val intent = Intent(Intent.ACTION_MAIN)
                        intent.addCategory(Intent.CATEGORY_HOME)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                    }
                    true
                }
                else -> true
            }
            true
        }
        popup.show()
    }
}