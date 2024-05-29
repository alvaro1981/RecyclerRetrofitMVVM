package com.example.recyclerretrofitmvvm.data.network

import com.example.recyclerretrofitmvvm.data.network.response.CharactersResponse
import retrofit2.http.GET

interface RickMortiApiClient {

    @GET("character/?page=25")
     suspend fun getCharacters():CharactersResponse

}