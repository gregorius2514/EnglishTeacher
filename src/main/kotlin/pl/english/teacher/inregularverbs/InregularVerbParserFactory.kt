package pl.english.teacher.inregularverbs

import pl.english.teacher.CsvParserFactory

class InregularVerbParserFactory : CsvParserFactory<InregularVerbParser> {

    override fun createParser(): InregularVerbParser {
        return InregularVerbParser(csvSeparator())
    }

    override fun csvSeparator(): String {
        return ","
    }

}