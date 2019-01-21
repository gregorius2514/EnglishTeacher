package pl.english.teacher;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.jooq.*;
import org.jooq.impl.DSL;
import pl.english.teacher.generated.english_teacher.tables.EnglishWord;

public class JooqFun {

  public static void main(String[] args) {
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/english_teacher");
    hikariConfig.setUsername("root");
    hikariConfig.setPassword("");

    DataSource hikariDataSource = new HikariDataSource(hikariConfig);

    DSLContext dslContext = DSL.using(hikariDataSource, SQLDialect.MYSQL_5_7);

//    dslContext
//        .insertInto(EnglishWord.ENGLISH_WORD, EnglishWord.ENGLISH_WORD
//        .WORD, EnglishWord.ENGLISH_WORD.WORD_TRANSLATION)
//        .values("fun", "zabawa")
//        .execute();

    Record col = dslContext
        .select(EnglishWord.ENGLISH_WORD.fields())
        .from(EnglishWord.ENGLISH_WORD)
        .fetchAny();

    System.out.println("record: " + col);



  }

}
