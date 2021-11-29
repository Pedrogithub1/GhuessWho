package mx.com.fullcomputer.guesswho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import mx.com.fullcomputer.guesswho.databinding.ActivityGuessWhoBinding

class GuessWho : AppCompatActivity(), Question.EndDialogBox, Response.EndResponseBox{

    private lateinit var binding: ActivityGuessWhoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuessWhoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtenemos el socket
        val mSocket = SocketHandler.getSocket()

        mSocket.on("recemsg") { args ->
            if (args[0] != null) {
                val msg = args[0] as String
                runOnUiThread {
                    Response(this, this, msg)
                }
            }
        }

        mSocket.on("receres") {args ->
            if (args[0] != null) {
                val msg = args[0] as String
                runOnUiThread {
                    if(msg == "Si"){
                        binding.cancelar.isVisible = false
                    }
                    binding.aceptar.isVisible = false
                }
            }
        }


        // Obtenemos el personaje
        val character = intent.getIntExtra("character", 0)


        if(character == 0){
            //Salir
        }


        // Realiza una pregunta
        binding.btnMessage.setOnClickListener {
            Question(this, this)
        }

        // Mustra la pregunta
        binding.btnSex.setOnClickListener {
            Response(this, this, "Hola mi amor")
        }


        // Se defien un array de la imagenes // POSIBLE CAMBIO POR DB
        val arrayImg = arrayOf(R.drawable.angela, R.drawable.babo, R.drawable.badbunny, R.drawable.beckyg,
            R.drawable.beyonce, R.drawable.chayanne, R.drawable.dualipa, R.drawable.hannamontana,
            R.drawable.karolg, R.drawable.katyperry, R.drawable.maluma, R.drawable.manuelturizo,
            R.drawable.paquita, R.drawable.pepeaguilar, R.drawable.rihanna, R.drawable.romeosantos,
            R.drawable.rosalia, R.drawable.selenagomez, R.drawable.theweeknd, R.drawable.tupac,
            R.drawable.valentinelizalde, R.drawable.vicentefernandez, R.drawable.wizkhalifa,
            R.drawable.shakira)

        // Se defien un array de el nombre // POSIBLE CAMBIO POR DB
        val arrayNames = arrayOf("Angela", "Babo", "Bad Bunny", "Becky G", "Beyoncé", "Chayanne", "Dua Lipa",
            "Hannah Montana", "Karol G", "Katy Perry", "Maluma", "Manuel Turizo", "Paquita",
            "Pepe Aguilar", "Rihanna", "Romeo Santos", "Rosalía", "Selena Goméz", "The Weeknd",
            "Tupac", "Valentín Elizalde", "Vicente Fernández", "Wiz Khalifa", "Shakira")


        // Se definie un array de size 24
        val arrayRnd = arrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        // Se definie un array de size 24
        val arrayFlags = arrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        // Contador
        var cont: Int
        // Variable para iterar
        var i=0



        // Se llena el array
        do {
            cont = 0
            arrayRnd.set(i, (0..23).random())
            for (j in 0..23) {
                if (arrayRnd[i] == arrayRnd[j])
                    cont++
            }
            if (cont > 1) {
                arrayRnd.set(i, 0)
                i--
            }
            i++
        }while(i < 24)


        // Se define el usuario // YA LO TENGO ARRIBA
        val random = (0..23).random()


        binding.imageView1.setImageResource(arrayImg.get(arrayRnd[random]))
        binding.imageView2.setImageResource(arrayImg.get(arrayRnd[0]))
        binding.imageView3.setImageResource(arrayImg.get(arrayRnd[1]))
        binding.imageView4.setImageResource(arrayImg.get(arrayRnd[2]))
        binding.imageView5.setImageResource(arrayImg.get(arrayRnd[3]))
        binding.imageView6.setImageResource(arrayImg.get(arrayRnd[4]))
        binding.imageView7.setImageResource(arrayImg.get(arrayRnd[5]))
        binding.imageView8.setImageResource(arrayImg.get(arrayRnd[6]))
        binding.imageView9.setImageResource(arrayImg.get(arrayRnd[7]))
        binding.imageView10.setImageResource(arrayImg.get(arrayRnd[8]))
        binding.imageView11.setImageResource(arrayImg.get(arrayRnd[9]))
        binding.imageView12.setImageResource(arrayImg.get(arrayRnd[10]))
        binding.imageView13.setImageResource(arrayImg.get(arrayRnd[11]))
        binding.imageView14.setImageResource(arrayImg.get(arrayRnd[12]))
        binding.imageView15.setImageResource(arrayImg.get(arrayRnd[13]))
        binding.imageView16.setImageResource(arrayImg.get(arrayRnd[14]))
        binding.imageView17.setImageResource(arrayImg.get(arrayRnd[15]))
        binding.imageView18.setImageResource(arrayImg.get(arrayRnd[16]))
        binding.imageView19.setImageResource(arrayImg.get(arrayRnd[17]))
        binding.imageView20.setImageResource(arrayImg.get(arrayRnd[18]))
        binding.imageView21.setImageResource(arrayImg.get(arrayRnd[19]))
        binding.imageView22.setImageResource(arrayImg.get(arrayRnd[20]))
        binding.imageView23.setImageResource(arrayImg.get(arrayRnd[21]))
        binding.imageView24.setImageResource(arrayImg.get(arrayRnd[22]))
        binding.imageView25.setImageResource(arrayImg.get(arrayRnd[23]))


        binding.txtName1.setText(arrayNames.get(arrayRnd[random]))
        binding.txtName2.setText(arrayNames.get(arrayRnd[0]))
        binding.txtName3.setText(arrayNames.get(arrayRnd[1]))
        binding.txtName4.setText(arrayNames.get(arrayRnd[2]))
        binding.txtName5.setText(arrayNames.get(arrayRnd[3]))
        binding.txtName6.setText(arrayNames.get(arrayRnd[4]))
        binding.txtName7.setText(arrayNames.get(arrayRnd[5]))
        binding.txtName8.setText(arrayNames.get(arrayRnd[6]))
        binding.txtName9.setText(arrayNames.get(arrayRnd[7]))
        binding.txtName10.setText(arrayNames.get(arrayRnd[8]))
        binding.txtName11.setText(arrayNames.get(arrayRnd[9]))
        binding.txtName12.setText(arrayNames.get(arrayRnd[10]))
        binding.txtName13.setText(arrayNames.get(arrayRnd[11]))
        binding.txtName14.setText(arrayNames.get(arrayRnd[12]))
        binding.txtName15.setText(arrayNames.get(arrayRnd[13]))
        binding.txtName16.setText(arrayNames.get(arrayRnd[14]))
        binding.txtName17.setText(arrayNames.get(arrayRnd[15]))
        binding.txtName18.setText(arrayNames.get(arrayRnd[16]))
        binding.txtName19.setText(arrayNames.get(arrayRnd[17]))
        binding.txtName20.setText(arrayNames.get(arrayRnd[18]))
        binding.txtName21.setText(arrayNames.get(arrayRnd[19]))
        binding.txtName22.setText(arrayNames.get(arrayRnd[20]))
        binding.txtName23.setText(arrayNames.get(arrayRnd[21]))
        binding.txtName24.setText(arrayNames.get(arrayRnd[22]))
        binding.txtName25.setText(arrayNames.get(arrayRnd[23]))


        binding.imageView2.setOnClickListener {
            if(arrayFlags.get(0) == 0){
                binding.imageView2.setImageResource(R.drawable.guesswho)
                binding.txtName2.setText(" ")
                arrayFlags.set(0, 1)
            }
            else{
                binding.imageView2.setImageResource(arrayImg.get(arrayRnd[0]))
                binding.txtName2.setText(arrayNames.get(arrayRnd[0]))
                arrayFlags.set(0, 0)
            }
        }

        binding.imageView3.setOnClickListener {
            if(arrayFlags.get(1) == 0){
                binding.imageView3.setImageResource(R.drawable.guesswho)
                binding.txtName3.setText(" ")
                arrayFlags.set(1, 1)
            }
            else{
                binding.imageView3.setImageResource(arrayImg.get(arrayRnd[1]))
                binding.txtName3.setText(arrayNames.get(arrayRnd[1]))
                arrayFlags.set(1, 0)
            }
        }

        binding.imageView4.setOnClickListener {
            if(arrayFlags.get(2) == 0){
                binding.imageView4.setImageResource(R.drawable.guesswho)
                binding.txtName4.setText(" ")
                arrayFlags.set(2, 1)
            }
            else{
                binding.imageView4.setImageResource(arrayImg.get(arrayRnd[2]))
                binding.txtName4.setText(arrayNames.get(arrayRnd[2]))
                arrayFlags.set(2, 0)
            }
        }

        binding.imageView5.setOnClickListener {
            if(arrayFlags.get(3) == 0){
                binding.imageView5.setImageResource(R.drawable.guesswho)
                binding.txtName5.setText(" ")
                arrayFlags.set(3, 1)
            }
            else{
                binding.imageView5.setImageResource(arrayImg.get(arrayRnd[3]))
                binding.txtName5.setText(arrayNames.get(arrayRnd[3]))
                arrayFlags.set(3, 0)
            }
        }

        binding.imageView6.setOnClickListener {
            if(arrayFlags.get(4) == 0){
                binding.imageView6.setImageResource(R.drawable.guesswho)
                binding.txtName6.setText(" ")
                arrayFlags.set(4, 1)
            }
            else{
                binding.imageView6.setImageResource(arrayImg.get(arrayRnd[4]))
                binding.txtName6.setText(arrayNames.get(arrayRnd[4]))
                arrayFlags.set(4, 0)
            }
        }

        binding.imageView7.setOnClickListener {
            if(arrayFlags.get(5) == 0){
                binding.imageView7.setImageResource(R.drawable.guesswho)
                binding.txtName7.setText(" ")
                arrayFlags.set(5, 1)
            }
            else{
                binding.imageView7.setImageResource(arrayImg.get(arrayRnd[5]))
                binding.txtName7.setText(arrayNames.get(arrayRnd[5]))
                arrayFlags.set(5, 0)
            }
        }

        binding.imageView8.setOnClickListener {
            if(arrayFlags.get(6) == 0){
                binding.imageView8.setImageResource(R.drawable.guesswho)
                binding.txtName8.setText(" ")
                arrayFlags.set(6, 1)
            }
            else{
                binding.imageView8.setImageResource(arrayImg.get(arrayRnd[6]))
                binding.txtName8.setText(arrayNames.get(arrayRnd[6]))
                arrayFlags.set(6, 0)
            }
        }

        binding.imageView9.setOnClickListener {
            if(arrayFlags.get(7) == 0){
                binding.imageView9.setImageResource(R.drawable.guesswho)
                binding.txtName9.setText(" ")
                arrayFlags.set(7, 1)
            }
            else{
                binding.imageView9.setImageResource(arrayImg.get(arrayRnd[7]))
                binding.txtName9.setText(arrayNames.get(arrayRnd[7]))
                arrayFlags.set(7, 0)
            }
        }

        binding.imageView10.setOnClickListener {
            if(arrayFlags.get(8) == 0){
                binding.imageView10.setImageResource(R.drawable.guesswho)
                binding.txtName10.setText(" ")
                arrayFlags.set(8, 1)
            }
            else{
                binding.imageView10.setImageResource(arrayImg.get(arrayRnd[8]))
                binding.txtName10.setText(arrayNames.get(arrayRnd[8]))
                arrayFlags.set(8, 0)
            }
        }

        binding.imageView11.setOnClickListener {
            if(arrayFlags.get(9) == 0){
                binding.imageView11.setImageResource(R.drawable.guesswho)
                binding.txtName11.setText(" ")
                arrayFlags.set(9, 1)
            }
            else{
                binding.imageView11.setImageResource(arrayImg.get(arrayRnd[9]))
                binding.txtName11.setText(arrayNames.get(arrayRnd[9]))
                arrayFlags.set(9, 0)
            }
        }

        binding.imageView12.setOnClickListener {
            if(arrayFlags.get(10) == 0){
                binding.imageView12.setImageResource(R.drawable.guesswho)
                binding.txtName12.setText(" ")
                arrayFlags.set(10, 1)
            }
            else{
                binding.imageView12.setImageResource(arrayImg.get(arrayRnd[10]))
                binding.txtName12.setText(arrayNames.get(arrayRnd[10]))
                arrayFlags.set(10, 0)
            }
        }

        binding.imageView13.setOnClickListener {
            if(arrayFlags.get(11) == 0){
                binding.imageView13.setImageResource(R.drawable.guesswho)
                binding.txtName13.setText(" ")
                arrayFlags.set(11, 1)
            }
            else{
                binding.imageView13.setImageResource(arrayImg.get(arrayRnd[11]))
                binding.txtName13.setText(arrayNames.get(arrayRnd[11]))
                arrayFlags.set(11, 0)
            }
        }

        binding.imageView14.setOnClickListener {
            if(arrayFlags.get(12) == 0){
                binding.imageView14.setImageResource(R.drawable.guesswho)
                binding.txtName14.setText(" ")
                arrayFlags.set(12, 1)
            }
            else{
                binding.imageView14.setImageResource(arrayImg.get(arrayRnd[12]))
                binding.txtName14.setText(arrayNames.get(arrayRnd[12]))
                arrayFlags.set(12, 0)
            }
        }

        binding.imageView15.setOnClickListener {
            if(arrayFlags.get(13) == 0){
                binding.imageView15.setImageResource(R.drawable.guesswho)
                binding.txtName15.setText(" ")
                arrayFlags.set(13, 1)
            }
            else{
                binding.imageView15.setImageResource(arrayImg.get(arrayRnd[13]))
                binding.txtName15.setText(arrayNames.get(arrayRnd[13]))
                arrayFlags.set(13, 0)
            }
        }

        binding.imageView16.setOnClickListener {
            if(arrayFlags.get(14) == 0){
                binding.imageView16.setImageResource(R.drawable.guesswho)
                binding.txtName16.setText(" ")
                arrayFlags.set(14, 1)
            }
            else{
                binding.imageView16.setImageResource(arrayImg.get(arrayRnd[14]))
                binding.txtName16.setText(arrayNames.get(arrayRnd[14]))
                arrayFlags.set(14, 0)
            }
        }

        binding.imageView17.setOnClickListener {
            if(arrayFlags.get(15) == 0){
                binding.imageView17.setImageResource(R.drawable.guesswho)
                binding.txtName17.setText(" ")
                arrayFlags.set(15, 1)
            }
            else{
                binding.imageView17.setImageResource(arrayImg.get(arrayRnd[15]))
                binding.txtName17.setText(arrayNames.get(arrayRnd[15]))
                arrayFlags.set(15, 0)
            }
        }

        binding.imageView18.setOnClickListener {
            if(arrayFlags.get(16) == 0){
                binding.imageView18.setImageResource(R.drawable.guesswho)
                binding.txtName18.setText(" ")
                arrayFlags.set(16, 1)
            }
            else{
                binding.imageView18.setImageResource(arrayImg.get(arrayRnd[16]))
                binding.txtName18.setText(arrayNames.get(arrayRnd[16]))
                arrayFlags.set(16, 0)
            }
        }

        binding.imageView19.setOnClickListener {
            if(arrayFlags.get(17) == 0){
                binding.imageView19.setImageResource(R.drawable.guesswho)
                binding.txtName19.setText(" ")
                arrayFlags.set(17, 1)
            }
            else{
                binding.imageView19.setImageResource(arrayImg.get(arrayRnd[17]))
                binding.txtName19.setText(arrayNames.get(arrayRnd[17]))
                arrayFlags.set(17, 0)
            }
        }

        binding.imageView20.setOnClickListener {
            if(arrayFlags.get(18) == 0){
                binding.imageView20.setImageResource(R.drawable.guesswho)
                binding.txtName20.setText(" ")
                arrayFlags.set(18, 1)
            }
            else{
                binding.imageView20.setImageResource(arrayImg.get(arrayRnd[18]))
                binding.txtName20.setText(arrayNames.get(arrayRnd[18]))
                arrayFlags.set(18, 0)
            }
        }

        binding.imageView21.setOnClickListener {
            if(arrayFlags.get(19) == 0){
                binding.imageView21.setImageResource(R.drawable.guesswho)
                binding.txtName21.setText(" ")
                arrayFlags.set(19, 1)
            }
            else{
                binding.imageView21.setImageResource(arrayImg.get(arrayRnd[19]))
                binding.txtName21.setText(arrayNames.get(arrayRnd[19]))
                arrayFlags.set(19, 0)
            }
        }

        binding.imageView22.setOnClickListener {
            if(arrayFlags.get(20) == 0){
                binding.imageView22.setImageResource(R.drawable.guesswho)
                binding.txtName22.setText(" ")
                arrayFlags.set(20, 1)
            }
            else{
                binding.imageView22.setImageResource(arrayImg.get(arrayRnd[20]))
                binding.txtName22.setText(arrayNames.get(arrayRnd[20]))
                arrayFlags.set(20, 0)
            }
        }

        binding.imageView23.setOnClickListener {
            if(arrayFlags.get(21) == 0){
                binding.imageView23.setImageResource(R.drawable.guesswho)
                binding.txtName23.setText(" ")
                arrayFlags.set(21, 1)
            }
            else{
                binding.imageView23.setImageResource(arrayImg.get(arrayRnd[21]))
                binding.txtName23.setText(arrayNames.get(arrayRnd[21]))
                arrayFlags.set(21, 0)
            }
        }

        binding.imageView24.setOnClickListener {
            if(arrayFlags.get(22) == 0){
                binding.imageView24.setImageResource(R.drawable.guesswho)
                binding.txtName24.setText(" ")
                arrayFlags.set(22, 1)
            }
            else{
                binding.imageView24.setImageResource(arrayImg.get(arrayRnd[22]))
                binding.txtName24.setText(arrayNames.get(arrayRnd[22]))
                arrayFlags.set(22, 0)
            }
        }

        binding.imageView25.setOnClickListener {
            if(arrayFlags.get(23) == 0){
                binding.imageView25.setImageResource(R.drawable.guesswho)
                binding.txtName25.setText(" ")
                arrayFlags.set(23, 1)
            }
            else{
                binding.imageView25.setImageResource(arrayImg.get(arrayRnd[23]))
                binding.txtName25.setText(arrayNames.get(arrayRnd[23]))
                arrayFlags.set(23, 0)
            }
        }
    }

    override fun ResultDialogBox(mensaje: String?) {
        binding.txtMessage.text = mensaje
        if (mensaje != null) {
            sendMessage(mensaje)
        }else{
            Toast.makeText(this, "Write a question!!", Toast.LENGTH_LONG).show()
        }
    }

    fun sendMessage(msg: String){
        SocketHandler.getSocket().emit("sendmsg", msg)
    }

    override fun ResponseDialogBox(mensaje: String?) {
        binding.txtMessage.text = mensaje
        if (mensaje != null) {
            sendResponse(mensaje)
        }else{
            Toast.makeText(this, "Response the question!!!", Toast.LENGTH_LONG).show()
        }
    }

    fun sendResponse(msg: String){
        SocketHandler.getSocket().emit("sendres", msg)
    }

}