package pl.english.teacher

import org.jooq.DSLContext
import org.jooq.impl.DSL.field
import org.jooq.impl.DSL.table
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@SpringBootApplication
@ComponentScan("pl.english")
class SpringBootMain : CommandLineRunner {
   val dslContext: DSLContext

   @Autowired constructor(dslContext: DSLContext) {
      this.dslContext = dslContext
   }

   override fun run(vararg args: String?) {
      println("Invoked dslContext: $dslContext")
   }
}





fun main(args: Array<String>) {
   runApplication<SpringBootMain>(*args)
}

