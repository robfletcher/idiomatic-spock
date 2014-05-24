package idiomaticspock.tck

class MemoryCocktailStoreSpec extends CocktailStoreSpec<MemoryCocktailStore> {
  def setup() {
    cocktails = new MemoryCocktailStore()
  }
}
