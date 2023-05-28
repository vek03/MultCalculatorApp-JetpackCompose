package com.example.vekapp.bottomnav

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
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

//Equação de 2° Grau
@Composable
fun SegGrau() {

    var delta by remember {
        mutableStateOf(0.0)
    }

    var x1 by remember {
        mutableStateOf(0.0)
    }

    var x2 by remember {
        mutableStateOf(0.0)
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Equação de 2° Grau",textAlign = TextAlign.Center, fontSize = 30.sp)

        Text(text = "Geometria Plana",textAlign = TextAlign.Center, fontSize = 25.sp)

        Text(text = "(-b +/- √(b² - 4.a.c)) / (2 . a)",textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "A",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var a by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = a,
            label = { Text(text = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                a = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "B",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var b by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = b,
            label = { Text(text = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                b = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "C",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var c by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = c,
            label = { Text(text = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                c = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Column {
                Button(
                    onClick = { delta = calcDelta(a.text, b.text, c.text)
                        x1 = calc1(a.text, b.text, c.text)
                        x2 = calc2(a.text, b.text, c.text)
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
                        Icons.Filled.Done,
                        contentDescription = "Done",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Calcular")
                }
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Button(
                    onClick = { delta = 0.0
                        x1 = 0.0
                        x2 = 0.0
                        a = a.copy("")
                        b = b.copy("")
                        c = c.copy("")},
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

        Text(text = "Delta: $delta", textAlign = TextAlign.Center)

        Text(text = "X1: $x1",textAlign = TextAlign.Center)

        Text(text = "X2: $x2",textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview5() {
    VekAppTheme {
        SegGrau()
    }
}

