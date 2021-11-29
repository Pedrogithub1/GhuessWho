package mx.com.fullcomputer.guesswho

import android.util.Log
import io.socket.client.Socket
import io.socket.client.IO
import java.net.URISyntaxException

object SocketHandler {
    lateinit var mSocket: Socket
    private const val TAG = "MyActivity"

    @Synchronized
    fun setSocket(nameRoom: String) {
        try {
            val options = IO.Options()
            options.query = "nameRoom=${nameRoom}"
            mSocket = IO.socket("https://fullcomputer.com.mx", options)
        } catch (e: URISyntaxException) {
            Log.i(TAG, "MEsto noo conecta")

        }
    }

    @Synchronized
    fun getSocket(): Socket {
        return mSocket
    }

    @Synchronized
    fun establishConnection() {
        mSocket.connect()
    }

    @Synchronized
    fun closeConnection() {
        mSocket.disconnect()
    }
}