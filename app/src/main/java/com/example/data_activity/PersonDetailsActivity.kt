package com.example.data_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PersonDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_details)

        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val age = intent.getIntExtra("age", 0)

        val selectedPerson = Person(name ?: "", address ?: "", age)

            val nameTextView = findViewById<TextView>(R.id.PersonNameTv)
            val addressTextView = findViewById<TextView>(R.id.PersonAddressTv)
            val ageTextView = findViewById<TextView>(R.id.PersonAgeTv)

            nameTextView.text = selectedPerson.name
            addressTextView.text = selectedPerson.address
            ageTextView.text = selectedPerson.age.toString()

    }
}