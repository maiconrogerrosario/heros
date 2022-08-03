package heros;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
class HeroController {

  private final HeroRepository repository;
  
  private final PowerRepository powerRepository;

  
  private final HeroModelAssembler assembler;

  HeroController(HeroRepository repository, PowerRepository powerRepository, HeroModelAssembler assembler) {
	 
	  this.powerRepository = powerRepository;
    this.repository = repository;
    this.assembler = assembler;
  }
  

  @GetMapping("/heros")
  CollectionModel<EntityModel<Hero>> all() {

    List<EntityModel<Hero>> hero = repository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());

    return CollectionModel.of(hero, linkTo(methodOn(HeroController.class).all()).withSelfRel());
  }
  // end::get-aggregate-root[]

  @PostMapping("/hero")
  ResponseEntity<?> newHero(@RequestBody Hero newHero) {
	  
	  
   EntityModel<Hero> entityModel = assembler.toModel(repository.save(new Hero(newHero, powerRepository.save(newHero.getPower_stats()))));
    
    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  // Single item
  
  @GetMapping("/hero/{id}")
  EntityModel<Hero> one(@PathVariable Long id) {
	  Hero hero = repository.findById(id) //
		      .orElseThrow(() -> new HeroNotFoundException(id));

		  return assembler.toModel(hero);
  
  }
  
  
  

  @GetMapping("/hero/name/{name}")
  Hero findByname(@PathVariable String name) {
  Hero hero = repository.findByname(name);
	return hero;
  
  }
  
  
  @GetMapping("/hero/name1/{name1}/name2/{name2}")
  String compareHero(@PathVariable String name1, @PathVariable String name2) {
	  
	  
	  Hero hero1 = repository.findByname(name1);
	  Hero hero2 = repository.findByname(name2);
	 return   hero1.compareHero(hero1, hero2);
	 
	 
  }
  

  @PutMapping("/hero/{id}")
  ResponseEntity<?> replaceHero(@RequestBody Hero newHero, @PathVariable Long id) {

    Hero updatedHero = repository.findById(id) //
        .map(hero -> {
          hero.setName(newHero.getName());
         
		  
          return repository.save(hero);
        }) //
        .orElseGet(() -> {
          newHero.setId(id);
          return repository.save(newHero);
        });

    EntityModel<Hero> entityModel = assembler.toModel(updatedHero);

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }
  
  @DeleteMapping("/hero/{id}")
  ResponseEntity<?> deleteHero(@PathVariable Long id) {
	  ResponseEntity<Object> delete;
	if (repository.existsById(id)) {
	    repository.deleteById(id);
	    delete = ResponseEntity.noContent().build();

	}else {
	   delete = ResponseEntity.notFound().build();
	
	}
	return delete;

  }
  

}