package com.yadavan88.scala3

given String = "USS Enterprise-D"

def captainsLog(log: String) = {
  val shipName = summon[String]
  val msg = s"[$shipName]: $log"
  println(msg)
}

@main def log: Unit = {
  captainsLog("We have now departed Vulcan")
}
