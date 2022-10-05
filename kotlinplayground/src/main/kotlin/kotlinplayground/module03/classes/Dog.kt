package kotlinplayground.module03.classes

class Dog(weight: Double = 0.0,
          alive: Boolean = true,
          age: Int = 0) : Animal(weight, alive, age){

    override fun isGeriatric() : Boolean {
        return alive && age > 10
    }
}