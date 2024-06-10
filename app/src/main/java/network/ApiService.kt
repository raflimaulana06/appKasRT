package network


import model.ResponseUser
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(".")
    fun getUsers(): Call<ResponseUser>

    @GET(value = ".")
    fun getPemanfaatan(): Call<ResponseUser>

}