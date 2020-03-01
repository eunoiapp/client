package eunoiapp.app

import android.content.IntentSender
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task

fun createLocationRequest() {
    val locationRequest = LocationRequest.create().apply {
        interval = 500000 // 8,3min
        fastestInterval = 100000
        priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
    }

    val builder = LocationSettingsRequest.Builder()
        .addLocationRequest(locationRequest)

    val client: SettingsClient = LocationServices.getSettingsClient(this)
    val task : Task<LocationSettingsResponse>

    task.addOnSuccessListener { locationSettingsResponse ->
        // All location settings are satisfied. The client can initialize
        // location requests here.
        // ...
        startLocationUpdates()

        private fun startLocationUpdates() {
            fusedLocationClient.requestLocationUpdates(locationRequest,
                locationCallback,
                null /* Looper */)

    }


    val REQUEST_CHECK_SETTINGS = 5
    task.addOnFailureListener { exception ->
        if (exception is ResolvableApiException){
            // Location settings are not satisfied, but this can be fixed
            // by showing the user a dialog.
            try {
                // Show the dialog by calling startResolutionForResult(),
                // and check the result in onActivityResult().
                exception.startResolutionForResult(this@LocationGetter,
                    REQUEST_CHECK_SETTINGS)
            } catch (sendEx: IntentSender.SendIntentException) {
                // Ignore the error.
            }
        }
    }
}