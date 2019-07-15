package pl.english.teacher

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import javax.sql.DataSource

// run docker image
// docker run --name postgres -d -p 5432:5432 -e POSTGRES_PASSWORD=root postgres:11.4
fun main() {

    val hikariConfig = HikariConfig()
    hikariConfig.jdbcUrl = "jdbc:postgresql://localhost:5432/english_teacher"
    hikariConfig.username = "english_teacher"
    hikariConfig.password = "english_teacher"
    hikariConfig.connectionTestQuery = "SELECT 1 "
    
    val hikariDataSource: DataSource = HikariDataSource(hikariConfig)

     DSL.using(hikariDataSource, SQLDialect.POSTGRES).let {dslContext ->
         dslContext.fetch("select * from account")
        
    }
//    val fruits = dslContext.fetch("Select * from account")

//    dslContext.insertInto(ACCOUNT, )
   
//    dslContext.close()
}