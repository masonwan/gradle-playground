package masonwan.gradle

class B {

  static def GetName() {
    return 'static B'
  }

  B() {
  }

  def name = 'B'

  def getName() {
    return name
  }
}
