package mx.com.fullcomputer.guesswho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mx.com.fullcomputer.guesswho.databinding.ActivitySignInBinding
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create



class SignIn : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Para consumir la API
        val apiService = RestApiService()

        // Para ingresar al juego
        binding.btnLogin.setOnClickListener {
            if (checkIfFieldsFull()) {
                val userInfo = UserInfo(
                    email = binding.txtEmail.text.toString(),
                    password = binding.txtPassword.text.toString()
                )

                // Se utiliza API con el metodo SignIn para ingresar al juego
                apiService.signIn(userInfo) {
                    if (it?.status != null) {
                        if (it.status) {
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                            val intent = Intent(this, Menu::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        }
                    } else {
                        showError()
                    }
                }
            }
        }

        // Para ir a registrar un nuevo Player
        binding.btnLoginToRegister.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        // Para salir de la App
        binding.btnExit.setOnClickListener { finish() }

    }

    // Verifica que los campos no san nulos o esten vacios
    fun checkIfFieldsFull(): Boolean {
        if (
            binding.txtEmail.text.isNullOrEmpty() ||
            binding.txtPassword.text.isNullOrEmpty()
        ) {
            Toast.makeText(this, "Es necesario llenar todos los campos", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    // Muestra que ha ocurrido un error
    fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}












    //        {
//        searchHello("Hola")
//        val apiService = RestApiService()
//        val userInfo = UserInfo(nickname = "Lalo", email = "lalo@lalo.com", password = "lalo")

//        apiService.signIn(userInfo){
//            if (it?.status != null){
//                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
//            }else{
//                showError()
//            }
//        }
//    }


//    private fun getRetrofit():Retrofit{
//        return Retrofit.Builder()
//            .baseUrl("http://10.0.2.2:3000/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

//    private fun searchHello(query:String){
//        CoroutineScope(Dispatchers.IO).launch {
//            val call: Response<SignInResponse> = getRetrofit().create(APIService::class.java).getHello("hello")
//            val puppies: SignInResponse? = call.body()
//            runOnUiThread {
//                if(call.isSuccessful){
//                    val res = puppies?.status ?: false
//                    val msg:String = puppies?.message ?: "No funciona"
//                    showMsg(msg)
//                }else{
//                    showError()
//                }
//            }
//        }
//    }
//
//    fun showMsg(msg: String){
//        Toast.makeText(this, msg.toString(), Toast.LENGTH_SHORT).show()
//    }
