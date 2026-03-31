package com.example.socialsparks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.socialsparks.ui.theme.SocialSparksTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocialSparksTheme{

                var text by remember{mutableStateOf("")}
                var results by remember{mutableStateOf("")}
                Column(){
                    Text("SocialSparks")
                    OutlinedTextField(
                        value = text,
                        onValueChange =  {text = it},
                        label = {Text("Enter time of the day")}
                    )

                    Row(){
                        Button(
                            onClick = {
                                results = when(text){
                                    "Morning" -> "Send a 'Good morning' text to a family member"
                                    "Mid-morning" -> "Reach out to a colleague with a quick 'Thank you'"
                                    "Afternoon" -> "Share a funny meme or interesting link with a friend"
                                    "Afternoon Snack Time" -> "Send a quick 'thinking of you' message"
                                    "Dinner" -> "Call friend or relative for a 5-minute catch-up"
                                    "After Dinner" -> "Leave a thoughtful comment on a friend's post"

                                    else -> "Invalid time of day"
                                }
                            }
                        ){
                            Text("Suggest")
                        }
                        Button(
                            onClick = {
                                text = ""
                                results = ""
                            }
                        ){
                            Text ("Reset")
                        }
                    }
                    Text (results)
                }
            }
        }
    }
}