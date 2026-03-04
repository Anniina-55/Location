package com.example.location.ui.screens


import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.location.viewmodel.LocationViewModel

@Composable
fun LocationScreen(
    navController: NavController,
    viewModel: LocationViewModel
) {
    val location by viewModel.getLocationLiveData().observeAsState()
    if (location !== null) {
    // Do something based on location, e.g. retrieve data from API.
    }
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { isGranted: Boolean ->
                if (isGranted) {
                    viewModel.getLocationLiveData().getLocationData()
                }
            }
        )
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Find out your location",
            modifier = Modifier.padding(top = 28.dp, bottom = 16.dp),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "Latitude: " + location?.latitude.toString(),
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Longitude: " + location?.longitude.toString(),
            modifier = Modifier.padding(top = 4.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button (
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            onClick = {
                requestPermissionLauncher.
                launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
            }
        ) {
            Text("Get location")
        }
    }

}