package hero;

class HeroNotFoundException extends RuntimeException {

  HeroNotFoundException(Long id) {
    super("Could not find Heroi " + id);
  }
}