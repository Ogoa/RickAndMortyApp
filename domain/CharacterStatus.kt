package com.example.network.character.models.domain

sealed class CharacterStatus(val status: String) {
    object Alive: CharacterStatus(status = "Alive")
    object Dead: CharacterStatus(status = "Dead")
    object Unknown: CharacterStatus(status = "Unknown")
}