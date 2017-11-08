import groovy.json.internal.LazyMap
import masonwan.gradle.A
import masonwan.gradle.B
import spock.lang.IgnoreRest
import spock.lang.Specification

import java.nio.file.Files

class FooSpec extends Specification {

  def "A should be B's name from its method"() {
    setup:
    def name = 'Not B'
    def b = Mock(B)
    b.getName() >> name
    def a = new A(b)

    expect:
    a.getBName() == name
  }

  def "A should get B's name through static method"() {
    when:
    GroovyMock(B, global: true)
    def name = 'fake name'
    B.GetName() >> name

    def b = new B()
    def a = new A(b)

    then:
    a.getStaticBName() == name
  }

  def 'doesExist() should be true'() {
    setup:
    GroovyMock(Files, global: true)
    Files.exists(_) >> true

    def a = new A(null)

    expect:
    a.doesExist()
  }

  def 'doesExist() should be false'() {
    setup:
    GroovyMock(Files, global: true)
    Files.exists(_) >> false

    def a = new A(null)

    expect:
    !a.doesExist()
  }

  @IgnoreRest
  def 'foo'() {
    when:
    def map = new LazyMap()
    map.put('1', 1)
    map.put('2', 2)

    then:
    '4' in map
  }
}
