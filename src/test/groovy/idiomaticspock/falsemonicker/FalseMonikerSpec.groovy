package idiomaticspock.falsemonicker

import groovy.transform.TupleConstructor
import spock.lang.See
import spock.lang.Specification
import spock.lang.Subject

import static idiomaticspock.falsemonicker.Spirit.GIN
import static idiomaticspock.falsemonicker.Spirit.WHISKEY

@See("http://stateyourbizness.blogspot.com/2008/07/good-unit-testing-practice.html")
class FalseMonikerSpec extends Specification {

  @Subject def cocktailFinder = new CocktailFinder()

  def "can find cocktails by base spirit"() {
    given:
    def oldFashioned = new Cocktail("whiskey, bitters and sugar syrup", WHISKEY, 1860)
    def negroni = new Cocktail("whiskey, vermouth and Campari", GIN, 1919)
    def whiskeySour = new Cocktail("whiskey, lemon juice and sugar", WHISKEY, 1870)
    cocktailFinder << oldFashioned << negroni << whiskeySour

    expect:
    def matches = cocktailFinder.findByBaseSpiritNewestFirst(WHISKEY)
    matches[0].description == "whiskey, bitters and sugar syrup"
    matches[1].description == "whiskey, lemon juice and sugar"
    matches[2].description == "whiskey, vermouth and Campari"
  }
}



