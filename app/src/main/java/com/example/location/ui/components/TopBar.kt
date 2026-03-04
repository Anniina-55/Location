package com.example.location.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    canNavigateBack: Boolean,
    onBackClick: () -> Unit,
    onMenuItemClick: (String) -> Unit,
    colors: androidx.compose.material3.TopAppBarColors =
        TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
) {
    var expanded by remember { mutableStateOf(false) }

    androidx.compose.material3.TopAppBar(
        modifier = modifier,
        title = {Text(title)},
        colors = colors,
        actions = {
            if (canNavigateBack) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back arrow button",
                    )
                }
            } else {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu button",
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },

                ) {
                    DropdownMenuItem(
                        text = {
                            androidx.compose.foundation.layout.Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = androidx.compose.ui.Alignment.Center
                            ) {
                                Text("Location")
                            }
                        },
                        onClick = {
                            expanded = false
                            onMenuItemClick("location")
                        }
                    )
                }
            }
        }
    )

}


