package fhnw.emoba.modules.module05

import fhnw.emoba.modules.module05.city.data.City
import junit.framework.Assert.assertEquals
import org.json.JSONObject
import org.junit.Test

class CityTest {
    //triple quotes markieren einen "Raw String". Sehr praktisch.
    private val cityAsString = """
             {
                "id": 7287441,
                "name": "Verscio",
                "state": "",
                "country": "CH",
                "coord": {
                "lon": 8.72797,
                "lat": 46.193321
    }
  }
    """.trimIndent()

    @Test
    fun testConstructor() {
        //given
        val cityAsJSON = JSONObject(cityAsString)

        //when
        val city = City(cityAsJSON)

        //then
        with(city) {
            assertEquals(7287441, id)
            assertEquals("Verscio", name)
            assertEquals("", state)
            assertEquals("CH", country)
            assertEquals("2", coord.lon)
        }
    }
}