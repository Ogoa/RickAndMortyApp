package com.example.network

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.network.character.models.domain.Character

@Composable
fun TestFile(character: Character, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Hello ${character.name}!",
            modifier = modifier
        )
        Text(
            text = "Gender: ${character.gender}!",
            modifier = modifier
        )
        Text(
            text = "Status: ${character.status}!",
            modifier = modifier
        )
        Text(
            text = "Species: ${character.species}!",
            modifier = modifier
        )
    }
}