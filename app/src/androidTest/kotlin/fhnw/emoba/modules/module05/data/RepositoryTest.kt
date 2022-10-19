package fhnw.emoba.modules.module05.squad.data


import org.junit.Assert.assertEquals
import org.junit.Test
import androidx.test.platform.app.InstrumentationRegistry

internal class RepositoryTest {
    
    @Test
    fun testLoadData() {
        // given
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        
        //when
        SquadRepository.loadSquad(appContext)
        
        //then
        SquadRepository.squad.apply {
            assertEquals("Super hero squad", squadName)
            assertEquals(2016,               formed)
            assertEquals(3,                  members.size)
            assertEquals("Molecule Man",     members[0].name)
        }
    }
    
}