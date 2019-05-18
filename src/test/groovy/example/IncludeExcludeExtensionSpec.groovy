package example

import spock.lang.Specification

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * 외부 인터페이스 적용
 */
class IncludeExcludeExtensionSpec extends Specification {
    @Fast
    def "a fast method"() {
        expect: true
    }

    @Slow
    def "a slow method"() {
        expect: true
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Fast{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Slow{}


