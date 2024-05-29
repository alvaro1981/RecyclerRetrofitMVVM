package com.example.recyclerretrofitmvvm.data.network

import com.example.recyclerretrofitmvvm.data.network.response.CharactersResponse
import com.example.recyclerretrofitmvvm.domain.RetrofitHelper
import retrofit2.create

class RickMortiApiService {

    private val helperRetrofit = RetrofitHelper.getRetrofit()

   suspend  fun  getCharacterPage():CharactersResponse{
        val response:CharactersResponse = helperRetrofit.create(RickMortiApiClient::class.java).getCharacters()
        return response
    }
}