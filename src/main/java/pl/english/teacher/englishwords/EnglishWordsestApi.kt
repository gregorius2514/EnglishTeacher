package pl.english.teacher.englishwords

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/englishword")
class EnglishWordsApi {

    val englishWordService = EnglishWordService()

    @GetMapping("/all")
    fun getAllEnglishWords(): List<EnglishWord> {
        return englishWordService.getAllEnglishWords()
    }

//    @PutMapping("/add")
//    fun addEnglishWord(@RequestBody(required = true) englishWord: EnglishWord): EnglishWord {
//        val wordTranslator = DikiTranlator()
//        var chosenTranslation = ""
//        FileWriter("englishWords.csv", true).use { outputFile ->
//            val translations = wordTranslator.translate(englishWord.word)
//            chosenTranslation = translations.get(1)
//            outputFile.write("${englishWord.word};$chosenTranslation\n")
//        }
//        return EnglishWord(englishWord.word, chosenTranslation)
//    }
}
