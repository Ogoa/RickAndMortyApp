package com.example.rickandmortyapp.repositories

import com.example.network.ApiOperation
import com.example.network.KtorClient
import javax.inject.Inject
import com.example.network.character.models.domain.Character

class CharacterRepository @Inject constructor(
    private val ktorClient: KtorClient
) {

    suspend fun fetchCharacter(id: Int): ApiOperation<Character> {
        return ktorClient.getCharacter(id)
    }
}