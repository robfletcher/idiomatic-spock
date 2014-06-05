package idiomaticspock.helpermethods

import idiomaticspock.starships.MemoryShipStore
import idiomaticspock.starships.Ship
import idiomaticspock.starships.ShipStore
import spock.lang.Specification
import spock.lang.Subject

import java.time.Year

class TraitCompositionSpec extends Specification implements ShipHelpers {

  @Subject ShipStore ships = new MemoryShipStore()

  def "can read back ships after inserting them"() {
    given:
    withShip "Enterprise", "Federation"
    withShip "Haakona", "Romulan"

    expect:
    countByAllegiance("Federation") == 1
    countByAllegiance("Romulan") == 1
  }

}

trait ShipHelpers {

  abstract ShipStore getShips()

  void withShip(String name, String allegiance) {
    ships.insert new Ship(name, allegiance)
  }

  void withShip(String name, String allegiance, Year enteredService) {
    ships.insert new Ship(name, allegiance, enteredService)
  }

  int countByAllegiance(String allegiance) {
    ships.findByAllegiance(allegiance).size()
  }

}
