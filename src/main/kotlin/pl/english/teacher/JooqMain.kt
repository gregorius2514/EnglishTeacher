package pl.english.teacher

import org.jooq.SQLDialect
import org.jooq.impl.DSL
import java.sql.DriverManager

// run docker image
// docker run --name postgres -d -p 5432:5432 -e POSTGRES_PASSWORD=root postgres:11.4
fun main() {
    val con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root")
    val dslContext = DSL.using(con, SQLDialect.POSTGRES);

    val fruits = dslContext.fetch("Select * from account")
}