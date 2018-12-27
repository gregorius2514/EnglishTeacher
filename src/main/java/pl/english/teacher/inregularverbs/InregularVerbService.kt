package pl.english.teacher.inregularverbs

import java.nio.file.Paths

class InregularVerbService {

    private val inregularVerbParser = InregularVerbParserFactory().createParser()
    private val inregularVerbs: List<InregularVerb> by lazy {
        inregularVerbParser.parseFile(Paths.get("inregularVerbs.csv"))
    }

    fun getAllInregularVerbs() = inregularVerbs
}