package dev.kuhuk.tripmanagementapp.data

data class Trip(
    val tripName: String,
    val source: String,
    val destination: String,
    val startDate: String,
    val returnDate: String,
    val iternary: String,
    val isFav: Boolean
)
