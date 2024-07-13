package com.example.rickandmortyapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.ApiOperation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.network.character.models.domain.Character
import com.example.rickandmortyapp.repositories.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    private val _characterUiState = MutableStateFlow<CharacterUiState>(CharacterUiState.Loading)
    val characterUiState = _characterUiState.asStateFlow()

    fun fetchCharacter(characterId: Int) = viewModelScope.launch {
        characterRepository.fetchCharacter(characterId)
            .onSuccess { character ->
                _characterUiState.update {
                    return@update CharacterUiState.Success(character = character)
                }
            }
            .onFailure { e ->
                _characterUiState.update {
                    return@update CharacterUiState.Error(
                        message = e.message ?: "Unknown Error Occurred"
                    )
                }
            }
    }
}

sealed interface CharacterUiState {
    data class Success(val character: Character) : CharacterUiState
    data class Error(val message: String) : CharacterUiState
    object Loading : CharacterUiState
}