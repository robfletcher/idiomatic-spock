package idiomaticspock.autocleanup

import groovy.transform.CompileStatic
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.SqlUpdate
import org.skife.jdbi.v2.sqlobject.customizers.Mapper

interface CocktailStore {
	@SqlUpdate("""create table cocktail (
                       id int primary key auto_increment,
		                   name varchar(32),
		                   base_spirit varchar(32))""")
	void createTable()

	@SqlUpdate("drop table cocktail")
	void dropTable()

	@SqlQuery("select name, base_spirit from cocktail where base_spirit = :base_spirit")
	@Mapper(CocktailMapper)
	Iterator<Cocktail> listCocktails(@Bind("base_spirit") String baseSpirit)
}
