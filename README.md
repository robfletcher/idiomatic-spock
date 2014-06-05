# Idiomatic Spock

This is a presentation given at gr8conf 2014 in Copenhagen.

The slides are available in…

* [PDF](https://github.com/robfletcher/idiomatic-spock/blob/master/Idiomatic%20Spock.pdf)
* [Keynote format](https://github.com/robfletcher/idiomatic-spock/tree/master/Idiomatic%20Spock.key.zip)
* [HTML](http://freeside.co/idiomatic-spock/)

For Keynote and HTML formats you will need [Fira Mono](http://dev.carrois.com/fira-3-1/) and [Horizon BT](http://www.azfonts.net/load_font/horizon_bt.html) fonts installed for the slides to render correctly. The PDF has the fonts embedded so it's the best option if you just want to read through the slides.

## Code

In addition to the slide there is a small set of example specifications to support the talk. If you have JDK 8 installed you should be able to run the tests using `./gradlew`. JDK 8 is needed as I'm using Nashorn and the Java 8 time API.

## Credits

* Breaking down long tests using helper methods, mixins & traits are applications of Uncle Bob Martin's [Clean Code](http://www.goodreads.com/book/show/3735293-clean-code) principles.
* Luke Daley showed me the idea of using `expect` blocks to enforce preconditions.
* An emphasis on diagnostic quality is a point made in [Growing Object Oriented Software Guided by Tests](http://www.growing-object-oriented-software.com) by Steve Freeman and Nat Pryce.
* I think *"never trust a test you haven't seen fail"* was a quote from [Colin Vipurs](https://twitter.com/tddmonkey)' talk on testing anti-patterns at [Devoxx UK 2013](http://www.devoxx.com/display/UK13/I+hate+writing+unit+tests%2C+how+come+everybody+else+enjoys+it).
* The section on separating test data from test logic is based on a blog post by [J. B. Rainsberger](http://jbrains.ca/) that I can't seem to find now.
* *False moniker* is an anti-pattern written about by Max Ashton [here](http://stateyourbizness.blogspot.co.uk/2008/07/good-unit-testing-practice.html).
* David Norton of Object Partners wrote about [testing JavaScript using Spock and Nashorn](http://www.objectpartners.com/2014/05/29/unit-test-your-server-side-javascript-with-spock/).
* Spock is the creation of [Peter Niederwieser](https://twitter.com/pniederw)
