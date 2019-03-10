package pl.english.teacher.englishwords

import org.junit.Assert
import org.junit.Test
import java.nio.file.Paths
import java.util.*

// fixme zminic pakiety z java na kotlin
class EnglishWordParserTest {

    var englishWordParser = EnglishWordParser()

    @Test
    fun shouldParseEnglishWordsFile() {
        // given
        val expectedEnglishWords = Arrays.asList(EnglishWord("comes out", "schodzić"), EnglishWord("fabulous", "bajeczny"), EnglishWord("suddenly", "nagle"))

        //when
        val actualEnglishWords = englishWordParser.parseFile(Paths.get("src/test/java/resources/testEnglishWords.csv"))

        //then
        Assert.assertArrayEquals(actualEnglishWords.toTypedArray(), expectedEnglishWords.toTypedArray())
    }
}
