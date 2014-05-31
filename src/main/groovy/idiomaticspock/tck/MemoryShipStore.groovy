package idiomaticspock.tck

import com.google.common.collect.ImmutableCollection
import com.google.common.collect.ImmutableSet
import com.google.common.collect.Sets
import groovy.transform.CompileStatic

@CompileStatic
class MemoryShipStore implements ShipStore {

  private final Collection<Ship> ships = Sets.newHashSet()

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
}
