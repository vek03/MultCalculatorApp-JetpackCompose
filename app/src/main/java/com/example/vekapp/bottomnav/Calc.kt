package com.example.vekapp.bottomnav

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vekapp.ui.theme.VekAppTheme
import net.objecthunter.exp4j.ExpressionBuilder


@Composable
fun Calc() {

        var result by remember {
            mutableStateOf("")
        }

        var cont by remember {
            mutableStateOf("")
        }

        var expressao by remember {
            mutableStateOf("")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Row{
                Column(
                    horizontalAlignment = Alignment.End,
                ){
                    Text(text = cont, fontSize = 40.sp, textAlign = TextAlign.Right)
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Row{
                Column(
                    horizontalAlignment = Alignment.End,
                ){
                    Text(text = result, fontSize = 25.sp, color = Color.Green, textAlign = TextAlign.Center)
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Row {
                Column{
                    Button(
                        onClick = {
                            cont = removeLastNchars(cont, 1)
                            expressao = removeLastNchars(expressao, 1)
                            result = calcular(expressao)
                        },
                    ) {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = "Clear",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Divider(
                modifier = Modifier.height(1.dp).fillMaxWidth(),
                color = Color(0xFFd3d3d3)
            )

            Spacer(modifier = Modifier.height(15.dp))

            val bottomSize = 80
            val columnV = 10
            val columnH = 13
            val fontSize = 31

            Row(
                horizontalArrangement = Arrangement.spacedBy(columnH.dp),
            ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(columnV.dp),
                ){
                    Button(
                        onClick = { cont = ""
                                result = ""
                                expressao = ""},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "C", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += "7"
                                    expressao += "7"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "7", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += "4"
                                    expressao += "4"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "4", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += "1"
                                    expressao += "1"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "1", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += ")"
                                    expressao += ")"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "( )", fontSize = fontSize.sp)
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(columnV.dp),
                ){
                    Button(
                        onClick = { cont += "(-"
                                    expressao += "(-"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "+/-", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += "8"
                                    expressao += "8"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "8", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += "5"
                                    expressao += "5"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "5", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += "2"
                                    expressao += "2"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "2", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += "0"
                                    expressao += "0"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "0", fontSize = fontSize.sp)
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(columnV.dp),
                ){
                    Button(
                        onClick = { cont += verIni(cont, "%")
                                    expressao += verIni(expressao, "*0.01*")},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "%", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += "9"
                                    expressao += "9"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "9", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += "6"
                                    expressao += "6"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "6", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += "3"
                                    expressao += "3"},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "3", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += verIni(cont, ".")
                                    expressao += verIni(expressao, ".")},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = ".", fontSize = fontSize.sp)
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(columnV.dp),
                ){
                    Button(
                        onClick = { cont += verIni(cont, "÷")
                                    expressao += verIni(expressao, "/")},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "÷", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += verIni(cont, "x")
                                    expressao += verIni(expressao, "*")},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "x", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += verIni(cont, "-")
                                    expressao += verIni(expressao, "-")},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "-", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { cont += verIni(cont, "+")
                                    expressao += verIni(expressao, "+")},
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "+", fontSize = fontSize.sp)
                    }

                    Button(
                        onClick = { result = calcular(expressao) },
                        shape = CircleShape,
                        modifier = Modifier
                            .width(bottomSize.dp)
                            .height(bottomSize.dp),
                    ) {
                        Text(text = "=", fontSize = fontSize.sp)
                    }
                }
            }
        }
}

fun calcular(expression: String): String {
    return try{
        val expressao = ExpressionBuilder(expression).build()

        val resultado =  expressao.evaluate()
        val floatResult = resultado.toFloat()

        if(resultado == floatResult.toDouble()){
            floatResult.toString()
        }else{
            resultado.toString()
        }
    }catch(e: Exception){
        ""
    }
}

fun removeLastNchars(str: String, n: Int): String {
    return if(verIni(str, "1").isNotEmpty()){
        str.substring(0, str.length - n)
    }
    else{
        ""
    }
}

fun verIni(expressao: String, operador: String): String {
    return try{
        if(expressao.isNotEmpty()){
            operador
        }else{
            ""
        }
    }catch (e: Exception){
        ""
    }
}


fun calculadora(expressao: String): String {
    return try{
        val resultado: String
        val listaNumeros: List<Double> = obterNumeros(expressao)
        val listaOperadores: List<Char> = obterOperadores(expressao)
        resultado = calcularValor(listaNumeros, listaOperadores)
        resultado
    }catch (e: Exception){
        ""
    }
}

private fun calcularValor(
    listaNumeros: List<Double>,
    listaOperadores: List<Char>
): String {
    val resultado: String
    var total = 0.0
    var j = 0
    for (i in 0 until listaNumeros.size - 1) {
        if (total == 0.0) {
            val numero1 = listaNumeros[i]
            val numero2 = listaNumeros[i + 1]
            val operador = listaOperadores[i]
            total = executarOperacao(numero1, operador, numero2)
        } else if (total > 0.0) {
            val numero2 = listaNumeros[i]
            val operador = listaOperadores[j]
            total = executarOperacao(total, operador, numero2)
            j++
        }
    }
    resultado = "" + total
    return resultado
}

private fun executarOperacao(numero1: Double, operador: Char, numero2: Double): Double {
    var resultado = 0.0
    when (operador) {
        '+' -> {
            resultado = numero1 + numero2
        }
        '-' -> {
            resultado = numero1 - numero2
        }
        '÷' -> {
            resultado = numero1 / numero2
        }
        'x' -> {
            resultado = numero1 * numero2
        }
        '%' -> {
            resultado = numero1 * (numero2 / 100)
        }
    }
    return resultado
}

private fun obterNumeros(expressao: String): List<Double> {
    val listaNumeros: MutableList<Double> = ArrayList()
    var numeroEmString = ""
    for (i in expressao.indices) {
        numeroEmString = if (isOperador(expressao[i])) {
            val numero = java.lang.Double.valueOf(numeroEmString)
            listaNumeros.add(numero)
            ""
        } else {
            numeroEmString + "" + expressao[i]
        }
    }
    if (numeroEmString.isNotEmpty()) {
        val numero = java.lang.Double.valueOf(numeroEmString)
        listaNumeros.add(numero)
    }
    return listaNumeros
}

private fun obterOperadores(expressao: String): List<Char> {
    val listaOperadores: MutableList<Char> = ArrayList()
    for (i in expressao.indices) {
        if (isOperador(expressao[i])) {
            listaOperadores.add(expressao[i])
        }
    }
    return listaOperadores
}

private fun isOperador(caracter: Char): Boolean {
    return caracter == '%' || caracter == '-' || caracter == '+' || caracter == '÷' || caracter == 'x'
}


@Preview(showBackground = true)
@Composable
fun Preview1() {
    VekAppTheme {
        Calc()
    }
}
