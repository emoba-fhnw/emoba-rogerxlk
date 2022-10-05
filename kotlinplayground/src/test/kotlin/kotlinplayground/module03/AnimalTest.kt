package kotlinplayground.module03

import kotlinplayground.module03.classes.Animal
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AnimalTest {

    @Test
    fun testAnimal(){

        val animal1 = Animal()

        assertEquals(0,animal1.age)
        assertTrue(animal1.alive)
    }

    @Test
    fun testGeriatricAnimal(){
        val youngAnimal = Animal(age = 5)
        val oldAnimal = Animal(age = 6)

//        assertFalse(youngAnimal.isGeriatric())
//        assertTrue(oldAnimal.isGeriatric())
    }
}