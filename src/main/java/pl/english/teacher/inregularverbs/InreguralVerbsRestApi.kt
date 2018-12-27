package pl.english.teacher.inregularverbs

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/inregularverbs")
class InreguralVerbsRestApi {

    val inregularVerbService = InregularVerbService()

    @GetMapping("/all")
    fun getAllInregularVerbs(): List<InregularVerb> {
        return inregularVerbService.getAllInregularVerbs()
    }
}