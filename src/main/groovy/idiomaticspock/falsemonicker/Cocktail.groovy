package idiomaticspock.falsemonicker

import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@TupleConstructor
class Cocktail {
  final String description
  final Spirit baseSpirit
  final int invented
}
