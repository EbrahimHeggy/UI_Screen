package dev.ebrahim.orderscreen.compasable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.ebrahim.orderscreen.R


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


@Composable
private fun getDummyNames() = listOf(
    "John", "Emma", "Michael", "Olivia", "William",
    "Ava", "James", "Sophia", "Alexander", "Isabella",
    "Daniel", "Mia", "David", "Emily", "Joseph",
    "Charlotte", "Matthew", "Abigail", "Ethan", "Harper",
    "Christopher", "Amelia", "Andrew", "Evelyn", "Benjamin",
    "Elizabeth", "Joshua", "Sofia", "Jackson", "Avery",
    "Sebastian", "Ella", "Logan", "Grace", "Samuel",
    "Scarlett", "Ryan", "Chloe", "Henry", "Lily",
    "Nathan", "Eleanor", "Dylan", "Hannah", "Jacob",
    "Aria", "Lucas", "Layla", "Carter","Victoria"
)

@Composable
fun lazyTask(names: List<String>) {
    LazyColumn {
        itemsIndexed(names) { index, item ->
            if (item.length <= 4)
                Text(
                    text = item, modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.DarkGray)
                        .padding(8.dp), textAlign = TextAlign.Center
                )
            else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray)
                        .padding(8.dp)
                ) {
                    repeat(2) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = item, textAlign = TextAlign.Center
                        )
                    }

                }
                Divider(modifier = Modifier.height(2.dp))

            }
            if (index !=0 && index.rem(5)==0)
                LazyRow(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(12.dp)){
                    items(10){
                        Image(painter = painterResource(id =R.drawable.cr7 ), contentDescription = " ")
                    }
                }
        }
    }
}

@Composable
fun LazyList() {
    val names = getDummyNames()
    lazyTask(names)
}