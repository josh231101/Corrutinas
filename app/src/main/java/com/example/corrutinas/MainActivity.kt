package com.example.corrutinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.corrutinas.ui.theme.CorrutinasTheme
import com.example.corrutinas.viewmodels.StudentViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CorrutinasTheme {
                var studentViewModel = StudentViewModel()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RuletaView(studentViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var studentViewModel = StudentViewModel()
    
    CorrutinasTheme {
        RuletaView(studentViewModel)
    }
}

@Composable
fun RuletaView(studentViewModel: StudentViewModel) {
    var printedText = studentViewModel.selectedStudent

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(text = printedText)
        Spacer(modifier = Modifier.height(10.dp))

        if (!printedText.contains("Buscando")) {
            Button(
                onClick = {
                    studentViewModel.getData()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text(text = "Tendre suerte")
            }
        } else {
            CircularProgressIndicator(
                color = Color(0xFF009688),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}