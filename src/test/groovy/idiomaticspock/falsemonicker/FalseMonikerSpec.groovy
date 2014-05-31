package idiomaticspock.falsemonicker

import spock.lang.Ignore
import spock.lang.See
import spock.lang.Specification
import spock.lang.Subject

import java.time.Year

@See("http://stateyourbizness.blogspot.com/2008/07/good-unit-testing-practice.html")
class FalseMonikerSpec extends Specification {

  @Subject def ships = new ShipStore()

  def "can find ships by allegiance ordered by age v1"() {
    given:
    ships <<
      new Ship("Enterprise", "Federation", Year.of(2245)) <<
      new Ship("Adventure", "Federation", Year.of(2376)) <<
      new Ship("Haakona", "Romulan", Year.of(2357))

    expect:
    def matches = ships.findByAllegianceNewestFirst("Federation")
    matches.name == ["Enterprise", "Haakona", "Adventure"]
  }

  @Ignore("The previous test passes as it doesn't test the behavior properly. This is an example of a better way to implement it")
  def "can find ships by allegiance ordered by age v2"() {
    given:
    ships <<
      new Ship("Enterprise", "Federation", Year.of(2245)) <<
      new Ship("Adventure", "Federation", Year.of(2376)) <<
      new Ship("Haakona", "Romulan", Year.of(2357))

    expect:
    def matches = ships.findByAllegianceNewestFirst("Federation")
    matches.allegiance.every { it == "Federation" }
    matches.enteredService == matches.enteredService.sort().reverse()
  }
}



