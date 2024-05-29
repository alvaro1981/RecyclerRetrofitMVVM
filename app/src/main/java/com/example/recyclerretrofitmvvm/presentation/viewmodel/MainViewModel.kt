package com.example.recyclerretrofitmvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerretrofitmvvm.data.model.CharacterModel
import com.example.recyclerretrofitmvvm.data.network.RickMortiApiService
import com.example.recyclerretrofitmvvm.data.network.response.CharactersResponse
import com.example.recyclerretrofitmvvm.data.network.response.Location
import com.example.recyclerretrofitmvvm.data.network.response.Origin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    val _characterList = MutableLiveData<MutableList<CharacterModel>>()
    private var serviceApi = RickMortiApiService()

    val characterListLV:LiveData<MutableList<CharacterModel>>
        get()=_characterList


    init{
        viewModelScope.launch {
            _characterList.value = fetchCharacters()
        }
    }

    private suspend fun fetchCharacters():MutableList<CharacterModel> {
        return withContext(Dispatchers.IO){
            val charactersResponse:CharactersResponse = serviceApi.getCharacterPage()
            val charactersList = parserCharacters(charactersResponse)
            charactersList

        }
    }

    private fun parserCharacters(charactersResponse: CharactersResponse)
    :MutableList<CharacterModel>{
        val rickMortisCharactersList = mutableListOf<CharacterModel>()
        val resultsList = charactersResponse. results

        for( result in resultsList){
            val  localizacion:Location = result.location
            val  origen   : Origin = result.origin
            val location = localizacion.name
            val origin = origen.name
            val  id = result.id
            val name  = result.name
            val species = result.species
            val gender  = result.gender
            val image   = result.image
            val created = result.created
            rickMortisCharactersList.add(CharacterModel(id,name,species,gender,location,origin,image,created))

        }
        return rickMortisCharactersList
    }

}