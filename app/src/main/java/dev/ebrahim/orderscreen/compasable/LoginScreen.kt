package dev.ebrahim.orderscreen.compasable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ebrahim.orderscreen.R

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    var rememberPasswordState by remember { mutableStateOf(false) }
    val state = rememberScrollState()
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state)
                .padding(16.dp), verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.rec), contentDescription = "First pic",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(147.dp))
            Text(
                text = "Welcome",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "By signing in you are agreeing our",
                style = MaterialTheme.typography.bodySmall,modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                    text = "Term and privacy policy",
            style = MaterialTheme.typography.bodySmall,modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address") },
                trailingIcon = { Icon(Icons.Default.Email, "Email") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { keyboardController?.show() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("emailField")
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                trailingIcon = { Icon(Icons.Default.Lock, "Email") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { keyboardController?.show() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("emailField")
            )
            Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),


                        ) {
                            Checkbox(
                                checked = rememberPasswordState,
                                modifier = Modifier.padding(0.dp),
                                onCheckedChange = { newPasswordState ->
                                   rememberPasswordState = newPasswordState
                                },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = MaterialTheme.colorScheme.primary,
                                    uncheckedColor = Color.Gray
                                )
                            )
                            Text(
                                text = "Remember Password", textAlign = TextAlign.Center,
                                color = Color.Black, modifier = Modifier
                                    .fillMaxHeight()
                                    .align(Alignment.CenterVertically)
                            )
                        }
            Text(text = "Forget Password",
               modifier =Modifier.align(Alignment.End),
                color = Color.Red

            )
            Spacer(modifier = Modifier.height(16.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {}
                ) {
                    Text("Login")
                }
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                    }
                ) {
                    Text("Register")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Login with touch ID",modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(R.drawable.fr2), contentDescription = "id",modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(70.dp)
                .height(80.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "or connect with",modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
            Row ( modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Center,

            )
            {
//                Icon(painter = painterResource(id = R.drawable.ic_facebook) , contentDescription = "facebook")
//                Icon(painter = painterResource(id = R.drawable.ic_insta) , contentDescription = "insta")
//                Icon(painter = painterResource(id = R.drawable.ic_pin) , contentDescription = "pin")
//                Icon(painter = painterResource(id = R.drawable.ic_link) , contentDescription = "link")

                Image(painter = painterResource(id = R.drawable.frameg), contentDescription ="groub", modifier = Modifier.height(61.dp) )
            }

        }

        }
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen()
}
