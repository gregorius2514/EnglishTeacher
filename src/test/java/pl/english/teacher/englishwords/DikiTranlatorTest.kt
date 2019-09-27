package pl.english.teacher.englishwords

import org.junit.Test
import pl.english.teacher.DikiTranlator



class DikiTranlatorTest {
    
    @Test
    fun parseHelloText() {
       val parser = DikiTranlator() 
        
        val translated = parser.translate("hello")

        println(translated)
    }
}
