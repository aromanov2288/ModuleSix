package ru.romanov.modulesix.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.romanov.modulesix.domain.mongo.MongoAuthor;
import ru.romanov.modulesix.domain.mongo.MongoBook;
import ru.romanov.modulesix.domain.mongo.MongoComment;
import ru.romanov.modulesix.domain.mysql.MySqlAuthor;
import ru.romanov.modulesix.domain.mysql.MySqlBook;
import ru.romanov.modulesix.domain.mysql.MySqlComment;

import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    public JobBuilderFactory jobBuilderFactory;

    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public ItemReader<MySqlBook> reader(EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<MySqlBook>()
                .name("mysqlBookReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT b FROM MySqlBook b")
                .build();
    }

    @Bean
    public ItemProcessor processor() {
        return (ItemProcessor<MySqlBook, MongoBook>) mySqlBook -> {
            String name = mySqlBook.getName();
            String genre = mySqlBook.getGenre().getName();
            Set<MongoAuthor> mongoAuthorsSet = new HashSet<>();
            for (MySqlAuthor mySqlAuthor : mySqlBook.getAuthorsSet()){
                MongoAuthor mongoAuthor = new MongoAuthor(mySqlAuthor.getFio());
                mongoAuthorsSet.add(mongoAuthor);
            }
            Set<MongoComment> mongoCommentsSet = new HashSet<>();
            for (MySqlComment mySqlComment : mySqlBook.getCommentsSet()) {
                MongoComment mongoComment = new MongoComment(mySqlComment.getText());
                mongoCommentsSet.add(mongoComment);
            }
            MongoBook mongoBook = new MongoBook(name, genre, mongoAuthorsSet);
            mongoBook.setCommentsSet(mongoCommentsSet);
            return mongoBook;
        };
    }

    @Bean
    public ItemWriter<MongoBook> writer (MongoTemplate mongoTemplate) {
        return new MongoItemWriterBuilder<MongoBook>()
                .collection("books")
                .template(mongoTemplate)
                .build();
    }

    @Bean
    public Job importUserJob(Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(ItemReader reader, ItemWriter writer, ItemProcessor processor) {
        return stepBuilderFactory.get("step1")
                .chunk(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
