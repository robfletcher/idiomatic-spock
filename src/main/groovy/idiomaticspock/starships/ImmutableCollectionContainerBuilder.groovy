package idiomaticspock.starships

import com.google.common.collect.ImmutableCollection
import com.google.common.collect.ImmutableSet
import groovy.transform.CompileStatic
import org.skife.jdbi.v2.ContainerBuilder

@CompileStatic
class ImmutableCollectionContainerBuilder implements ContainerBuilder<ImmutableCollection> {
  private final ImmutableSet.Builder builder = new ImmutableSet.Builder()

  @Override
  ContainerBuilder<ImmutableCollection> add(Object it) {
    builder.add(it)
    return this
  }

  @Override
  ImmutableCollection build() {
    builder.build()
  }
}
