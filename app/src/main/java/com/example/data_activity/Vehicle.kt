package com.example.data_activity

import java.io.Serializable

data class Vehicle(val brand: String, val model: String, val productionYear: Int) : Serializable {
    override fun toString(): String {
    return "$brand, $model ($productionYear) "
    }
}