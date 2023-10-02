package com.example.data_activity

data class Person(val name: String, val address: String, val age: Int) {
    override fun toString(): String {
        return "$name, $address, $age år"
    }

    companion object {
        fun fromString(input: String): Person? {
            val parts = input.split(", ")
            if (parts.size == 3) {
                val name = parts[0]
                val address = parts[1]
                val ageString = parts[2].replace(" år", "")
                val age = ageString.toIntOrNull()
                if (age != null) {
                    return Person(name, address, age)
                }
            }
            return null
        }
    }
}