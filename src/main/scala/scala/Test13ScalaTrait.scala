package scala

/**
  * Created by jiangzl on 2016/10/20.
  */

// 特质 1
// 带有具体实现的接口
trait Logger1{
  def log(msg: String): Unit ={
    println("log: " + msg)
  }
}
class Test1 extends Logger1{
  def test: Unit ={
    log("xxx_1")
  }
}


// 特质 2
// 当作接口
trait Logger2{
  def log(msg: String)
}
// 带有具体实现的接口
trait ConsoleLogger2 extends Logger2{
  def log(msg: String): Unit ={
    println("log: " + msg)
  }
}
class Test2 extends ConsoleLogger2{
  def test: Unit ={
    log("xxx_2")
  }
}


// 特质 3
trait ConsoleLogger {
  def log(msg: String): Unit ={
    println("save money: " + msg)
  }
}
trait MessageLogger extends ConsoleLogger{
  override def log(msg: String): Unit ={
    println("save money to bank: " + msg)
  }
}
abstract class Account{
  def save
}
// 带有特质的对象
class MyAccount extends Account with ConsoleLogger{
  def save(): Unit ={
    log("100")
  }
}


object Test13ScalaTrait extends App{

  val t = new Test1
  t.test

  val t2 = new Test2
  t2.test

  // 带有特质的对象（一个类可以通过 with 扩展多个特质，特质是从左到右被构造）
  val m = new MyAccount with MessageLogger
  m.save
}
