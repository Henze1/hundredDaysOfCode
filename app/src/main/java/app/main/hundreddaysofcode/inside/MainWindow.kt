package app.main.hundreddaysofcode.inside

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.main.hundreddaysofcode.R

@Composable
fun MainWindow(){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.mainpg),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())

        Row(
            modifier = Modifier
                .fillMaxWidth())
        {
            Box(
                modifier = Modifier
                    .size(150.dp, 150.dp)
                    .padding(start = 0.dp, top = 0.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.user),
                    contentDescription = null)
            }

            Column(
                modifier = Modifier
                    .size(242.dp, 150.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    Icon(
                        Icons
                            .Default
                            .Face,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    Text(text = "Name: ")
                    Text(text = "Name")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    Icon(
                        Icons
                            .Default
                            .Face,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    Text(text = "Surname: ")
                    Text(text = "Surname")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    Icon(
                        Icons
                            .Default
                            .Lock,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    Text(text = "ID: ")
                    Text(text = "ID")
                }
            }
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x358D8585))
        ,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(
                    bottom = 0.dp
                ),
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(70.dp)
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.imageusr),
                    contentDescription = null
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ){

                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(70.dp)
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.walletimg),
                    contentDescription = null
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ){

                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(70.dp)
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.transactionsimg),
                    contentDescription = null
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainWindowPreview(){
    MainWindow()
}