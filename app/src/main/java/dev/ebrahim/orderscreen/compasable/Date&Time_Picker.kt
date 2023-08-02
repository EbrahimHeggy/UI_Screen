package dev.ebrahim.orderscreen.compasable

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ebrahim.orderscreen.Activities.Spacer
import java.util.Calendar


@Composable
fun ShowDate_TimePicker() {
    val calender = Calendar.getInstance()  // access date and time
    val year = calender.get(Calendar.YEAR)
    val month = calender.get(Calendar.MONTH) + 1
    val day = calender.get(Calendar.DAY_OF_MONTH)
    val hour = calender.get(Calendar.HOUR_OF_DAY)
    val minute = calender.get(Calendar.MINUTE)
    var showSnackbar by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var showDate by remember { mutableStateOf(false) }
    var showTime by remember { mutableStateOf(false) }
    var showMenu by remember { mutableStateOf(false) }
    var selectedDate: MutableState<String> = remember { mutableStateOf("") }
    var selectedTime: MutableState<String> = remember { mutableStateOf("") }

    var selectedItem by remember { mutableStateOf("") }
    val items = listOf("Item 1", "Item 2", "Item 3")
    val context = LocalContext.current  // current Activity

    Box(modifier = Modifier.fillMaxSize())
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ///////////////////////// TOAST
            Button(onClick = {
                Toast.makeText(context, "Showing The Toast", Toast.LENGTH_LONG).show()
            })
            {
                Text(text = "Show Toast")
            }
            Spacer(height = 10)
            ///////////////////// SnackBar
            Button(onClick = {
                showSnackbar = true
            })
            {
                Text(text = "Show SnackBar")
            }
            // VIsability of Snackbar above the layers
            AnimatedVisibility(visible = showSnackbar) {
                Snackbar(action = {
                    TextButton(onClick = { showSnackbar = false }) {
                        Text(text = "Dismiss")
                    }
                }) {
                    Text(text = "Show SnackBar")
                }
            }
            Spacer(height = 10)
            ///////////////////////////// Alert Dialog //////////////////////
            Button(onClick = {
                showDialog = true
            })
            {
                Text(text = "Show Daialog")
            }
            // Visability of AlertDialopg
            if (showDialog)
                AlertDialog(
                    title = {
                        Text(text = "Delete confirmation!")
                    },
                    text = {
                        Text(text = "Are You Sure That You Want To Delete This?!")
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            showDialog = false
                            Toast.makeText(context, "Delete Canceled", Toast.LENGTH_SHORT).show()
                        })
                        {
                            Text(text = "Cancel!")
                        }
                    },
                    confirmButton = {
                        Button(onClick = {
                            Toast.makeText(context, "Delete Done!", Toast.LENGTH_SHORT).show()
                            showDialog = false
                        }) {
                            Text(text = "Confirm")

                        }
                    },
                    // When user click outside the dialog
                    onDismissRequest = {
//                        showDialog = false
                    })

            Spacer(height = 10)
            // DatePicker
            Button(onClick = {
                showDatePicker(context, selectedDate, year, month, day)
                Toast.makeText(
                    context,
                    "Selected Date is : ${selectedDate.value}",
                    Toast.LENGTH_SHORT
                ).show()
                showDate = true
            }
            )
            {
                Text(text = "Show Date")
            }
            if (showDate)
                Text(text = "Selected Date : ${selectedDate.value}")

            Spacer(height = 10)

            //TimePicker
            Button(onClick = {
                showTimePicker(context, selectedTime, hour, minute)
                Toast.makeText(
                    context,
                    "Selected Time is : ${selectedTime.value}",
                    Toast.LENGTH_SHORT
                ).show()
                showTime = true
            })
            {
                Text(text = "Show Time")
            }
            if (showTime)
                Text(text = "Selected Time : ${selectedTime.value}")

            Spacer(height = 10)
            //Menu
            Button(onClick = {
                showMenu = true
            }) {
                Text(text = "Show Menu")
            }

            if (showMenu)
                DropDownDemo()
        }
    }

}


fun showDatePicker(
    context: Context,
    selectedDate: MutableState<String>,
    year: Int,
    month: Int,
    day: Int,
) {
    val datePicker = DatePickerDialog(
        /*context*/ context,
        /*listener*/{ dataPicker, year, month, day ->
            selectedDate.value = "$day/${month + 1}/$year"
            Toast.makeText(context, selectedDate.value, Toast.LENGTH_SHORT).show()
        },
        /*year*/ year,
        /*month*/ month,
        /*day*/ day
    )
    datePicker.show()
}

fun showTimePicker(
    context: Context,
    selectedTime: MutableState<String>,
    hour: Int,
    minute: Int,
) {
    val timePicker = TimePickerDialog(
        /*context*/ context,
        /*listener*/ { dataPicker, hour, minute ->
            selectedTime.value = "$hour:$minute"
            Toast.makeText(context, selectedTime.value, Toast.LENGTH_SHORT).show()
        },
        /*hour*/ hour,
        /*minute*/ minute,
        /*is24Hour*/ true
    )
    timePicker.show()
}


@Composable
fun DropDownDemo() {
    val context2 = LocalContext.current
    Row(modifier = Modifier.fillMaxWidth()) {
        var expanded by remember { mutableStateOf(false) }
        var selectedItem by remember { mutableStateOf("please select") }

        Row(modifier = Modifier
            .clickable {
                expanded = expanded.not()
            }
            .padding(12.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color.LightGray)
            .padding(8.dp)) {
            Text(text = selectedItem)
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
        }

        DropdownMenu(
            modifier = Modifier.padding(horizontal = 12.dp),
            expanded = expanded,
            onDismissRequest = {  }) {
            repeat(5) {
                val text = " Item $it"
                DropdownMenuItem(text = { Text(text = text) }, onClick = {
                    selectedItem = text
                    expanded = false
                    Toast.makeText(context2, "Selected Item is : $it", Toast.LENGTH_SHORT).show()

                })
                Divider(
                    Modifier
                        .height(2.dp)
                        .padding(bottom = 2.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ShowDate_TimePicker()
}

