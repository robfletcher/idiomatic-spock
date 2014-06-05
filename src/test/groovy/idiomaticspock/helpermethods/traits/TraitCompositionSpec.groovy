package idiomaticspock.helpermethods.traits

import idiomaticspock.starships.MemoryShipStore
import idiomaticspock.starships.ShipStore
import spock.lang.Specification
import spock.lang.Subject

class TraitCompositionSpec extends Specification implements ShipStoreHelpers {

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
