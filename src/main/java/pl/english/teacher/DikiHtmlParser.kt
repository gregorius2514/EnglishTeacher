package pl.english.teacher

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import java.util.regex.Pattern


class DikiTranlator : LanguageTranslator {

    private val dikiTranslatorUrl = "https://www.diki.pl/slownik-angielskiego?q="
    private val translationRegexFinder = Pattern.compile("<a.*>(.*)?<.*")
    private val translationHtmlElementWithClass = "a.plainLink"
    private val translationPositionIndex = 1

    override fun translate(wordToTranslate: String): ArrayList<String> {
        val translatedWords = ArrayList<String>()

        Jsoup.connect("$dikiTranslatorUrl$wordToTranslate").get().run {
            select(translationHtmlElementWithClass).forEach { element ->
                translatedWords.add(convertHtmlElementToPlainTranslatedWord(element))
            }
        }
        return translatedWords
    }

    private fun convertHtmlElementToPlainTranslatedWord(translationHtmlLink: Element): String {
        val translationMatcher = translationRegexFinder.matcher(translationHtmlLink.toString())
        translationMatcher.find()
        return translationMatcher.group(translationPositionIndex)
    }
}

