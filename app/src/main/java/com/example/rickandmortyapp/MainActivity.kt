package com.example.rickandmortyapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.network.TestFile
import com.example.network.character.models.domain.Character
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import com.example.rickandmortyapp.viewmodels.CharacterUiState
import com.example.rickandmortyapp.viewmodels.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyAppTheme {

            }
        }
    }
}

@Composable
fun Greeting(
    viewModel: CharacterViewModel = hiltViewModel(),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = Unit, block = {
        viewModel.fetchCharacter(1)
    })

    val uiState by viewModel.characterUiState.collectAsState()

    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        when (val state = uiState) {
            is CharacterUiState.Loading -> {
                CircularProgressIndicator()
            }
            is CharacterUiState.Success -> {
                TestFile(
                    character = state.character,
                    modifier = Modifier.padding(innerPadding)
                )
            }
            is CharacterUiState.Error -> { /*TODO*/ }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMortyAppTheme {
        Greeting()
    }
}