package pl.english.teacher.englishwords

import pl.english.teacher.CsvParserFactory

class EnglishWordFactory : CsvParserFactory<EnglishWordParser> {

    override fun createParser(): EnglishWordParser {
        return EnglishWordParser()
    }
}