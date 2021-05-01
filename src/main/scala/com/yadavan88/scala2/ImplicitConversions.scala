package com.yadavan88.scala2

case class StarTrekQuote(quote: String)

def showQuote(strTrek: StarTrekQuote) = {
  println("[Star Trek] " + strTrek.quote)
}

implicit def strToQuote(q: String): StarTrekQuote = {
  StarTrekQuote(q)
}

@main def quote: Unit = {
  showQuote("Resistance Is Futile")
}