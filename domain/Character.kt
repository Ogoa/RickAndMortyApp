package com.example.network.character.models.domain

import com.example.network.character.models.remote.RemoteCharacter

data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val type: String,
    val gender: CharacterGender,
    val origin: RemoteCharacter.Origin,
    val location: RemoteCharacter.Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)
