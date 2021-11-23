package com.example.testesicredi

import java.util.*

data class EventModel(
    val id : String? = null,
    val title : String? = null,
    val price : Double? = null,
    val latitude : Double? = null,
    val longitude : Double? = null,
    val image : String? = null,
    val description : String? = null,
    val date : Long? = null
)