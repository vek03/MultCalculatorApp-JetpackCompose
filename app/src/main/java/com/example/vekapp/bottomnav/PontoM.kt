package com.example.vekapp.bottomnav

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vekapp.ui.theme.VekAppTheme

//Calcular o Ponto Médio
@Composable
fun PontoM() {

    var mx by remember {
        mutableStateOf(0.0)
    }

    var my by remember {
        mutableStateOf(0.0)
    }

    var deltax by remember {
        mutableStateOf(0.0)
    }

    var deltay by remember {
        mutableStateOf(0.0)
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Calcular Ponto Médio",textAlign = TextAlign.Center, fontSize = 30.sp)

        Text(text = "Geometria Analítica",textAlign = TextAlign.Center, fontSize = 25.sp)

        Text(text = "((x1 + x2) / 2), ((y1 + y2) / 2) = (m1, m2)",textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "X1",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var x1 by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = x1,
            label = { Text(text = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                x1 = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Y1",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var y1 by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = y1,
            label = { Text(text = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                y1 = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "X2",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var x2 by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = x2,
            label = { Text(text = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                x2 = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Y2",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var y2 by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = y2,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                y2 = it
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Column {
                Button(
                    onClick = { mx = calcMX(x1.text, x2.text)
                        my = calcMY(y1.text, y2.text)
                        deltax = calcDx(x1.text, x2.text)
                        deltay = calcDy(y1.text, y2.text)
                    },
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    )
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Calcular")
                }
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Button(
                    onClick = { mx = 0.0
                        my = 0.0
                        deltay = 0.0
                        deltax = 0.0
                        x1 = x1.copy("")
                        x2 = x2.copy("")
                        y1 = y1.copy("")
                        y2 = y2.copy("")},
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    )
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        Icons.Filled.Clear,
                        contentDescription = "Clear",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Limpar")
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Ponto Médio X: $mx", textAlign = TextAlign.Center)

        Text(text = "Ponto Médio Y: $my",textAlign = TextAlign.Center)

        Text(text = "Delta X: $deltax",textAlign = TextAlign.Center)

        Text(text = "Delta Y: $deltay",textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview4() {
    VekAppTheme {
        PontoM()
    }
}
