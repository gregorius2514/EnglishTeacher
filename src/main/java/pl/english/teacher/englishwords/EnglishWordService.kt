package pl.english.teacher.englishwords

import java.nio.file.Paths

class EnglishWordService {

    private val englishWordParser = EnglishWordFactory().createParser()

    fun getAllEnglishWords() = englishWordParser.parseFile(Paths.get("englishWords.csv"))

    fun storeWord(englishWord: EnglishWord): List<EnglishWord> {
        englishWordParser.storeWord(englishWord)
        return getAllEnglishWords()
    }

}


