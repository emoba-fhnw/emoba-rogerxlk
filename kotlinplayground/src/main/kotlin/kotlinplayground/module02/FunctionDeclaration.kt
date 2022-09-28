package kotlinplayground.module02

fun square(value: Int, base: Double): Double{
    return base + value * value
}

fun squareWithDefaultBase(value: Int, base: Double = 10.0): Double{
    return base + value * value
}

//ohne return und Typeinference
fun squareWithDefaultBaseLight(value: Int, base: Double = 10.0) =
    base + value * value

//Unit = void -> no return
fun squareUnit(value: Int, base: Double): Unit{
     base + value * value
}

fun main() {
    println(square(3, 2.5))
    println(squareWithDefaultBase(3)) //Default Value wird genommen
    println(squareWithDefaultBase(3, 5.0)) //Default Value wird überschrieben
    println(squareWithDefaultBaseLight(4))
    println(squareUnit(3,2.5))
}