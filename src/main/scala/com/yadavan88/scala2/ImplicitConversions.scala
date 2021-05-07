package com.yadavan88.scala2

case class StarTrekQuote(quote: String)

object StringImplicits {
  implicit def strToQuote(q: String): StarTrekQuote = {
    StarTrekQuote(q)
  }
}

import StringImplicits._
def showQuote(strTrek: StarTrekQuote) = {
  println("[Star Trek] " + strTrek.quote)
}

@main def quote: Unit = {
  showQuote("Resistance Is Futile")
}
