package com.faridnia.myapplication.location_flow

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

@SuppressLint("MissingPermission")
fun Context.locationFlow(provider: String = LocationManager.GPS_PROVIDER): Flow<Location> =
    callbackFlow {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val listener = LocationListener { location ->
            trySend(location).isSuccess // Emit the location to the Flow
        }

        /*override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}*/

        locationManager.requestLocationUpdates(
            provider,
            1000L, // Minimum time interval (ms)
            10f,   // Minimum distance (meters)
            listener
        )

        awaitClose {
            locationManager.removeUpdates(listener) // Cleanup when Flow is cancelled
        }
    }