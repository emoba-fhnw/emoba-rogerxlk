package kotlinplayground.module03.classes

class Dog (weight: Double, alive: Boolean, age: Int) : Animal(weight, alive, age){

    override fun isGeriatric(age: Int, alive: Boolean){
        if (alive && age > 10) return
    }
}