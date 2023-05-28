package com.example.vekapp.bottomnav

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
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
fun Distributive() {

    var result by remember {
        mutableStateOf("Ax² + Bx + C")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Calcular Distributiva",textAlign = TextAlign.Center, fontSize = 30.sp)

        Text(text = "Aritmética",textAlign = TextAlign.Center, fontSize = 25.sp)

        Text(text = "(a + b)² = a² + 2.a.b + b²",textAlign = TextAlign.Center)

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
                b= it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Column {
                Button(
                    onClick = { result = calcDistributive(a.text, b.text) },
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
                        Icons.Filled.Check,
                        contentDescription = "Check",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Calcular")
                }
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Button(
                    onClick = { result = "Ax² + Bx + C"
                        a = a.copy("")
                        b = b.copy("")},
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

        Text(text = "Resultado:", textAlign = TextAlign.Center)

        Text(text = result, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview3() {
    VekAppTheme {
        Distributive()
    }
}
