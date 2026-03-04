package com.example.location.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.location.model.LocationLiveData


class LocationViewModel(context: Context) : ViewModel() {
    private val locationLiveData = LocationLiveData(context)
    fun getLocationLiveData() = locationLiveData
}