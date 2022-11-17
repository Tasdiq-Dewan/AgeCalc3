package com.tasdiq.agecalc3.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var ageResult = "Waiting for an age"
    fun setAgeResult(age: Int?) {
        var answer: String
        if (age != null) {
            when (age) {
                in 0..5 -> answer = "Infant"
                in 6..14 -> answer = "Whining schoolboy"
                in 15..24 -> answer = "Lover"
                in 25..40 -> answer = "Soldier"
                in 41..59 -> answer = "Justice"
                in 60..75 -> answer = "Pantaloon"
                in 76..130 -> answer = "Second childishness"
                else -> answer = "Nobody is $age years old"
            }
        } else {
            answer = "You need to provide an age in whole years"
        }
        ageResult = answer
    }
    fun getAgeResult(): String {
        return ageResult
    }}