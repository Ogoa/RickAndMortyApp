package com.example.network.character.models.remote

import androidx.compose.ui.text.toLowerCase
import com.example.network.character.models.domain.Character
import com.example.network.character.models.domain.CharacterGender
import com.example.network.character.models.domain.CharacterStatus
import kotlinx.serialization.Serializable
import java.util.Locale

@Serializable
data class RemoteCharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) {
    @Serializable
    data class Location(
        val name: String,
        val url: String
    )

    @Serializable
    data class Origin(
        val name: String,
        val url: String
    )
}


fun RemoteCharacter.toDomainCharacter(): Character {
    val characterStatus = when(status.lowercase(Locale.getDefault())) {
        "alive" -> CharacterStatus.Alive
        "dead" -> CharacterStatus.Dead
        else -> CharacterStatus.Unknown
    }

    val characterGender = when(gender.lowercase(Locale.getDefault())) {
        "male" -> CharacterGender.Male
        "female" -> CharacterGender.Female
        "genderless" -> CharacterGender.Genderless
        else -> CharacterGender.Unknown
    }

    return Character(
        id = id,
        name = name,
        status = characterStatus,
        species = species,
        type = type,
        gender = characterGender,
        origin = origin,
        location = location,
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}

