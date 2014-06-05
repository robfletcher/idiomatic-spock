package idiomaticspock.helpermethods.traits

import groovy.transform.CompileStatic
import idiomaticspock.starships.Ship
import idiomaticspock.starships.ShipStore

import java.time.Year

@CompileStatic
trait ShipStoreHelpers {
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
