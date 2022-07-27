package it.cch.exercise3.configuration;

import it.cch.data.Category;
import it.cch.data.Product;
import it.cch.exercise3.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase  {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase .class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {

        return args -> {
            //this is ugly
            log.info("Preloading " + repository.save(new Product("Macbook", Category.CAT1, 1, 999.99)));
            log.info("Preloading " + repository.save(new Product("iPhone", Category.CAT2, 3, 1000.00)));
            log.info("Preloading " + repository.save(new Product("MacbookPRO", Category.CAT1, 3, 9998.99)));
            log.info("Preloading " + repository.save(new Product("OnePlus6", Category.CAT2, 8, 568.99)));
            log.info("Preloading " + repository.save(new Product("Nokia 3330", Category.CAT1, 99, 10.15)));
            log.info("Preloading " + repository.save(new Product("Motorola TAC", Category.CAT3, 3, 500.59)));
            log.info("Preloading " + repository.save(new Product("iPad", Category.CAT5, 3, 10500.59)));
        };
    }
}
