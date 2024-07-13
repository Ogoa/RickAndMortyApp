package com.example.network.character.models.domain

sealed class CharacterGender(val gender: String) {
    object Male: CharacterGender(gender = "Male")
    object Female: CharacterGender(gender = "Female")
    object Genderless: CharacterGender(gender = "Genderless")
    object Unknown: CharacterGender(gender = "unknown")
}