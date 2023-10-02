package com.example.data_activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson

class VehicleDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_details)
        val gson = Gson()
        val vehicleJson = intent.getStringExtra("vehicle")

        if (vehicleJson != null) {
            val selectedVehicle = gson.fromJson(vehicleJson, Vehicle::class.java)
            val brandTextView = findViewById<TextView>(R.id.VehicleBrandActivityTv)
            val modelTextView = findViewById<TextView>(R.id.VehicleModelActivityTv)
            val yearTextView = findViewById<TextView>(R.id.VehicleProdYearActivityTv)

            brandTextView.text = selectedVehicle.brand
            modelTextView.text = selectedVehicle.model
            yearTextView.text = selectedVehicle.productionYear.toString()
        } else {
            Toast.makeText(applicationContext, "No value", Toast.LENGTH_SHORT).show()        }}}


