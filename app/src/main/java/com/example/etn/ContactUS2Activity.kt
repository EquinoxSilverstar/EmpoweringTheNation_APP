package com.example.etn

import Customs
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.etn.databinding.ActivityContactUs2Binding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ContactUS2Activity : AppCompatActivity(), AdapterView.OnItemSelectedListener, OnMapReadyCallback {

    private lateinit var binding: ActivityContactUs2Binding
    private lateinit var mapView: MapView
    private var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ensure proper view binding
        binding = ActivityContactUs2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the MapView
        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        // Initialize Spinner
        val spinner = binding.xmlSpinner

        // Spinner data
        val texts = arrayOf(
            "Select a venue",
            "Southdale",
            "Braamfontein",
            "Soweto",
        )

        // Set up the custom adapter
        val customAdapter = Customs(this, texts)
        spinner.adapter = customAdapter
        spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> setMapLocation(LatLng(-26.2041, 28.0473))
            1 -> setMapLocation(LatLng(-26.2431, 28.0135))// Sydney
            2-> setMapLocation(LatLng(-26.1926, 28.0301))  // San Francisco
            3 -> setMapLocation(LatLng(-26.2485, 27.8540))    // London
        }
    }

    private fun setMapLocation(latLng: LatLng) {
        googleMap?.let {
            it.clear()
            it.addMarker(MarkerOptions().position(latLng).title("Selected Location"))
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12f))
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Optional: Handle case where nothing is selected
    }

    // Handle MapView Lifecycle
    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}
