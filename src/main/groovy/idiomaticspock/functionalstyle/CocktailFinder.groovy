package idiomaticspock.functionalstyle

import groovy.transform.CompileStatic

@CompileStatic
class CocktailFinder {
  @Delegate
  private final Collection<Cocktail> cocktails = []

  Collection<Cocktail> findByBaseSpirit(String baseSpirit) {
    cocktails.findAll { it.baseSpirit == baseSpirit }
  }
}
