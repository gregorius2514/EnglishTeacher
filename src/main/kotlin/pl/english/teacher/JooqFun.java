package pl.english.teacher;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.sql.DataSource;

public class JooqFun {

    public static void main(String[] args) {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl("jdbc:h2:mem:test;INIT=runscript from 'classpath:/db.sql'");
//        hikariConfig.setUsername("sa");
//        hikariConfig.setPassword("");
//
//        DataSource hikariDataSource = new HikariDataSource(hikariConfig);
//
//        DSLContext dslContext = DSL.using(hikariDataSource, SQLDialect.H2);

//    dslContext
//        .insertInto(EnglishWord.ENGLISH_WORD, EnglishWord.ENGLISH_WORD
//        .WORD, EnglishWord.ENGLISH_WORD.WORD_TRANSLATION)
//        .values("fun", "zabawa")
//        .execute();

//    Record col = dslContext
//        .select(EnglishWord.ENGLISH_WORD.fields())
//        .from(EnglishWord.ENGLISH_WORD)
//        .fetchAny();

//    System.out.println("record: " + col);
        


    }

}
