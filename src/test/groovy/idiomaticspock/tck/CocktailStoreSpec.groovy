package idiomaticspock.tck

import spock.lang.Specification
import spock.lang.Subject

abstract class CocktailStoreSpec<T extends CocktailStore> extends Specification {

  @Subject T cocktails

  def "can insert a new cocktail"() {
    when:
    cocktails.insert(new Cocktail("Boulevardier", "whiskey"))

    then:
    cocktails.list().size() == old(cocktails.list().size()) + 1
  }

  def "can find cocktails by base spirit"() {
    given:
    cocktails.insert(new Cocktail("Boulevardier", "whiskey"))
    cocktails.insert(new Cocktail("Negroni", "gin"))
    cocktails.insert(new Cocktail("Old Fashioned", "whiskey"))

    when:
    def results = cocktails.findByBaseSpirit("whiskey")

    then:
    results.size() == 2
    results.every { it.baseSpirit == "whiskey" }
  }
}
