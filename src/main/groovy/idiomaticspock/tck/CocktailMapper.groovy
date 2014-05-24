package idiomaticspock.tck

import groovy.transform.CompileStatic
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet

@CompileStatic
class CocktailMapper implements ResultSetMapper<Cocktail> {
  @Override
  Cocktail map(int index, ResultSet r, StatementContext ctx) {
    new Cocktail(name: r.getString("name"), baseSpirit: r.getString("base_spirit"))
  }
}
