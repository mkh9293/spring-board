package example

import spock.lang.Specification

/**
 * 호출순서
 */
abstract class BasicSpec extends Specification {
    def x = { println 'base field initializer' }()

    def setupSpec() { println 'base setupSpec()' }

    def cleanupSpec() { println 'base cleanupSpec()' }

    def setup() { println 'base setup()' }

    def cleanup() { println 'base cleanup()' }

    def baseSpecMethod() {
        setup:
        println 'base specc method'
    }
}

class DerivedSpec extends BasicSpec {
    def y = { println 'derived field initializer' }()

    def setupSpec() { println 'derived setupSpec()' }

    def cleanupSpec() { println 'derived cleanupSpec()' }

    def setup() { println 'derived setup()' }

    def cleanup() { println 'derived cleanup()' }

    def derivedSpecMethod() {
        setup:
        println 'derived spec method'
    }
}
