package mx.pemg.guesswho

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

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

        val imageView1 = findViewById<View>(R.id.imageView1) as ImageView
        val imageView2 = findViewById<View>(R.id.imageView2) as ImageView
        val imageView3 = findViewById<View>(R.id.imageView3) as ImageView
        val imageView4 = findViewById<View>(R.id.imageView4) as ImageView
        val imageView5 = findViewById<View>(R.id.imageView5) as ImageView
        val imageView6 = findViewById<View>(R.id.imageView6) as ImageView
        val imageView7 = findViewById<View>(R.id.imageView7) as ImageView
        val imageView8 = findViewById<View>(R.id.imageView8) as ImageView
        val imageView9 = findViewById<View>(R.id.imageView9) as ImageView
        val imageView10 = findViewById<View>(R.id.imageView10) as ImageView
        val imageView11 = findViewById<View>(R.id.imageView11) as ImageView
        val imageView12 = findViewById<View>(R.id.imageView12) as ImageView
        val imageView13 = findViewById<View>(R.id.imageView13) as ImageView
        val imageView14 = findViewById<View>(R.id.imageView14) as ImageView
        val imageView15 = findViewById<View>(R.id.imageView15) as ImageView
        val imageView16 = findViewById<View>(R.id.imageView16) as ImageView
        val imageView17 = findViewById<View>(R.id.imageView17) as ImageView
        val imageView18 = findViewById<View>(R.id.imageView18) as ImageView
        val imageView19 = findViewById<View>(R.id.imageView19) as ImageView
        val imageView20 = findViewById<View>(R.id.imageView20) as ImageView
        val imageView21 = findViewById<View>(R.id.imageView21) as ImageView
        val imageView22 = findViewById<View>(R.id.imageView22) as ImageView
        val imageView23 = findViewById<View>(R.id.imageView23) as ImageView
        val imageView24 = findViewById<View>(R.id.imageView24) as ImageView
        val imageView25 = findViewById<View>(R.id.imageView25) as ImageView

        val txtName1 = findViewById<View>(R.id.txtName1) as TextView
        val txtName2 = findViewById<View>(R.id.txtName2) as TextView
        val txtName3 = findViewById<View>(R.id.txtName3) as TextView
        val txtName4 = findViewById<View>(R.id.txtName4) as TextView
        val txtName5 = findViewById<View>(R.id.txtName5) as TextView
        val txtName6 = findViewById<View>(R.id.txtName6) as TextView
        val txtName7 = findViewById<View>(R.id.txtName7) as TextView
        val txtName8 = findViewById<View>(R.id.txtName8) as TextView
        val txtName9 = findViewById<View>(R.id.txtName9) as TextView
        val txtName10 = findViewById<View>(R.id.txtName10) as TextView
        val txtName11 = findViewById<View>(R.id.txtName11) as TextView
        val txtName12 = findViewById<View>(R.id.txtName12) as TextView
        val txtName13 = findViewById<View>(R.id.txtName13) as TextView
        val txtName14 = findViewById<View>(R.id.txtName14) as TextView
        val txtName15 = findViewById<View>(R.id.txtName15) as TextView
        val txtName16 = findViewById<View>(R.id.txtName16) as TextView
        val txtName17 = findViewById<View>(R.id.txtName17) as TextView
        val txtName18 = findViewById<View>(R.id.txtName18) as TextView
        val txtName19 = findViewById<View>(R.id.txtName19) as TextView
        val txtName20 = findViewById<View>(R.id.txtName20) as TextView
        val txtName21 = findViewById<View>(R.id.txtName21) as TextView
        val txtName22 = findViewById<View>(R.id.txtName22) as TextView
        val txtName23 = findViewById<View>(R.id.txtName23) as TextView
        val txtName24 = findViewById<View>(R.id.txtName24) as TextView
        val txtName25 = findViewById<View>(R.id.txtName25) as TextView

        val arrayImg = arrayOf(R.drawable.angela, R.drawable.babo, R.drawable.badbunny, R.drawable.beckyg,
                        R.drawable.beyonce, R.drawable.chayanne, R.drawable.dualipa, R.drawable.hannamontana,
                        R.drawable.karolg, R.drawable.katyperry, R.drawable.maluma, R.drawable.manuelturizo,
                        R.drawable.paquita, R.drawable.pepeaguilar, R.drawable.rihanna, R.drawable.romeosantos,
                        R.drawable.rosalia, R.drawable.selenagomez, R.drawable.theweeknd, R.drawable.tupac,
                        R.drawable.valentinelizalde, R.drawable.vicentefernandez, R.drawable.wizkhalifa,
                        R.drawable.shakira)

        val arrayNames = arrayOf("Angela", "Babo", "Bad Bunny", "Becky G", "Beyoncé", "Chayanne", "Dua Lipa",
                            "Hannah Montana", "Karol G", "Katy Perry", "Maluma", "Manuel Turizo", "Paquita",
                            "Pepe Aguilar", "Rihanna", "Romeo Santos", "Rosalía", "Selena Goméz", "The Weeknd",
                            "Tupac", "Valentín Elizalde", "Vicente Fernández", "Wiz Khalifa", "Shakira")

        val arrayRnd = arrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        val arrayFlags = arrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        var cont: Int
        var i=0
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

        val random = (0..23).random()

        imageView1.setImageResource(arrayImg.get(arrayRnd[random]))
        imageView2.setImageResource(arrayImg.get(arrayRnd[0]))
        imageView3.setImageResource(arrayImg.get(arrayRnd[1]))
        imageView4.setImageResource(arrayImg.get(arrayRnd[2]))
        imageView5.setImageResource(arrayImg.get(arrayRnd[3]))
        imageView6.setImageResource(arrayImg.get(arrayRnd[4]))
        imageView7.setImageResource(arrayImg.get(arrayRnd[5]))
        imageView8.setImageResource(arrayImg.get(arrayRnd[6]))
        imageView9.setImageResource(arrayImg.get(arrayRnd[7]))
        imageView10.setImageResource(arrayImg.get(arrayRnd[8]))
        imageView11.setImageResource(arrayImg.get(arrayRnd[9]))
        imageView12.setImageResource(arrayImg.get(arrayRnd[10]))
        imageView13.setImageResource(arrayImg.get(arrayRnd[11]))
        imageView14.setImageResource(arrayImg.get(arrayRnd[12]))
        imageView15.setImageResource(arrayImg.get(arrayRnd[13]))
        imageView16.setImageResource(arrayImg.get(arrayRnd[14]))
        imageView17.setImageResource(arrayImg.get(arrayRnd[15]))
        imageView18.setImageResource(arrayImg.get(arrayRnd[16]))
        imageView19.setImageResource(arrayImg.get(arrayRnd[17]))
        imageView20.setImageResource(arrayImg.get(arrayRnd[18]))
        imageView21.setImageResource(arrayImg.get(arrayRnd[19]))
        imageView22.setImageResource(arrayImg.get(arrayRnd[20]))
        imageView23.setImageResource(arrayImg.get(arrayRnd[21]))
        imageView24.setImageResource(arrayImg.get(arrayRnd[22]))
        imageView25.setImageResource(arrayImg.get(arrayRnd[23]))

        txtName1.setText(arrayNames.get(arrayRnd[random]))
        txtName2.setText(arrayNames.get(arrayRnd[0]))
        txtName3.setText(arrayNames.get(arrayRnd[1]))
        txtName4.setText(arrayNames.get(arrayRnd[2]))
        txtName5.setText(arrayNames.get(arrayRnd[3]))
        txtName6.setText(arrayNames.get(arrayRnd[4]))
        txtName7.setText(arrayNames.get(arrayRnd[5]))
        txtName8.setText(arrayNames.get(arrayRnd[6]))
        txtName9.setText(arrayNames.get(arrayRnd[7]))
        txtName10.setText(arrayNames.get(arrayRnd[8]))
        txtName11.setText(arrayNames.get(arrayRnd[9]))
        txtName12.setText(arrayNames.get(arrayRnd[10]))
        txtName13.setText(arrayNames.get(arrayRnd[11]))
        txtName14.setText(arrayNames.get(arrayRnd[12]))
        txtName15.setText(arrayNames.get(arrayRnd[13]))
        txtName16.setText(arrayNames.get(arrayRnd[14]))
        txtName17.setText(arrayNames.get(arrayRnd[15]))
        txtName18.setText(arrayNames.get(arrayRnd[16]))
        txtName19.setText(arrayNames.get(arrayRnd[17]))
        txtName20.setText(arrayNames.get(arrayRnd[18]))
        txtName21.setText(arrayNames.get(arrayRnd[19]))
        txtName22.setText(arrayNames.get(arrayRnd[20]))
        txtName23.setText(arrayNames.get(arrayRnd[21]))
        txtName24.setText(arrayNames.get(arrayRnd[22]))
        txtName25.setText(arrayNames.get(arrayRnd[23]))

        imageView2.setOnClickListener {
            if(arrayFlags.get(0) == 0){
                imageView2.setImageResource(R.drawable.guesswho)
                txtName2.setText(" ")
                arrayFlags.set(0, 1)
            }
            else{
                imageView2.setImageResource(arrayImg.get(arrayRnd[0]))
                txtName2.setText(arrayNames.get(arrayRnd[0]))
                arrayFlags.set(0, 0)
            }
        }

        imageView3.setOnClickListener {
            if(arrayFlags.get(1) == 0){
                imageView3.setImageResource(R.drawable.guesswho)
                txtName3.setText(" ")
                arrayFlags.set(1, 1)
            }
            else{
                imageView3.setImageResource(arrayImg.get(arrayRnd[1]))
                txtName3.setText(arrayNames.get(arrayRnd[1]))
                arrayFlags.set(1, 0)
            }
        }

        imageView4.setOnClickListener {
            if(arrayFlags.get(2) == 0){
                imageView4.setImageResource(R.drawable.guesswho)
                txtName4.setText(" ")
                arrayFlags.set(2, 1)
            }
            else{
                imageView4.setImageResource(arrayImg.get(arrayRnd[2]))
                txtName4.setText(arrayNames.get(arrayRnd[2]))
                arrayFlags.set(2, 0)
            }
        }

        imageView5.setOnClickListener {
            if(arrayFlags.get(3) == 0){
                imageView5.setImageResource(R.drawable.guesswho)
                txtName5.setText(" ")
                arrayFlags.set(3, 1)
            }
            else{
                imageView5.setImageResource(arrayImg.get(arrayRnd[3]))
                txtName5.setText(arrayNames.get(arrayRnd[3]))
                arrayFlags.set(3, 0)
            }
        }

        imageView6.setOnClickListener {
            if(arrayFlags.get(4) == 0){
                imageView6.setImageResource(R.drawable.guesswho)
                txtName6.setText(" ")
                arrayFlags.set(4, 1)
            }
            else{
                imageView6.setImageResource(arrayImg.get(arrayRnd[4]))
                txtName6.setText(arrayNames.get(arrayRnd[4]))
                arrayFlags.set(4, 0)
            }
        }

        imageView7.setOnClickListener {
            if(arrayFlags.get(5) == 0){
                imageView7.setImageResource(R.drawable.guesswho)
                txtName7.setText(" ")
                arrayFlags.set(5, 1)
            }
            else{
                imageView7.setImageResource(arrayImg.get(arrayRnd[5]))
                txtName7.setText(arrayNames.get(arrayRnd[5]))
                arrayFlags.set(5, 0)
            }
        }

        imageView8.setOnClickListener {
            if(arrayFlags.get(6) == 0){
                imageView8.setImageResource(R.drawable.guesswho)
                txtName8.setText(" ")
                arrayFlags.set(6, 1)
            }
            else{
                imageView8.setImageResource(arrayImg.get(arrayRnd[6]))
                txtName8.setText(arrayNames.get(arrayRnd[6]))
                arrayFlags.set(6, 0)
            }
        }

        imageView9.setOnClickListener {
            if(arrayFlags.get(7) == 0){
                imageView9.setImageResource(R.drawable.guesswho)
                txtName9.setText(" ")
                arrayFlags.set(7, 1)
            }
            else{
                imageView9.setImageResource(arrayImg.get(arrayRnd[7]))
                txtName9.setText(arrayNames.get(arrayRnd[7]))
                arrayFlags.set(7, 0)
            }
        }

        imageView10.setOnClickListener {
            if(arrayFlags.get(8) == 0){
                imageView10.setImageResource(R.drawable.guesswho)
                txtName10.setText(" ")
                arrayFlags.set(8, 1)
            }
            else{
                imageView10.setImageResource(arrayImg.get(arrayRnd[8]))
                txtName10.setText(arrayNames.get(arrayRnd[8]))
                arrayFlags.set(8, 0)
            }
        }

        imageView11.setOnClickListener {
            if(arrayFlags.get(9) == 0){
                imageView11.setImageResource(R.drawable.guesswho)
                txtName11.setText(" ")
                arrayFlags.set(9, 1)
            }
            else{
                imageView11.setImageResource(arrayImg.get(arrayRnd[9]))
                txtName11.setText(arrayNames.get(arrayRnd[9]))
                arrayFlags.set(9, 0)
            }
        }

        imageView12.setOnClickListener {
            if(arrayFlags.get(10) == 0){
                imageView12.setImageResource(R.drawable.guesswho)
                txtName12.setText(" ")
                arrayFlags.set(10, 1)
            }
            else{
                imageView12.setImageResource(arrayImg.get(arrayRnd[10]))
                txtName12.setText(arrayNames.get(arrayRnd[10]))
                arrayFlags.set(10, 0)
            }
        }

        imageView13.setOnClickListener {
            if(arrayFlags.get(11) == 0){
                imageView13.setImageResource(R.drawable.guesswho)
                txtName13.setText(" ")
                arrayFlags.set(11, 1)
            }
            else{
                imageView13.setImageResource(arrayImg.get(arrayRnd[11]))
                txtName13.setText(arrayNames.get(arrayRnd[11]))
                arrayFlags.set(11, 0)
            }
        }

        imageView14.setOnClickListener {
            if(arrayFlags.get(12) == 0){
                imageView14.setImageResource(R.drawable.guesswho)
                txtName14.setText(" ")
                arrayFlags.set(12, 1)
            }
            else{
                imageView14.setImageResource(arrayImg.get(arrayRnd[12]))
                txtName14.setText(arrayNames.get(arrayRnd[12]))
                arrayFlags.set(12, 0)
            }
        }

        imageView15.setOnClickListener {
            if(arrayFlags.get(13) == 0){
                imageView15.setImageResource(R.drawable.guesswho)
                txtName15.setText(" ")
                arrayFlags.set(13, 1)
            }
            else{
                imageView15.setImageResource(arrayImg.get(arrayRnd[13]))
                txtName15.setText(arrayNames.get(arrayRnd[13]))
                arrayFlags.set(13, 0)
            }
        }

        imageView16.setOnClickListener {
            if(arrayFlags.get(14) == 0){
                imageView16.setImageResource(R.drawable.guesswho)
                txtName16.setText(" ")
                arrayFlags.set(14, 1)
            }
            else{
                imageView16.setImageResource(arrayImg.get(arrayRnd[14]))
                txtName16.setText(arrayNames.get(arrayRnd[14]))
                arrayFlags.set(14, 0)
            }
        }

        imageView17.setOnClickListener {
            if(arrayFlags.get(15) == 0){
                imageView17.setImageResource(R.drawable.guesswho)
                txtName17.setText(" ")
                arrayFlags.set(15, 1)
            }
            else{
                imageView17.setImageResource(arrayImg.get(arrayRnd[15]))
                txtName17.setText(arrayNames.get(arrayRnd[15]))
                arrayFlags.set(15, 0)
            }
        }

        imageView18.setOnClickListener {
            if(arrayFlags.get(16) == 0){
                imageView18.setImageResource(R.drawable.guesswho)
                txtName18.setText(" ")
                arrayFlags.set(16, 1)
            }
            else{
                imageView18.setImageResource(arrayImg.get(arrayRnd[16]))
                txtName18.setText(arrayNames.get(arrayRnd[16]))
                arrayFlags.set(16, 0)
            }
        }

        imageView19.setOnClickListener {
            if(arrayFlags.get(17) == 0){
                imageView19.setImageResource(R.drawable.guesswho)
                txtName19.setText(" ")
                arrayFlags.set(17, 1)
            }
            else{
                imageView19.setImageResource(arrayImg.get(arrayRnd[17]))
                txtName19.setText(arrayNames.get(arrayRnd[17]))
                arrayFlags.set(17, 0)
            }
        }

        imageView20.setOnClickListener {
            if(arrayFlags.get(18) == 0){
                imageView20.setImageResource(R.drawable.guesswho)
                txtName20.setText(" ")
                arrayFlags.set(18, 1)
            }
            else{
                imageView20.setImageResource(arrayImg.get(arrayRnd[18]))
                txtName20.setText(arrayNames.get(arrayRnd[18]))
                arrayFlags.set(18, 0)
            }
        }

        imageView21.setOnClickListener {
            if(arrayFlags.get(19) == 0){
                imageView21.setImageResource(R.drawable.guesswho)
                txtName21.setText(" ")
                arrayFlags.set(19, 1)
            }
            else{
                imageView21.setImageResource(arrayImg.get(arrayRnd[19]))
                txtName21.setText(arrayNames.get(arrayRnd[19]))
                arrayFlags.set(19, 0)
            }
        }

        imageView22.setOnClickListener {
            if(arrayFlags.get(20) == 0){
                imageView22.setImageResource(R.drawable.guesswho)
                txtName22.setText(" ")
                arrayFlags.set(20, 1)
            }
            else{
                imageView22.setImageResource(arrayImg.get(arrayRnd[20]))
                txtName22.setText(arrayNames.get(arrayRnd[20]))
                arrayFlags.set(20, 0)
            }
        }

        imageView23.setOnClickListener {
            if(arrayFlags.get(21) == 0){
                imageView23.setImageResource(R.drawable.guesswho)
                txtName23.setText(" ")
                arrayFlags.set(21, 1)
            }
            else{
                imageView23.setImageResource(arrayImg.get(arrayRnd[21]))
                txtName23.setText(arrayNames.get(arrayRnd[21]))
                arrayFlags.set(21, 0)
            }
        }

        imageView24.setOnClickListener {
            if(arrayFlags.get(22) == 0){
                imageView24.setImageResource(R.drawable.guesswho)
                txtName24.setText(" ")
                arrayFlags.set(22, 1)
            }
            else{
                imageView24.setImageResource(arrayImg.get(arrayRnd[22]))
                txtName24.setText(arrayNames.get(arrayRnd[22]))
                arrayFlags.set(22, 0)
            }
        }

        imageView25.setOnClickListener {
            if(arrayFlags.get(23) == 0){
                imageView25.setImageResource(R.drawable.guesswho)
                txtName25.setText(" ")
                arrayFlags.set(23, 1)
            }
            else{
                imageView25.setImageResource(arrayImg.get(arrayRnd[23]))
                txtName25.setText(arrayNames.get(arrayRnd[23]))
                arrayFlags.set(23, 0)
            }
        }
        
    }

    override fun ResultDialogBox(mensaje: String?) {
        txtMessage!!.text = mensaje
    }
    
}
