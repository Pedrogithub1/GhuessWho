package mx.com.fullcomputer.guesswho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import mx.com.fullcomputer.guesswho.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Para consumir la API
        val apiService = RestApiService()

        binding.btnRegisterToLogin.setOnClickListener { finish() }

        binding.btnRegister.setOnClickListener {
            if(checkIfFieldsFull()){
                val userInfo = UserInfo(
                    nickname = binding.txtRegNickname.text.toString(),
                    email = binding.txtRegEmail.text.toString(),
                    password = binding.txtRegPassword.text.toString())

                // Se utiliza el metodo SignUp para registrar a un usuario
                apiService.signUp(userInfo){
                    if (it?.status != null){
                        if (it.status){
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        }
                    }else{
                        showError()
                    }
                }
            }
        }

    }

    // Verifica que los campos no san nulos o esten vacios
    fun checkIfFieldsFull(): Boolean{
        if(
            binding.txtRegNickname.text.isNullOrEmpty() ||
            binding.txtRegEmail.text.isNullOrEmpty() ||
            binding.txtRegPassword.text.isNullOrEmpty()
        ){
            Toast.makeText(this, "Es necesario llenar todos los campos", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    // Muestra que ha ocurrido un error
    fun showError(){
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}