package com.yadavan88.scala2

implicit class StringUtils(val str: String) {
  def abbreviate = str.split("\\s").map(_.head.toUpper).mkString //doesnt care about exceptions for now
}

@main def implicits: Unit =
  println("Jean Luc Picard".abbreviate) // JLP
