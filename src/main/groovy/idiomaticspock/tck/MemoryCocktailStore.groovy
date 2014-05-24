package idiomaticspock.tck

import com.google.common.collect.ImmutableCollection
import com.google.common.collect.ImmutableSet
import com.google.common.collect.Sets
import groovy.transform.CompileStatic

@CompileStatic
class MemoryCocktailStore implements CocktailStore {

  private final Collection<Cocktail> cocktails = Sets.newHashSet()

  @Override
  void insert(Cocktail cocktail) {
    cocktails << cocktail
  }

  @Override
  ImmutableCollection<Cocktail> list() {
    ImmutableSet.copyOf(cocktails)
  }

  @Override
  ImmutableCollection<Cocktail> findByBaseSpirit(String baseSpirit) {
    ImmutableSet.copyOf cocktails.findAll { it.baseSpirit == baseSpirit }
  }
}
