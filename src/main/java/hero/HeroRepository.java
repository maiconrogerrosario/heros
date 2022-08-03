package hero;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface HeroRepository extends JpaRepository<Hero, Long> {

	Hero findByname(String name);

	

	
	

}