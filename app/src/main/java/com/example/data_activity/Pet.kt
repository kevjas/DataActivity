package com.example.data_activity

data class Pet( val name: String, val species: String, val age: Int) {
    override fun toString(): String {
        return "$name,  $species, $age år"
    }

}
