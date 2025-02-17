package dev.kuhuk.tripmanagementapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.kuhuk.tripmanagementapp.data.Trip
import dev.kuhuk.tripmanagementapp.ui.theme.TripManagementAppTheme

class MainActivity : ComponentActivity() {
    val trips = arrayListOf<Trip>()
    val favTrips = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        createTrip()

        setContent {
            TripManagementAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        LazyColumn {
                            items(trips.size) {index ->
                                TripItem(trip = trips[index])
                            }
                        }
                    }
                }
            }
        }
    }

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
            )
        )

        addToTripsList(
            Trip(
                tripName = "trip_2", // unique
                source = "Mumbai",
                destination = "Pune",
                startDate = "12-10-2025",
                returnDate = "04-12-2025",
                iternary = "do this, then do that",
                true
            )
        )
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

    @Composable
    private fun TripItem(trip: Trip) {
        Text(text = trip.tripName)
    }
}