package idiomaticspock.functionalstyle

import spock.lang.Specification
import spock.lang.Subject

class EverySpec extends Specification {
  @Subject
  def ships = new ShipStore()

  def setup() {
    ships << new Ship("Gr'oth", "Klingon")
    ships << new Ship("Enterprise", "Federation")
    ships << new Ship("Constitution", "Federation")
    ships << new Ship("Constellation", "Federation")
    ships << new Ship("M'Char", "Klingon")
    ships << new Ship("Haakona", "Romulan")
  }

  def "can find ships by allegiance (v1)"() {
    when:
    def results = ships.findByAllegiance("Federation")

    then:
    results.size() == 3
    results[0].allegiance == "Federation"
    results[1].allegiance == "Federation"
    results[2].allegiance == "Federation"
  }

  def "can find ships by allegiance (v2)"() {
    when:
    def results = ships.findByAllegiance("Federation")

    then:
    results.every {
      it.allegiance == "Federation"
    }
  }

  def "can find ships by allegiance (v3)"() {
    when:
    def results = ships.findByAllegiance("Federation")

    then:
    results.allegiance.every {
      it == "Federation"
    }
  }
}
