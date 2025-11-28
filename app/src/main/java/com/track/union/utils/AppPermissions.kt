package com.track.union.utils

import android.Manifest.permission.*
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.permissionx.guolindev.PermissionX
import com.track.union.R

/**
 * AppPermissions is a utility object that handles runtime permission requests
 * using PermissionX for various Android permissions including location, camera,
 * storage, microphone, contacts, and notifications.
 */
object AppPermissions {

    /**
     * Checks and requests fine and coarse location permissions.
     * @param context The application context or activity.
     * @param onPermissionGranted Callback invoked when permission is granted.
     */
    fun checkLocationPermission(context: Context, onPermissionGranted: () -> Unit) {
        requestPermissionsIfNeeded(
            context,
            listOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION),
            onPermissionGranted
        )
    }

    fun isLocationEnabled(context: Context): Boolean {
        val locationManager = context.getSystemService(LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    /**
     * Checks and requests notification permission (Android 13+ only).
     * @param context The application context or activity.
     * @param onPermissionGranted Callback invoked when permission is granted.
     */
    fun checkNotificationPermission(context: Context, onPermissionGranted: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissionsIfNeeded(
                context,
                listOf(POST_NOTIFICATIONS),
                onPermissionGranted
            )
        } else {
            onPermissionGranted()
        }
    }

    /**
     * Checks and requests media projection-related permissions.
     * @param context The application context or activity.
     * @param onPermissionGranted Callback invoked when permission is granted.
     */
    fun checkMediaProjectionPermission(context: Context, onPermissionGranted: () -> Unit) {
        val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            listOf(FOREGROUND_SERVICE_MEDIA_PROJECTION)
        } else {
            listOf(RECORD_AUDIO, CAMERA)
        }
        requestPermissionsIfNeeded(context, permissions, onPermissionGranted)
    }

    /**
     * Checks and requests camera permission.
     * @param context The application context or activity.
     * @param onPermissionGranted Callback invoked when permission is granted.
     */
    fun checkCameraPermission(context: Context, onPermissionGranted: () -> Unit) {
        requestPermissionsIfNeeded(context, listOf(CAMERA), onPermissionGranted)
    }

    /**
     * Checks and requests permission to access gallery or external storage.
     * @param context The application context or activity.
     * @param onPermissionGranted Callback invoked when permission is granted.
     */
    fun checkGalleryPermission(context: Context, onPermissionGranted: () -> Unit) {
        val galleryPermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            READ_MEDIA_IMAGES else READ_EXTERNAL_STORAGE
        requestPermissionsIfNeeded(context, listOf(galleryPermission), onPermissionGranted)
    }

    /**
     * Checks and requests microphone/audio recording permission.
     * @param context The application context or activity.
     * @param onPermissionGranted Callback invoked when permission is granted.
     */
    fun checkMicrophonePermission(context: Context, onPermissionGranted: () -> Unit) {
        requestPermissionsIfNeeded(context, listOf(RECORD_AUDIO), onPermissionGranted)
    }

    /**
     * Checks and requests permission to read contacts.
     * @param context The application context or activity.
     * @param onPermissionGranted Callback invoked when permission is granted.
     */
    fun checkContactPermission(context: Context, onPermissionGranted: () -> Unit) {
        requestPermissionsIfNeeded(context, listOf(READ_CONTACTS), onPermissionGranted)
    }

    /**
     * Core utility method to check for missing permissions and prompt the user if needed.
     * Uses PermissionX to handle explanation dialogs and redirection to settings if necessary.
     *
     * @param context The application context (must be a FragmentActivity).
     * @param permissions The list of permissions to request.
     * @param onPermissionGranted Callback invoked when all permissions are granted.
     */
    private fun requestPermissionsIfNeeded(
        context: Context,
        permissions: List<String>,
        onPermissionGranted: () -> Unit
    ) {
        val missingPermissions = permissions.filter {
            ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
        }

        if (missingPermissions.isEmpty()) {
            onPermissionGranted()
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                val activity = context as? FragmentActivity ?: return@postDelayed

                PermissionX.init(activity)
                    .permissions(missingPermissions)
                    .onExplainRequestReason { scope, deniedList ->
                        scope.showRequestReasonDialog(
                            deniedList,
                            context.getString(R.string.permission_message),
                            context.getString(R.string.def_ok),
                            context.getString(R.string.def_cancel)
                        )
                    }
                    .onForwardToSettings { scope, deniedList ->
                        scope.showForwardToSettingsDialog(
                            deniedList,
                            context.getString(R.string.permission_request_message),
                            context.getString(R.string.def_ok),
                            context.getString(R.string.def_cancel)
                        )
                    }
                    .request { allGranted, _, _ ->
                        if (allGranted) {
                            Handler(Looper.getMainLooper()).post {
                                onPermissionGranted()
                            }
                        }
                    }
            }, 200)
        }
    }
}