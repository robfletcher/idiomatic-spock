package idiomaticspock.helpermethods

import idiomaticspock.starships.MemoryShipStore
import idiomaticspock.starships.Ship
import idiomaticspock.starships.ShipStore
import spock.lang.Specification
import spock.lang.Subject

import java.time.Year

class TraitCompositionSpec extends Specification implements ShipHelpers {

  @Subject ships = new MemoryShipStore()

  def "can read back ships after inserting them"() {
    given:
    withShip ships, "Enterprise", "Federation"
    withShip ships, "Haakona", "Romulan"

    expect:
    countByAllegiance(ships, "Federation") == 1
    countByAllegiance(ships, "Romulan") == 1
  }

}

trait ShipHelpers {

  void withShip(ShipStore ships, String name, String allegiance) {
    ships.insert new Ship(name, allegiance)
  }

  void withShip(ShipStore ships, String name, String allegiance, Year enteredService) {
    ships.insert new Ship(name, allegiance, enteredService)
  }

  int countByAllegiance(ShipStore ships, String allegiance) {
    ships.findByAllegiance(allegiance).size()
  }

}
