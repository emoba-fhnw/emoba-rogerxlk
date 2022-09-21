package kotlinplayground.module01

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*


// ACHTUNG: im Kotlin-Playground arbeiten wir mit JUNIT 5
class SetupTest{

    @Test
    fun testJunitSetup(){
        //given
        val s1 = 1
        val s2 = 2

        //when
        val sum = s1 + s2

        //then
        assertEquals(3, sum)
    }

}