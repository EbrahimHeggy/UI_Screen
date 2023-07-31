package dev.ebrahim.orderscreen.compasable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


data class Profile(val name: String, val job: String)

fun getDummyProfiles(): List<Profile> {
    return listOf(
        Profile("John", "Software Engineer"),
        Profile("Alice", "Designer"),
        Profile("Bob", "Data Scientist"),
        Profile("Emily", "Product Manager"),
        Profile("Michael", "Marketing Specialist"),
        Profile("Olivia", "Teacher"),
        Profile("David", "Doctor"),
        Profile("Sophia", "Accountant"),
        Profile("Daniel", "Sales Manager"),
        Profile("Emma", "HR Manager"),
        Profile("William", "Graphic Designer"),
        Profile("Ava", "Lawyer"),
        Profile("James", "Chef"),
        Profile("Isabella", "Architect"),
        Profile("Alexander", "Financial Analyst"),
        Profile("Mia", "Journalist"),
        Profile("Ethan", "Mechanical Engineer"),
        Profile("Charlotte", "Nurse"),
        Profile("Oliver", "Photographer"),
        Profile("Amelia", "Researcher")
    )
}

@Composable
fun ProfileItem(profile: Profile) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Account Icon",
                modifier = Modifier.size(48.dp)
            )

            Column {
                Text(text = profile.name, style = MaterialTheme.typography.h6)
                Text(text = profile.job, style = MaterialTheme.typography.body1)
            }
        }
    }
}


@Composable
fun ProfileList() {
    val profiles = getDummyProfiles()
    val state = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state)
    ) {
        profiles.forEach { profile ->
            ProfileItem(profile = profile)
        }
    }
}