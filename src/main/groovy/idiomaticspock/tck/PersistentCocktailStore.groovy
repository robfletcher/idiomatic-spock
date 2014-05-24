package idiomaticspock.tck

import com.google.common.collect.ImmutableCollection
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.BindBean
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.SqlUpdate
import org.skife.jdbi.v2.sqlobject.customizers.Mapper
import org.skife.jdbi.v2.sqlobject.customizers.RegisterContainerMapper

interface PersistentCocktailStore extends CocktailStore {
  @SqlUpdate("""create table cocktail (
                       id int primary key auto_increment,
		                   name varchar(32),
		                   base_spirit varchar(32))""")
  void createTable()

  @SqlUpdate("drop table cocktail")
  void dropTable()

  @SqlUpdate("insert into cocktail (name, base_spirit) values (:name, :baseSpirit)")
  @Override
  void insert(@BindBean Cocktail cocktail)

  @SqlQuery("select name, base_spirit from cocktail")
  @Mapper(CocktailMapper)
  @RegisterContainerMapper(ImmutableCollectionContainerBuilderFactory)
  @Override
  ImmutableCollection<Cocktail> list()

  @SqlQuery("select name, base_spirit from cocktail where base_spirit = :baseSpirit")
  @Mapper(CocktailMapper)
  @RegisterContainerMapper(ImmutableCollectionContainerBuilderFactory)
  @Override
  ImmutableCollection<Cocktail> findByBaseSpirit(@Bind("baseSpirit") String baseSpirit)
}
