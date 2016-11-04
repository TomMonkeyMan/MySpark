package scala

/**
  * Created by jiangzl on 2016/10/21.
  */

/*
case class 多用在模式匹配中
  case class 默认类型是： val
  构造器中的每一个类型都是val, 不建议用var.
  不用new就可以直接产生对象（为什么？ apply方法）
 */
case class Book(name: String, author: String)

object Test18ScalaCaseClass {
  def main(args: Array[String]) {
    val macTalk = Book("MacTalk", "CJQ")
    macTalk match {
      case Book(name, author) => println("this is a book")
      case _ => println("unknown")
    }

  }
}
