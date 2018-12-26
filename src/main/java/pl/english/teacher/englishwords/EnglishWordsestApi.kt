package pl.english.teacher.englishwords

import org.springframework.web.bind.annotation.*
import java.nio.file.Paths

@RestController
@RequestMapping("/englishword")
class EnglishWordsApi {

    val englishWords: List<EnglishWord>

    init {
        this.englishWords = EnglishWordParser(";").parseFile(Paths.get("englishWords.csv"))
    }

    @GetMapping("/all")
    fun getAllEnglishWords(): List<EnglishWord> {
        return englishWords
    }

    @PutMapping("/add")
    fun addEnglishWord(@RequestBody(required = true) englishWord: EnglishWord): List<EnglishWord> {
        val englishWordsMutable = englishWords.toMutableList()
        englishWordsMutable.add(englishWord)

        return englishWordsMutable
    }
}