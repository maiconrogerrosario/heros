package heros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(HeroRepository heroRepository, PowerRepository powerRepository) {

    return args -> {
    	
    	Power poderBatman = powerRepository.save(new Power(10,20,30,40));
    	Power poderSuperman = powerRepository.save(new Power(20,30,40,50));

    	log.info("Preloading " + heroRepository.save(new Hero("Batman","Human",true,poderBatman)));
    	log.info("Preloading " + heroRepository.save(new Hero("Superman","Alien",true,poderSuperman)));
		
    	
    	
    };
  }
}