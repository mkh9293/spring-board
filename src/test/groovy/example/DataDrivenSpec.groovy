package example

import spock.lang.Specification

/**
 * spock-example
 *
 */
class DataDrivenSpec extends Specification {

    // 최대값 구하기
    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [3,5,9]
        b << [7,4,9]
        c << [7,5,9]
    }

    // 최소값
    def "minimum of #a and #b is #c"() {
        expect:
        Math.min(a, b) == c

        where:
        a | b || c
        3 | 7 || 3
        5 | 4 || 4
        9 | 9 || 9
    }

    def "#person.name is a #sex.toLowerCase() person"() {
        expect:
        person.getSex() == sex

        where:
        person || sex
        new Person(name: "Fred") || "Male"
        new Person(name: "Wilma") || "Female"
    }

    static class Person {
        String name
        String getSex() {
            name == "Fred" ? "Male" : "Female"
        }
    }

}


