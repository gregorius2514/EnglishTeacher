package pl.english.teacher.inregularverbs

import pl.english.teacher.CsvParser
import java.io.FileReader
import java.nio.file.Path

// fixme uwspojnic separatory by byly jednolie np. uzyc ';'
class InregularVerbParser(private val csvSeparator: String = ",") : CsvParser<InregularVerb> {

    override fun parseFile(csvFilePath: Path): List<InregularVerb> {
        FileReader(csvFilePath.toFile()).use { inregularVerbFile ->
            return inregularVerbFile
                    .readLines()
                    .map { csvRow ->
                        val inregularVerbRow = csvRow.split(csvSeparator)
                        InregularVerb(inregularVerbRow[2], inregularVerbRow[3],
                                inregularVerbRow[4], inregularVerbRow[5], inregularVerbRow[0],
                                inregularVerbRow[1])
                    }
                    .toCollection(ArrayList())
        }
    }
}


