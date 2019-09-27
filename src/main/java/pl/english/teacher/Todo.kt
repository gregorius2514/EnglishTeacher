package pl.english.teacher

import com.mongodb.MongoClient
import org.bson.Document
import org.bson.types.ObjectId

fun main() {
val mongoClient = MongoClient("localhost", 27017)
val databaseConnection = mongoClient.getDatabase("TodoApp")

databaseConnection.getCollection("notes") ?: databaseConnection.createCollection("notes")
val notes = databaseConnection.getCollection("notes")

val convertedNotest = notes
        .find()
        .map { note ->
            val id = note.get("_id") as ObjectId
            val title = note.get("title") as String
            val message = note.get("message") as String
            Note(id.toString(), title, message)
        }.toList()

println("Notes: $convertedNotest")


val list = listOf(
        Note("", "abc", "add"),
        Note("", "aa", "xxx"),
        Note("", "bb", "zzz")
)
        .map { n ->
            val map = mapOf<String, Any>()
                    .plus(Pair("title", n.title))
                    .plus(Pair("message", n.message))
            Document(map)
        }

notes.insertMany(list)
}

data class Note(private val id: String, val title: String, val message: String)