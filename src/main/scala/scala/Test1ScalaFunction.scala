package scala

/**
  * Created by jiangzl on 2016/10/11.
  */
object Test1ScalaFunction {

  // function_1: 无返回值
  def funApacheCN_1(name: String):Unit = {
    println("hello: " + name)
  }


  // function_2: 有返回值
  def funApacheCN_2(name: String):String = {
    // return 可省略（默认返回最后一行）
    // "hello: " + name
    return("hello: " + name)
  }


  // function_3: 匿名函数
  def funApacheCN_3 = (x: Int, y: Int) => x + y


  // function_4: 柯里化函数 （不加返回值类型，显得很装逼）
  // 此方法  **不是** 柯里化函数， 而是将函数顺序调用，一共2遍
  def funApacheCN_4_1(x: Int)(y: Int) = x + y
  // 此方法  **是** 柯里化函数， 可以回忆一下闭包。
  def funApacheCN_4_2(x: Int) = (y: Int) => x + y


  // function_5: foreach
  def funApacheCN_5(name: String*) = {
    name.foreach(x => print(x))
  }


  // function_6: 设置name的默认值
  def funApacheCN_6(name: String = "ApacheCN"): String = {
    return "hello: " + name
  }


  def main(args: Array[String]) {
    val name = "ApacheCN"

    funApacheCN_1(name)


    println("fun2: " + funApacheCN_2(name))


    println("fun3:" + funApacheCN_3(2, 3))


    println("fun4_1:" + funApacheCN_4_1(12)(13))
    val tmp_4_2 = funApacheCN_4_2(22)
    println("fun4_2:" + tmp_4_2(23))


    funApacheCN_5(name)
    println()


    println("fun6: " + funApacheCN_6())
  }
}
