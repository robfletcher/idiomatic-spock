package idiomaticspock.tck

import idiomaticspock.starships.Ship
import idiomaticspock.starships.ShipStore
import spock.lang.Specification
import spock.lang.Subject

import java.time.Year

abstract class ShipStoreSpec<T extends ShipStore> extends Specification {

  @Subject T ships

  def "can insert a new ship"() {
    when:
    ships.insert(new Ship("Enterprise", "Federation", Year.of(2245)))

    then:
    ships.list().size() == old(ships.list().size()) + 1
  }

  def "can find ships by allegiance"() {
    given:
    ships.insert(new Ship("Enterprise", "Federation"))
    ships.insert(new Ship("Gr'oth", "Klingon"))
    ships.insert(new Ship("Constellation", "Federation"))

    when:
    def results = ships.findByAllegiance("Federation")

    then:
    results.size() == 2
    results.every { it.allegiance == "Federation" }
  }
}
