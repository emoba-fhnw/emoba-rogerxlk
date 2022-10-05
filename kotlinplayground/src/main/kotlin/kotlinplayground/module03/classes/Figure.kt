package kotlinplayground.module03.classes

open class Figure(var xPos: Int = 0, var yPos: Int = 0) {
    
    open fun area(): Double {
        return 0.0;
    }
}

class Circle(var radius: Double, x: Int, y: Int) : Figure(x, y) {
    
    override fun area() = radius * radius * Math.PI
}


fun main() {
    val someFigure = Figure()
    println("x: ${someFigure.xPos}, y: ${someFigure.yPos}")
    
    val someCircle = Circle(x = 10, y = 20, radius = 2.0)
    println("x: ${someCircle.xPos}, y: ${someCircle.yPos}, Fläche: ${someCircle.area()}")
}