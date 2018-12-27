package pl.english.teacher.englishwords

import java.nio.file.Paths

class EnglishWordService {

    private val englishWordParser = EnglishWordFactory().createParser()
    private val englishWords: List<EnglishWord> by lazy {
        englishWordParser.parseFile(Paths.get("englishWords.csv"))
    }

    fun getAllEnglishWords() = englishWords

    fun storeWord(englishWord: EnglishWord) {
        englishWordParser.storeWord(englishWord)
    }
}


