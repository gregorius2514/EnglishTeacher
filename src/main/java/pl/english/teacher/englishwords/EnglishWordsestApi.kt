package pl.english.teacher.englishwords

import org.springframework.web.bind.annotation.*
import pl.english.teacher.DikiTranlator

@RestController
@RequestMapping("/englishword")
class EnglishWordsApi {

    val englishWordService = EnglishWordService()
    val wordTranslator = DikiTranlator()

    @GetMapping("/all")
    fun getAllEnglishWords(): List<EnglishWord> {
        return englishWordService.getAllEnglishWords()
    }

    @PutMapping("/add")
    fun addEnglishWord(@RequestBody englishWord: EnglishWord): List<EnglishWord> {
        require(englishWord.word != null && englishWord.translation != null) {
            "Expected non-null word and translation"
        }
        return englishWordService.storeWord(englishWord)
    }

    @GetMapping("/translate/{word}")
    fun translateWord(@PathVariable word: String): List<String> {
        if (!word.isBlank()) {
            return wordTranslator.translate(word)
        }
        return ArrayList()
    }

}
