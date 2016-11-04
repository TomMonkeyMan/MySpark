package scala

/**
  * Created by jiangzl on 2016/10/21.
  */
object Test21ScalaListSetTuple {
  def main(args: Array[String]) {

    // List 集合的使用
    val l = List(1, 2, 3, 4, 5)
    println(l)

    val newList = l.map((x: Int) => 2 * x)
    println(newList)
    val newList_2 = l.map(2 * _)
    println(newList_2)

    //如果取List中的元素
    val a = List(List(1, 2, 3), List(4, 5, 6))
    println("a=" + a)
    println("a(1)=" + a(1))
    println("a(1)(1)=" + a(1)(1))



    println("_" * 30)
    // set 集合的使用
    val s = Set(5, 16, 30)
    println(s)
    // 判断元素是否包含
    println(s(2))
    println(s(16))



    println("_" * 30)
    // Tuple 元组的使用
    val hostPost = ("localhost", "8080")
    println(hostPost)
    println(hostPost._1)
    println(hostPost._2)
  }
}
