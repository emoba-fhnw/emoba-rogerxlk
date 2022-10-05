package kotlinplayground.module03

import kotlinplayground.module03.classes.Circle
import kotlinplayground.module03.classes.Figure
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FigureTest {

    @Test
    fun testFigure() {
        //given
        var figure1 = Figure()

        var area = 10;

        //when
        var radius =

        //then
        assertEquals(0, figure1.xPos)
        assertEquals(10, figure1.yPos)

    }

    @Test
    fun testCircle(){
        //given
        var circle1 = Circle(3.0, 0,0)

        //when


        //then
        assertEquals(3.0,circle1.radius)
        assertEquals(0,circle1.xPos)
        assertEquals(0,circle1.yPos)

    }

}