package com.example.data_activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.gson.Gson

class PetDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_details)

            val prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val gson = Gson()

            val petKey = intent.getStringExtra("selected_pet_key") ?: ""

            val petJson = prefs.getString(petKey, null)
            val selectedPet = gson.fromJson(petJson, Pet::class.java)

            if (selectedPet != null) {
                val petNameTextView = findViewById<TextView>(R.id.PetNameDetailsTv)
                val petSpeciesTextView = findViewById<TextView>(R.id.PetSpeiesTv)
                val petAgeTextView = findViewById<TextView>(R.id.PetAgeDetailsTv)

                petNameTextView.text = selectedPet.name
                petSpeciesTextView.text = selectedPet.species
                petAgeTextView.text = "${selectedPet.age}"
            }
        }
    }