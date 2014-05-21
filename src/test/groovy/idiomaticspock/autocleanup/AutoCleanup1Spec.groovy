package idiomaticspock.autocleanup

import org.skife.jdbi.v2.DBI
import org.skife.jdbi.v2.Handle
import spock.lang.Specification
import spock.lang.Subject

class AutoCleanup1Spec extends Specification {

  def dbi = new DBI("jdbc:h2:mem:test")
  Handle handle
  @Subject CocktailStore cocktailStore

  def setup() {
    handle = dbi.open()
    cocktailStore = handle.attach(CocktailStore)
    cocktailStore.createTable()
  }

  def cleanup() {
    cocktailStore.dropTable()
    handle.close()
  }

  def "can retrieve a list of cocktails"() {
    given:
    def statement = handle.createStatement("insert into cocktail (name, base_spirit) values (?, ?)")
    [Gin: ["Negroni", "Aviation"], Whiskey: ["Old Fashioned"]].each { baseSpirit, names ->
      names.each { name ->
        statement.bind(0, name).bind(1, baseSpirit).execute()
      }
    }

    when:
    def cocktails = cocktailStore.listCocktails("Gin")

    then:
    with(cocktails.toList()) {
      size() == 2
      baseSpirit.every { it == "Gin" }
      name == ["Negroni", "Aviation"]
    }
  }
}
