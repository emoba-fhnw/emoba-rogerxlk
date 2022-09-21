package kotlinplayground.module01

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

}