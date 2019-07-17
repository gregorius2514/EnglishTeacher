package pl.english.teacher

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import pl.english.teacher.generated.tables.Account
import java.sql.Timestamp
import javax.sql.DataSource
import pl.english.teacher.generated.tables.Account.ACCOUNT as ACCOUNT

// run docker image
// docker run --name postgres -d -p 5432:5432 -e POSTGRES_PASSWORD=root postgres:11.4
fun main() {
    val hikariConfig = HikariConfig()
    hikariConfig.jdbcUrl = "jdbc:postgresql://localhost:5432/english_teacher"
    hikariConfig.username = "english_teacher"
    hikariConfig.password = "english_teacher"
    hikariConfig.connectionTestQuery = "SELECT 1 "

    val hikariDataSource: DataSource = HikariDataSource(hikariConfig)

    DSL.using(hikariDataSource, SQLDialect.POSTGRES).let { dslContext ->
        dslContext.fetch("select * from account")
        
        dslContext.insertInto(ACCOUNT, ACCOUNT.USER_ID, ACCOUNT.USERNAME, ACCOUNT.PASSWORD, ACCOUNT.EMAIL, ACCOUNT.CREATED_ON)
                .values(100, "admin", "admin", "admin@o2.pl", Timestamp(System.currentTimeMillis()))
                .execute()

        dslContext.fetch("select * from account")
    }
}