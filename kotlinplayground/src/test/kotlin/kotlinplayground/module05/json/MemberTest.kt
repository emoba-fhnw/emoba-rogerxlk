package kotlinplayground.module05.json

import kotlinplayground.module05.json.Member
import org.json.JSONObject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MemberTest {
    
    //triple quotes markieren einen "Raw String". Sehr praktisch.
    private val memberAsString = """
            {
              "name": "Molecule Man",
              "age": 29,
              "secretIdentity": "Dan Jukes",
              "powers": [
                "Radiation resistance",
                "Turning tiny",
                "Radiation blast"
              ]
            }
    """.trimIndent()
    
    @Test
    fun testConstructor(){
        //given
        val memberAsJSON = JSONObject(memberAsString)
        
        //when
        val member = Member(memberAsJSON)
        
        //then
        with(member) {
            assertEquals("Molecule Man", name)
            assertEquals(29, age)
            assertEquals("Dan Jukes", secretIdentity)
            assertEquals(3, powers.size)
            assertEquals("Radiation blast", powers.last())
        }
    }
}