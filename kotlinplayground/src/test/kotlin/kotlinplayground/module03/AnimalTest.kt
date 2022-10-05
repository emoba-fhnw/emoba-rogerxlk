package kotlinplayground.module03

import kotlinplayground.module03.classes.Animal
import kotlinplayground.module03.classes.Dog
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

        assertFalse(youngAnimal.isGeriatric())
        assertTrue(oldAnimal.isGeriatric())
    }

    @Test
    fun testDog(){
        val dog1 = Dog();
        val dog2 = Dog(35.0, true, 12)

        assertEquals(0, dog1.age)
        assertEquals(35.0, dog2.weight)
        assertTrue(dog2.isGeriatric())
    }
}