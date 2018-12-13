package pl.english.teacher

import org.jsoup.Jsoup
import java.util.regex.Pattern

fun main(args: Array<String>) {
    Jsoup.connect("https://www.diki.pl/slownik-angielskiego?q=pussy").get().run {
        select("a.plainLink").forEach { element ->
            val value = element.toString()
            val matcher = Pattern.compile("<a.*>(.*)?<.*").matcher(value)
            matcher.find()
            val group = matcher.group(1)
            println("$group")
        }
    }
}
