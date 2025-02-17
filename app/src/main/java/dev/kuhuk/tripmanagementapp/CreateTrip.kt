package dev.kuhuk.tripmanagementapp

import dev.kuhuk.tripmanagementapp.data.TravelDates
import dev.kuhuk.tripmanagementapp.data.Trip
import java.util.Date

class CreateTrip() {
    val trips = arrayListOf<Trip>()
    val favTrips = arrayListOf<String>()

    fun createTrip() {
        // get user inputs for all the required fields
        addToTripsList(
            Trip(
                tripName = "trip_1", // unique
                source = "Delhi",
                destination = "Mumbai",
                startDate = "12-09-2025",
                returnDate = "04-11-2025",
                iternary = "do this, then do that",
                false
        ))

        addToTripsList(
            Trip(
                tripName = "trip_2", // unique
                source = "Mumbai",
                destination = "Pune",
                startDate = "12-10-2025",
                returnDate = "04-12-2025",
                iternary = "do this, then do that",
                false
            ))
    }

    private fun addToTripsList(trip: Trip) {
        trips.add(trip)
    }

    // Filtered trips on searching either source or destination
    fun getFilteredList(trips: ArrayList<Trip>, cityName: String): List<Trip> {
        val filteredList = trips.filter {
            it.source.equals(cityName) || it.destination.equals(cityName)
        }

        return filteredList.toList()
    }

    // mark as favorite trip
    fun markAsFav(trip: Trip) {
        if (!favTrips.contains(trip.tripName)) {
            favTrips.add(trip.tripName)
        }
    }

    // get all fav trips
    fun getFavTrips(): List<Trip> {
        return trips.filter {
            it.isFav
        }
    }
}