package com.frenzelts.team99.listingdetail.listener

import android.content.Context
import android.content.Intent
import android.net.Uri

class ListingDetailCallback(
    private val context: Context
): ListingDetailListener {
    override fun onViewMapClicked(long: Float, lat: Float, label: String) {
        val strUri = "http://maps.google.com/maps?q=loc:$lat,$long($label)"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(strUri))
        intent.setClassName(
            "com.google.android.apps.maps",
            "com.google.android.maps.MapsActivity"
        )

        context.startActivity(intent)
    }
}