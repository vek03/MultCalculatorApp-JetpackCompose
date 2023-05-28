package com.example.vekapp.bottomnav

import kotlin.math.floor
import kotlin.math.sqrt

fun calcDistributive(a1: String, b1: String): String {
    return if(a1.isEmpty() || b1.isEmpty()){
        "Ax² + Bx + C"
    }else{
        val a: Int = a1.toInt() * a1.toInt()
        val c: Int = b1.toInt() * b1.toInt()
        val b: Int = 2 * (a1.toInt() * b1.toInt())

        var s1 = ""
        var s2 = ""

        if(b > 0){
            s1 = "+"
        }

        if(c > 0){
            s2 = "+"
        }

        if(a == 1){
            "x²" + s1 + b + "x" + s2 + c
        }else{
            "" + a + "x²" + s1 + b + "x" + s2 + c
        }


    }
}

fun calcMX(x1: String, x2: String): Double {
    return if(x1.isEmpty() || x2.isEmpty()){
        0.0
    }else{
        val a1 = x1.toDouble()
        val a2 = x2.toDouble()
        (a1 + a2) / 2
    }
}

fun calcMY(y1: String, y2:String): Double {
    return if(y1.isEmpty() || y2.isEmpty()){
        0.0
    }else{
        val b1 = y1.toDouble()
        val b2 = y2.toDouble()
        (b1 + b2) / 2
    }
}

fun calcD(x1: String, x2: String, y1: String, y2:String): Double {
    return if(x1.isEmpty() || x2.isEmpty() || y1.isEmpty() || y2.isEmpty()){
        0.0
    }else{
        val a1 = x1.toDouble()
        val a2 = x2.toDouble()
        val b1 = y1.toDouble()
        val b2 = y2.toDouble()
        val dx = a1 - a2
        val dy = b1 - b2
        sqrt((dx * dx) + (dy * dy))
    }
}

fun calcDx(x1: String, x2: String): Double {
    return if(x1.isEmpty() || x2.isEmpty()){
        0.0
    }else{
        val a1 = x1.toDouble()
        val a2 = x2.toDouble()
        a1 - a2
    }
}

fun calcDy(y1: String, y2:String): Double {
    return if(y1.isEmpty() || y2.isEmpty()){
        0.0
    }else{
        val b1 = y1.toDouble()
        val b2 = y2.toDouble()
        b1 - b2
    }
}

fun calc1(a: String, b: String, c: String): Double {
    return if(a.isEmpty() || b.isEmpty() || c.isEmpty()){
        0.0
    }else{
        val a = a.toDouble()
        val b = b.toDouble()
        val c = c.toDouble()
        val delta = (b * b) - 4 * a * c
        (- b + sqrt(delta)) / (2 * a)
    }
}

fun calc2(a: String, b: String, c: String): Double {
    return if(a.isEmpty() || b.isEmpty() || c.isEmpty()){
        0.0
    }else{
        val a = a.toDouble()
        val b = b.toDouble()
        val c = c.toDouble()
        val delta = b * b - 4 * a * c
        (- b - sqrt(delta)) / (2 * a)
    }
}

fun calcDelta(a: String, b: String, c: String): Double {
    return if(a.isEmpty() || b.isEmpty() || c.isEmpty()){
        0.0
    }else{
        val a = a.toDouble()
        val b = b.toDouble()
        val c = c.toDouble()
        b * b - 4 * a * c
    }
}

fun verDec(r: Double): Boolean{
    return r > floor(r)
}