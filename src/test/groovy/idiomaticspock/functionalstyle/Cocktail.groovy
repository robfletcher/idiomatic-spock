package idiomaticspock.functionalstyle

import groovy.transform.CompileStatic
import groovy.transform.Immutable

@Immutable
@CompileStatic
class Cocktail {
  String name
  String baseSpirit

  @Override
  String toString() {
    name
  }
}
