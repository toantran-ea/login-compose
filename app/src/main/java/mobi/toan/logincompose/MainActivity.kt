package mobi.toan.logincompose

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import mobi.toan.logincompose.ui.LoginComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginForm(onLogin = { Toast.makeText(this, "hello login", Toast.LENGTH_SHORT).show() })
                }
            }
        }
    }
}

@Composable
fun LoginForm(onLogin: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp).fillMaxHeight()) {
        InputSection(false, "User name")
        InputSection(true, "Password")
        Button(onClick = onLogin, modifier = Modifier.align(Alignment.CenterHorizontally).padding(12.dp)) {
            Text("Login")
        }
    }
}

@Composable
fun InputSection2(withPassword: Boolean, label: String) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    Column() {
        Text(text = label)
        TextField(value = textState.value,
                onValueChange = {
                    textState.value = it
                }
        )
    }
}

@Composable
@Preview(showBackground = true, name = "Input")
fun InputSection(withPassword: Boolean = true, label: String = "") {
    val textState = remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text(text = label, modifier = Modifier.wrapContentWidth(), color = Color.DarkGray)
        TextField(value = textState.value,
                onValueChange = {
                    textState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (withPassword) PasswordVisualTransformation() else VisualTransformation.None)
    }
}


@Composable
@Preview(showBackground = true, name = "Greeting card")
fun Greeting(name: String = "Boris") {
    Text(text = "Hello $name!", color = Color.Green, modifier = Modifier.padding(8.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginComposeTheme {
        Greeting("Android")
    }
}