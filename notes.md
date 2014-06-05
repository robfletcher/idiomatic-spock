## Things not covered at gr8conf EU 2014

* @ConfineMetaClassChanges to automatically de-fuck the metaclass
* *Measuring by* code coverage is an organizational anti-pattern
  * Not saying code coverage isn't useful
  * Only tells you what *definitely isn't* tested not what is

## Questions

* Can you access the mocking API from a trait?
  * Appears not but a better approach would be to define an abstract factory method in the trait and implement it to return a mock/stub in the spec

## Errors

* `expect` block cannot go before `given` the way I showed it. But it can go before `where` so the technique is valid.
* should assert collections are not empty when using `every`
