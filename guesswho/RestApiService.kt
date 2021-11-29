package mx.com.fullcomputer.guesswho

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class RestApiService {

    // Metodo de SingIn para ingresar a la App
    fun signIn(userInfo: UserInfo, onResult: (SignInResponse?) -> Unit){
        val retrofit = ServiceBuilder.buildService(APIService::class.java)
        retrofit.signIn(userInfo).enqueue(
            object : Callback<SignInResponse> {

                override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(
                    call: Call<SignInResponse>,
                    response: Response<SignInResponse>
                ) {
                    val res = response.body()
                    onResult(res)
                }
            }
        )
    }

    // Metodo de SignUp para registrar a un nuevo Player
    fun signUp(userInfo: UserInfo, onResult: (SignInResponse?) -> Unit){
        val retrofit = ServiceBuilder.buildService(APIService::class.java)
        retrofit.signUp(userInfo).enqueue(
            object : Callback<SignInResponse> {
                override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(
                    call: Call<SignInResponse>,
                    response: Response<SignInResponse>
                ) {
                    val res = response.body()
                    onResult(res)
                }
            }
        )
    }



}