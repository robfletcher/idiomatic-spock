package idiomaticspock.functionalstyle

import groovy.transform.CompileStatic
import groovy.transform.Immutable
import spock.lang.Specification
import spock.lang.Subject

class EverySpec extends Specification {
  @Subject
  def cocktails = new CocktailFinder()

  def setup() {
    cocktails << new Cocktail("Old Fashioned", "Whiskey")
    cocktails << new Cocktail("Martini", "Gin")
    cocktails << new Cocktail("Aviation", "Gin")
    cocktails << new Cocktail("Negroni", "Gin")
    cocktails << new Cocktail("Boulevardier", "Whiskey")
    cocktails << new Cocktail("Daiquiri", "Rum")
  }

  def "can find cocktails by base spirit (v1)"() {
    when:
    def results = cocktails.findByBaseSpirit("Gin")

    then:
    results.size() == 3
    results[0].baseSpirit == "Gin"
    results[1].baseSpirit == "Gin"
    results[2].baseSpirit == "Gin"
  }

  def "can find cocktails by base spirit (v2)"() {
    when:
    def results = cocktails.findByBaseSpirit("Gin")

    then:
    results.every {
      it.baseSpirit == "Gin"
    }
  }

  def "can find cocktails by base spirit (v3)"() {
    when:
    def results = cocktails.findByBaseSpirit("Gin")

    then:
    results.baseSpirit.every {
      it == "Gin"
    }
  }
}
