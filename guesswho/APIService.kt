package mx.com.fullcomputer.guesswho

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface APIService {
    @GET
    suspend fun getHello(@Url url: String):Response<SignInResponse>

    @Headers("Content-Type: application/json")
    @POST("signin")
    fun signIn(@Body userInfo: UserInfo): Call<SignInResponse>

    @Headers("Content-Type: application/json")
    @POST("signup")
    fun signUp(@Body userInfo: UserInfo):Call<SignInResponse>
}