package com.example.recyclerretrofitmvvm.presentation.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerretrofitmvvm.data.model.CharacterModel
import com.example.recyclerretrofitmvvm.databinding.CharacterItemBinding
import com.squareup.picasso.Picasso

class RickandMortyAdapter:RecyclerView.Adapter<RickandMortyAdapter.RickandMortyViewHolder>() {

    var charactersRickandMorty = mutableListOf<CharacterModel>()
        @SuppressLint("NotifyDataSetChanged")
        set(value){
            field = value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):RickandMortyViewHolder {
       val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RickandMortyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RickandMortyAdapter.RickandMortyViewHolder,
        position: Int
    ) {
        val characterRickandMorty : CharacterModel = charactersRickandMorty[position]
        holder.bind(characterRickandMorty )
    }

    override fun getItemCount(): Int = charactersRickandMorty.size
    /*override fun getItemCount(): Int {
        return charactersRickandMorty.size
    }*/
     inner class RickandMortyViewHolder(private var binding: CharacterItemBinding)
        :RecyclerView.ViewHolder(binding.root) {
        fun bind(RickAndMortyCharacter: CharacterModel) {
            binding.tvEspecie.text = RickAndMortyCharacter.species
            binding.tvIdPersonaje.text = RickAndMortyCharacter.id.toString()
            binding.tvGenero.text= RickAndMortyCharacter.gender
            binding.tvFrechaCreacion.text=RickAndMortyCharacter.created
            binding.tvNombrePersonaje.text=RickAndMortyCharacter.name

            Picasso.get()
                .load(RickAndMortyCharacter.image )
                .resize(50, 50)
                .centerCrop()
                .into(binding.ivCharacterImage)

        }
     }
}