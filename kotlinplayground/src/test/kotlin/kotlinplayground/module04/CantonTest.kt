package kotlinplayground.module04

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CantonTest {

    @Test
    fun testEquals() {
        val someCanton = Canton(1)
        val otherCanton = Canton(1)
        val thirdCanton = Canton(2)

        assertTrue(someCanton == otherCanton) //equals, prüft immer nur die Parameter der Klasse
        assertFalse(thirdCanton == someCanton)
    }
}