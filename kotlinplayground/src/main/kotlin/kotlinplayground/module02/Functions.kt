package kotlinplayground.module02

import java.lang.Double.min

fun bmi(weight: Double, bodyHeight: Int): Double {
    val h = bodyHeight / 100.0
    
    return weight / (h * h)
}

fun square(x: Double): Double = x * x

fun bmi2(weight: Double, bodyHeight: Int): Double = weight / square(bodyHeight / 100.0)

fun Double.square2(): Double = this * this

fun bmi3(weight: Double, bodyHeight: Int): Double = weight / (bodyHeight / 100.0).square2()

fun grade(freezerApp: Int = 4,
          thatsApp: Int = 4,
          yelloApp: Int = 4,
          coolestAppAwards: Int = 0,
          presentation: Int = 0): Double =
    min(6.0, sum(freezerApp, thatsApp, yelloApp, coolestAppAwards, presentation) / 2.0)


fun sum(vararg x: Int): Int = x.sum()

fun printIt(value: Number, unit: String = "kg") : Unit {
    println("$value $unit")
}


fun main() {
    println(bmi(82.0, 189))
    println(bmi(bodyHeight = 189, weight = 82.0))
    
    println(2.0.square2())
    
    println(grade())
    println(grade(freezerApp = 2, presentation = 1))
    println(grade(presentation = 1))
    
    printIt(200,"ms")       //the Java way
    printIt(unit = "m/s", value = 2.0) //beliebige Reihenfolge durch "Named Parameter"
    printIt(2f)                  //Default-Werte benutzen
    
    val items = listOf(1, 2, 5, 2)

    items.first({ item ->
                    val threshold = 3
                    item > threshold
                })
    
   items.first(predicate = {val threshold = 3
                             it > threshold })

   items.first {
        val threshold = 3
        it > threshold
    }
    
}