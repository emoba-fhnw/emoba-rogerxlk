package kotlinplayground.module03.classes

open class Animal(var weight: Double = 0.0,
                  var alive: Boolean = true,
                  var age: Int = 0) {

    open fun isGeriatric() : Boolean {
        return alive && age > 5
    }
}