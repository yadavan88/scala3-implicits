package com.yadavan88.scala2

implicit val starShip:String = "USS Enterprise"

def captainsLog(log:String) = {
  val shipName = implicitly[String]
  val msg = s"[$shipName]: $log"
  println(msg)
}

@main def log: Unit = {
  captainsLog("We have departed Vulcan")
}