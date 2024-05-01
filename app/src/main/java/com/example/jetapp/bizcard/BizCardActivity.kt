package com.example.jetapp.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetapp.R
import com.example.jetapp.bizcard.ui.theme.JetAppTheme

class BizCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BizCard()
                }
            }
        }
    }
}


@Composable
fun BizCard() {
    val buttonState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), color = Color.White
    ) {
        Card(
            modifier = Modifier
                .padding(all = 20.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(8.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AvtarWidget()
                Divider(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                    thickness = 0.3.dp
                )
                CardBody()
                Button(
                    onClick = { buttonState.value = !buttonState.value },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(text = "Portfolio", color = Color.White)
                }

                if (buttonState.value) {
                    Content()
                } else {
                    Box {

                    }
                }
            }

        }
    }
}


// Avtar Icon
@Composable
fun AvtarWidget(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        color = Color.Blue,
        shape = CircleShape,
        border = BorderStroke(0.1.dp, Color.Red)
    ) {
        Image(
            painter = painterResource(id = R.drawable.aavtar),
            contentDescription = "Profile Picture",
            modifier = modifier.size(150.dp)
        )
    }
}


@Composable
fun CardBody() {
    Column {
        Text(text = "Pramod Pal", color = Color.Red, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "Mobile Application Developer",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
        Text(text = "@pramodpal033", fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}


@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 0.1.dp, color = Color.LightGray)
        ) {
            Portfolio(
                data = listOf(
                    "Portfolio 1",
                    "Portfolio 2",
                    "Portfolio 3",
                    "Portfolio 1",
                    "Portfolio 2",
                    "Portfolio 3",
                    "Portfolio 1",
                    "Portfolio 2",
                    "Portfolio 3",
                    "Portfolio 1",
                    "Portfolio 2",
                    "Portfolio 3",
                )
            )
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    AvtarWidget(modifier = Modifier.size(80.dp))
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                        Text(
                            text = "This is the Project Description",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    com.example.jetapp.ui.theme.JetAppTheme {
        BizCard()
    }
}