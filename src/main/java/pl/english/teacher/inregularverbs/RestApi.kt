package pl.english.teacher.inregularverbs

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Paths

@RestController
class RestApi {

    val inregularVerbs:List<InregularVerb>

    init {
        this.inregularVerbs = InregularVerbParser().parseFile(Paths.get("inregularVerbs.csv"))
    }

    @GetMapping("/all")
    fun getAllInregularVerbs(): List<InregularVerb> {
            return inregularVerbs
    }
}