package kotlinplayground.module05.json

import kotlinplayground.module05.json.Squad
import org.json.JSONObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SquadTest {
    //triple quotes markieren einen "Raw String". Sehr praktisch
    val squadAsString = """
    {
      "squadName": "Super hero squad",
      "homeTown": "Metro City",
      "formed": 2016,
      "secretBase": "Super tower",
      "active": true,
      "members": [
        {
          "name": "Molecule Man",
          "age": 29,
          "secretIdentity": "Dan Jukes",
          "powers": [
            "Radiation resistance",
            "Turning tiny",
            "Radiation blast"
          ]
        },
        {
          "name": "Madame Uppercut",
          "age": 39,
          "secretIdentity": "Jane Wilson",
          "powers": [
            "Million tonne punch",
            "Damage resistance",
            "Superhuman reflexes"
          ]
        }
      ]
    }
    """.trimIndent()
    
    @Test
    fun testConstructor(){
        //given
        val squadAsJSON = JSONObject(squadAsString)
        
        //when
        val squad = Squad(squadAsJSON)
        
        //then
        with(squad) {
//            assertEquals("Super hero squad", squadName)
//            assertEquals("Metro City", homeTown)
//            assertEquals(2016, formed)
//            assertEquals("Super tower", secretBase)
//            assertTrue(active)
//            assertEquals(2, members.size)
//            assertEquals("Molecule Man", members[0].name)
        }
        
    }
}