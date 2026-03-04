package com.example.location.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.graphics.Color

@Composable
fun Greeting(
        name: String,
        modifier: Modifier = Modifier,
        style: TextStyle = MaterialTheme.typography.headlineMedium,
        color: Color = MaterialTheme.colorScheme.secondary
        ) {
    Text(
        text = "Hello, $name!",
        modifier = modifier,
        style = style,
        color = color
    )
}