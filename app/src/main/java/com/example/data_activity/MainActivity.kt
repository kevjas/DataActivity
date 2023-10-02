package com.example.data_activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personList = ArrayList<Person>()
        val vehicleList = ArrayList<Vehicle>()
        val petList = ArrayList<Pet>()

        personList.add(Person("Alice", "23 Main St", 37))
        personList.add(Person("Stefan", "3 Main St", 22))
        personList.add(Person("Johan", "Main St", 52))

        vehicleList.add(Vehicle("Toyota", "Camry", 2020))
        vehicleList.add(Vehicle("VW", "Golf", 2015))
        vehicleList.add(Vehicle("Volvo", "V60", 2001))

        val vehicleListview = findViewById<ListView>(R.id.VehicleLv)
        val vehicleAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, vehicleList)
        vehicleListview.adapter = vehicleAdapter

        vehicleListview.setOnItemClickListener { _, _, position, _ ->
            val gson = Gson()
            val selectedVehicle = vehicleList[position]
            val vehicleJson = gson.toJson(selectedVehicle)

            val intent = Intent(this, VehicleDetailsActivity::class.java)
            intent.putExtra("vehicle", vehicleJson)
            startActivity(intent)

        }
        val personListView = findViewById<ListView>(R.id.PersonLv)
        val personAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, personList)
        personListView.adapter = personAdapter

        personListView.setOnItemClickListener { parent, view, position, _ ->
            val selectedPersonString = personList[position].toString()
            val selectedPerson = Person.fromString(selectedPersonString)

            if (selectedPerson != null) {
                val intent = Intent(this, PersonDetailsActivity::class.java)
                intent.putExtra("name", selectedPerson.name)
                intent.putExtra("address", selectedPerson.address)
                intent.putExtra("age", selectedPerson.age)
                startActivity(intent)
            }
        }
        val prefs: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val gson = Gson()

        val prefsEditor = prefs.edit()

        val pet1 = Pet("Gustav", "Cat", 3)
        val pet2 = Pet("Chico", "Dog", 2)
        val pet3 = Pet("Dennis", "Rabbit", 5)

        petList.add(pet1)
        petList.add(pet2)
        petList.add(pet3)

        for (i in 0 until petList.size) {
            val key = "pet_data_${i + 1}"
            val petJson = gson.toJson(petList[i])
            prefsEditor.putString(key, petJson)
        }

        prefsEditor.apply()

        val petListView = findViewById<ListView>(R.id.PetLv)
        val petAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, petList)
        petListView.adapter = petAdapter

        petListView.setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(this, PetDetailsActivity::class.java)
            val selectedPetKey = "pet_data_${i + 1}"
            intent.putExtra("selected_pet_key", selectedPetKey)
            startActivity(intent)
        }
    }
}


