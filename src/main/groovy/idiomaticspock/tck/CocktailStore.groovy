package idiomaticspock.tck

import com.google.common.collect.ImmutableCollection

interface CocktailStore {
  void insert(Cocktail cocktail)
  ImmutableCollection<Cocktail> list()
  ImmutableCollection<Cocktail> findByBaseSpirit(String baseSpirit)
}