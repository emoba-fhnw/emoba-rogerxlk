package kotlinplayground.module02

fun square(value: Int, base: Double): Double{
    return base + value * value
}

fun main() {
    println(square(3, 2.5))
}