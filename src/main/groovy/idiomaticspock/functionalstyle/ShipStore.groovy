package idiomaticspock.functionalstyle

import groovy.transform.CompileStatic

@CompileStatic
class ShipStore {
  @Delegate
  private final Collection<Ship> ships = []

  Collection<Ship> findByAllegiance(String allegiance) {
    ships.findAll { it.allegiance == allegiance }
  }
}
