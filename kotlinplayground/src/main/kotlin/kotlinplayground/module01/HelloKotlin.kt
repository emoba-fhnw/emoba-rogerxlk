package kotlinplayground.module01

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val message = "Viel Spass im Kotlin Playground"
    println(message)

    //default-mässig kann man kein null zu einer variable hinzufügen
    var str = 1.0f
    str = 2.0f
    println(str)

    //mit : Typ? werden auch null werde zugelassen
    var str2 : String?
    str2 = "2"
    str2=null
    println(str2)

    //val ist eine Konstante
    val abc = 20
    println(abc)

    val xyz : String?
    xyz = "testXYZ"
    println(xyz)

    //function declaration
    val a = 10
    val b = 3

    //Option 1
    fun sub1(a:Int, b:Int): Int{
        return a-b
    }

    //Option 2
    fun sub2(a:Int, b:Int) = a-b

    println("sub1: " + sub1(a,b))
    println("sub2: " + sub2(a,b))
    println("substraction of $a and $b is ${a-b}")

    class Rectangle(var height: Double, var length: Double){
        var perimeter = (height + length) * 2
    }

    val rectangle = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle.perimeter}")

    //if-Statement
    fun maxOf(a: Int, b: Int) = if (a > b) a else b
    println("max of $a and $b is: " + maxOf(a, b))

    //for-Loop
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }

    //when = "old switch stament"
    fun describe(obj: Any): String =
        when (obj) {
            1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"
            else       -> "Unknown"
        }

    //Iteration Range
    for (x in 1..5) {
        print(x)
    }
    println()

    //Iteration Range with last value
    for (x in 1 until 5) {
        print(x)
    }
    println()

    //Iteration with Up/Down Steps
    for (y in 1..10 step 2) {
        print(y)
    }
    println()
    for (z in 9 downTo 0 step 3) {
        print(z)
    }
    println()

    //lambda expression with "it"
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit", "orange")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }

    //check if collection contains object
    when {
        "orange" in fruits -> println("juicy")
        "apple" in fruits -> println("apple is fine too")
        else -> throw IllegalArgumentException("fruit not available")

    }

    //print all items
    for (fruit in fruits) {
        print(fruit + ", ")
    }

    //read-only lists/maps/etc.
    val LIST = listOf("a", "b", "c")
    val MAP = mapOf("a" to 1, "b" to 2, "c" to 3)

    //read file
    val stream = Files.newInputStream(Paths.get("/some/file.txt"))
    stream.buffered().reader().use { reader ->
        println(reader.readText())
    }
}