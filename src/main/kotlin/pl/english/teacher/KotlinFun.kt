package pl.english.teacher

fun main() {

    val accounts = listOf(
            Account(1, "adam1"),
            Account(2, "adam2"),
            Account(2, "adam2-2"),
            Account(3, "adam3")
    )

    val accounts2 = accounts
            .zipWithNext()
            .filter { it.first.id != it.second.id }
            .map { listOf(it.first, it.second) }
            .flatten()
            .distinctBy { a -> a.id }

    println("acc2 $accounts2")
    


}

data class Account(val id: Int, val name: String) {
    override fun toString(): String {
        return "Id: $id, Name: $name\n"
    }
}