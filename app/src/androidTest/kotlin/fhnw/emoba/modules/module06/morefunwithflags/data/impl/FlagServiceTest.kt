package fhnw.emoba.modules.module06.morefunwithflags.data.impl

import org.junit.Assert.assertNotSame
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagSize

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 */
@RunWith(AndroidJUnit4::class)
internal class FlagServiceTest{
    @Test
    fun testRequestFlag(){
        //given
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val service = LocalFlagService(appContext) //todo: umstellen auf RemoteFlagService
       // val service = RemoteFlagService()
        
        //when
        val img = service.requestFlag("ch", FlagSize.x550)
        
        //then
        assertNotSame(FlagSize.x550.defaultImage, img)
    }
    
}