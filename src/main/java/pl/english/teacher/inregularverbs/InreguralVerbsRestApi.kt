package pl.english.teacher.inregularverbs

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/inregularverb")
class InreguralVerbsRestApi {

    val inregularVerbService = InregularVerbService()

    @GetMapping("/all")
    fun getAllInregularVerbs(): List<InregularVerb> {
        return inregularVerbService.getAllInregularVerbs()
    }

    @GetMapping("/all/random")
    fun getAllInregularVerbsInRandomOrder(): List<InregularVerb> {
        return inregularVerbService
                .getAllInregularVerbs()
                .shuffled()
    }

    @PostMapping("/check")
    fun checkInregularVerb(@RequestBody inregularVerbToCheck: InregularVerb) : InregularVerb {
        // todo metoda wymaga refactoringu

        var foundInregularVerb = inregularVerbService
                .getAllInregularVerbs()
                .filter { inregularVerb ->
                    inregularVerb.firstForm.equals(inregularVerbToCheck.firstForm) ||
                            inregularVerb.secondForm.equals(inregularVerbToCheck.secondForm) ||
                            inregularVerb.thirdForm.equals(inregularVerbToCheck.thirdForm)
                }.first()

        foundInregularVerb.changeAnswerCorrectness(inregularVerbToCheck)
        return foundInregularVerb
    }
}