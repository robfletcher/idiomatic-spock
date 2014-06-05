package idiomaticspock.starships

import com.google.common.collect.ImmutableCollection
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableSet
import groovy.transform.CompileStatic

@CompileStatic
class MemoryShipStore implements ShipStore {

  @Delegate
  private final List<Ship> ships = []

  @Override
  void insert(Ship ship) {
    ships << ship
  }

  @Override
  ImmutableCollection<Ship> list() {
    ImmutableSet.copyOf(ships)
  }

  @Override
  ImmutableCollection<Ship> findByAllegiance(String allegiance) {
    ImmutableSet.copyOf ships.findAll { it.allegiance == allegiance }
  }

  @Override
  ImmutableCollection<Ship> findByAllegianceNewestFirst(Object allegiance) {
    /*
     * NOTE: this implementation is deliberately faulty
     */
    ImmutableList.copyOf ships.sort { it.enteredService }
  }
}
