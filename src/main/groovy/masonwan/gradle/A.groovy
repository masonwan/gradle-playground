package masonwan.gradle

import java.nio.file.Files
import java.nio.file.Paths

class A {
  B b

  A(B b) {
    this.b = b
  }

  def getBName() {
    return b.name
  }

  def getStaticBName() {
    return B.GetName()
  }

  def doesExist() {
    def path = Paths.get('/Users/mwan/Downloads/WebStorm-2017.2.2.dmg')
    def doesExist = Files.exists(null)
    return doesExist
  }
}
