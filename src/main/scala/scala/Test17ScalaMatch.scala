package scala

/**
  * Created by jiangzl on 2016/10/21.
  */

object Test17ScalaMatch {
  def main(args: Array[String]) {
    val value = 3
    // 标准用法(match)
    val result = value match {
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
    }
    println("result of match is : " + result)


    // 使用守卫
    val result2 = value match {
      case i if i ==1 => "one_1"
      case i if i ==2 => "two_2"
      case i if i ==3 => "other_2"
    }
    println("result of match is : " + result2)


    // 匹配类型
    def t(obj: Any) = obj match {
      case x: Int => println("Int")
      case s: String => println("String")
      case _ => println("unknown type")
    }
    t(1)
    t("a")
    t(1L)
  }
}
