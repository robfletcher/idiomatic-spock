package idiomaticspock.tck

import org.skife.jdbi.v2.DBI
import org.skife.jdbi.v2.Handle
import spock.lang.AutoCleanup

class PersistentCocktailStoreSpec extends CocktailStoreSpec<PersistentCocktailStore> {

  @AutoCleanup Handle handle

  def setup() {
    def dbi = new DBI("jdbc:h2:mem:test")
    handle = dbi.open()
    cocktails = handle.attach(PersistentCocktailStore)
    cocktails.createTable()
  }

  def cleanup() {
    cocktails.dropTable()
  }
}
