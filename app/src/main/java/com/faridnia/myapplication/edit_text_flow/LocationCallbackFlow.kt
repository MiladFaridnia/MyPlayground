package com.faridnia.myapplication.edit_text_flow

import android.location.Location
import android.os.Looper
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun locationCallbackFlow() : Flow<Location>  = callbackFlow {
    val fusedClient = LocationServices.getFusedLocationProviderClient(this@locationFlow)

    val callBack = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            super.onLocationResult(result)

            trySend(result.locations.first())
        }

    }

    val request = LocationRequest.create().apply {
        interval = 5000
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    fusedClient.requestLocationUpdates(
        request,
        callBack,
        Looper.getMainLooper()
    )

    awaitClose {
        fusedClient.removeLocationUpdates(callBack)
    }
}