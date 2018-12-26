package pl.english.teacher.inregularverbs

import pl.english.teacher.CsvParser
import java.io.FileReader
import java.nio.file.Path

class InregularVerbParser : CsvParser<InregularVerb> {

    override fun parseFile(csvFilePath: Path): List<InregularVerb> {
        require(csvFilePath != null) { "Expected non-null csvFilePath" }

        FileReader(csvFilePath.toFile()).use { inregularVerbFile ->
            return inregularVerbFile
                    .readLines()
                    .map { csvRow ->
                        val inregularVerbRow = csvRow.split(",")
                        InregularVerb(inregularVerbRow[0], inregularVerbRow[1],
                                inregularVerbRow[2], inregularVerbRow[3])
                    }
                    .toCollection(ArrayList())
        }
    }
}


