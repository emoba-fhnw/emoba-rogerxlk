package kotlinplayground.module03.classes

open class Animal(var weight: Double = 0.0,
                  var alive: Boolean = true,
                  var age: Int = 5) {

    open fun isGeriatric() {
        if(alive && age > 5)
            return
    }
}