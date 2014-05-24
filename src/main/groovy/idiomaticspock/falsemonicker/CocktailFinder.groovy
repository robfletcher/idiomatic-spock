package idiomaticspock.falsemonicker

import groovy.transform.CompileStatic

class CocktailFinder {
  @Delegate private final List<Cocktail> cocktails = []

  List<Cocktail> findByBaseSpiritNewestFirst(Spirit spirit) {
    cocktails.sort { it.invented }
  }
}
