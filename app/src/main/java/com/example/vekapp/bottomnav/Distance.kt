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

@Composable
fun Distance() {

    var result by remember {
        mutableStateOf(0.0)
    }

    var dx by remember {
        mutableStateOf(0.0)
    }

    var dy by remember {
        mutableStateOf(0.0)
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Distância entre 2 pontos",textAlign = TextAlign.Center, fontSize = 30.sp)

        Text(text = "Geometria Analítica",textAlign = TextAlign.Center, fontSize = 25.sp)

        Text(text = "√((x1 - x2)² + (y1 - y2)²)",textAlign = TextAlign.Center)

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
                    onClick = { result = calcD(x1.text, x2.text, y1.text, y2.text)
                        dx = calcDx(x1.text, x2.text)
                        dy = calcDy(y1.text, y2.text)
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
                    onClick = { result = 0.0
                        dx = 0.0
                        dy = 0.0
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

        var text = "" + result

        if(verDec(result)){
            text = "Raiz de " + result * result
        }

        Text(text = "Distância: $text", textAlign = TextAlign.Center)

        Text(text = "Delta X: $dx",textAlign = TextAlign.Center)

        Text(text = "Delta Y: $dy",textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    VekAppTheme {
        Distance()
    }
}
