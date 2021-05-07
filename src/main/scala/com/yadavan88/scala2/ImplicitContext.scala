package com.yadavan88.scala2

class DBContext

object SimpleImplicitPassing {

  def insertUser(name: String)(implicit ctx: DBContext): Boolean = {
    //use ctx here for db operations
    println(s"User '$name' inserted")
    true
  }

  def validateUser(name: String)(implicit ctx: DBContext): Boolean = {
    //use ctx here for db operations
    println(s"User '$name' validated")
    true
  }

  def addUser(name: String)(implicit ctx: DBContext) = {
    //not using ctx anywhere, but need to just keep passing it for underlying methods
    if (validateUser(name)) insertUser(name) else false
  }

  def usage = {
    implicit val ctx = new DBContext
    addUser("yadukrishnan")
  }

}

object ImplicitFunctions {

  def insertUser1(name: String)(implicit ctx: DBContext) = {
    //use ctx here for db operations
    println(s"User '$name' inserted")
    true
  }

  def validateUser1(name: String)(implicit ctx: DBContext): Boolean = {
    //use ctx here for db operations
    println(s"User '$name' validated")
    true
  }

  type WithDBContext = DBContext => Boolean

  def addUser1(name: String):  WithDBContext = { implicit ctx: DBContext =>  /* information of implicit is lost in the definition of function*/
    //not using ctx anywhere, but need to just keep passing it for underlying methods
    if (validateUser1(name)) insertUser1(name) else false
  }

  def usage = {
    val ctx = new DBContext
    val status:Boolean = addUser1("yadu")(ctx)
  }

}
