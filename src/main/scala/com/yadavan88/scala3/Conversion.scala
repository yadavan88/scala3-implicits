package com.yadavan88.scala3

case class StarTrekQuote(quote: String)

object StringConverter:
    given Conversion[String, StarTrekQuote] with {
        def apply(str:String) = StarTrekQuote(str)
    }

import StringConverter._
def showQuote(strTrek: StarTrekQuote) = {
  println("[Star Trek] " + strTrek.quote)
}

@main def quote: Unit = {
  import StringConverter.given
  showQuote("Resistance Is Futile")
}
