package idiomaticspock.tck

import com.google.common.collect.ImmutableCollection
import groovy.transform.CompileStatic
import org.skife.jdbi.v2.ContainerBuilder
import org.skife.jdbi.v2.tweak.ContainerFactory

@CompileStatic
class ImmutableCollectionContainerBuilderFactory implements ContainerFactory<ImmutableCollection> {
  @Override
  boolean accepts(Class<?> type) {
    true
  }

  @Override
  ContainerBuilder<ImmutableCollection> newContainerBuilderFor(Class<?> type) {
    new ImmutableCollectionContainerBuilder()
  }
}
