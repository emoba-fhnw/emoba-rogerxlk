package kotlinplayground.module02

fun times2(value: Int, onResult: (Int) -> Unit): Unit{
    val result = value * 2
    onResult(result)
}

fun main(){
    println(times2(5, {res -> println(res)}))
}