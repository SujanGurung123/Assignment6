package com.example.esoftwarica

import com.example.esoftwarica.model.Students
import java.util.*

class StudentData private constructor() {
    var list = ArrayList<Students>()
    fun List(): ArrayList<Students> {
        return list
    }

    companion object {
        private val data = StudentData()
        fun get(): StudentData {
            return data
        }
    }
}