package idiomaticspock.functionalstyle

import spock.lang.Specification

class CollectSpec extends Specification {
  def "can filter drinkable gins"() {
    expect:
    Gin.drinkable().collect { it.name() } == ["Bombay", "Hendricks", "Tanqueray"]
  }
}

enum Gin {
  Gordons("nail varnish"),
  Bombay("floral"),
  Hendricks("floral"),
  Tanqueray("dry")

  private final String taste

  Gin(String taste) {
    this.taste = taste
  }

  static Collection<Gin> drinkable() {
    values().findAll { it.taste != "nail varnish" }
  }
}
