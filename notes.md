## Testing

* There's a big difference between writing tests and writing them well
* *Measuring by* code coverage is an organizational anti-pattern
  * Not saying code coverage isn't useful
  * Only tells you what *definitely isn't* tested not what is
* Tests are executable documentation
  * Can't go stale like a document
  * This means naming things is *really* important
* Red->**amber**->green->refactor
  * Spock is helpful here as the power assert gives you good diagnostics by default
  * but you can fuck it up. Show example with bad output & then improve
* **Never** trust a test you haven't seen fail
  * Even if you're writing tests afterwards, break your code to make sure the test works

## Test design

* Tests as documentation
  * Spock has some useful annotations:
    * @Subject
      * Counter-argument – if it's hard to tell then your test is too complex!
    * @Issue
    * @See
  * Use of `description` in `where` block to make unrolls more legible
* One **logical** assertion


## Anti-patterns

* Organizing tests around units of code rather than behavior
  * Test-per-method
    * doesn't cover edge cases
  * Test-per-class anti-pattern
    * Fine as a starting point (@jbrains)
    * As soon as you start writing setup code that only some features need split that shit out
    * Name tests for the behavior they deal with
    * Lots of small specs is good!
* Tautological tests
  * `a==a`
  * Reproducing logic in expectation so it's equally likely to be wrong but almost certainly will pass
* False monicker testing
  * Credit Max
* Interrogating internal state
  * Treat code-under-test as a black box
  * This includes inappropriate use of mocks
* Fail-fast assertions, e.g. assertions in loops
  * Use a `where` block rather than a loop
* @Stepwise
  * fail-fast
  * can be useful for end-to-end scenarios where there's significant time spent getting to later stages of a workflow
  * **always** a trade-off

## Good Spock style

* Groovy functional style assertions
  * e.g. Use `any`, `every`, `collect`
* `with` for grouping assertions on a single object
* Avoid `when` block bloat
  * Things that should be in `given` appearing in `when`
  * Good example is page flow in end-to-end tests
  * The `when` block should be small and focused if not are you really only testing one behavior?
* `when`/`then` vs. `given`/`expect`
  * Former is for an action with an outcome
  * Latter is for conditions that should hold in certain circumstances
  * Difference is subtle and debatable – think about it, though
  * Need a couple of good examples here
  * Mock verification, `thrown` assertions and
* When & how to use @Unroll
  * You *can* define the pattern in the test name but it doesn't mean you should
  * Show an example where this makes the test hard to understand
  * You *can* put @Unroll at the class level
    * but each non paramaterized test gets a `[0]` appended in the report
* Indentation debate
  * If you need indentation to make your test legible you need to refactor
* Testing pre-conditions with `expect`
  * Credit Luke
* Stubs, Mocks and Spies
  * when to use each. Link to [The Little Mocker](http://blog.8thlight.com/uncle-bob/2014/05/14/TheLittleMocker.html)
  * set up stubs using a Closure
  * can do that for mocks but doesn't feel appropriate
  * Can group verifications using `with(Closure)`

## Cool features

* IDE autocompletion in @Unroll
* Separate inputs & outputs with double pipes
  * IntelliJ can auto-format data tables
* Typed where block parameters
  * IntelliJ infers types really well anyway but useful if data source is a method or untyped structure
* `old`
* @AutoCleanup
  * defaults to `close()`
* Hamcrest matcher support
  * `that something, eq("foo")

## Thinking outside the box

* TCK style specifications
  * using abstract superclasses
    * `NettyAdapterSpec` from Betamax
* Data driven `where` blocks
  * Reading from file / database
  * Database metadata
* Using `when` blocks without iteration
  * Good for isolating dummy data from meaning of test
  * Abstraction of test logic from data used to drive it
  * Allows you to write the test as a general case
  * @jbrains wrote about this
* Appropriate use of @IgnoreIf
  * Class or method level
  * Specific Java versions
  * Internet availability
  * Database type
* @Use annotation for including category classes
  * Categories deprecated now in Groovy 2.3 in favor of traits
* @ConfineMetaClassChanges to automatically de-fuck the metaclass

## Stupid Spock tricks

* `import java.lang.Void as Should`

## Gotchas

* Don't commit @IgnoreRest
