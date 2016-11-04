package scala

/**
  * Created by jiangzl on 2016/10/21.
  */

/*
* 如何 为类添加默认的自定义方法 ???
* 背景： 我们调用别人的框架，发现少了一些方法，需要添加，但是让别人为你一个人添加是不可能滴
* 所以：通过隐式转换，添加自定义方法
* 1. 例如 对A这个类添加一个rich方法
* 2. 我们新建一个 RichA这个类，传入变量 A这个类
* 3. 在RichA这个类中添加一个rich方法
* 4. 隐式转换：自定义 a2RichA 方法，new RichA这个类，传入参数 A 这个类
* 5. new A 这个类，发现新的对象a, 有rich 方法叻
* */

class A{}
class RichA(a: A){
  def rich{
    println("rich ... ")
  }
}

object Test25ScalaImplicit {

  def testParam(implicit name: String) {
    println(name)
  }

  // 自定义的隐式类
  implicit class Calculator(x: Int){
    def add_10(a: Int): Int = (x + a) * 10
  }

  def main(args: Array[String]) {
    // 1.隐式转换
    implicit def a2RichA(a: A) = new RichA(a)
    // 新建变量
    val a = new A
    a.rich



    // 2.隐式参数
    // 设置隐式变量的值
    implicit val name = "implicit!!!"
    // 设置隐式变量的值
    testParam
//    // 如果不传入参数：报错
//    testParam()
    // 自定义参数
    testParam("xxx")



    // 3.隐式类：
    // 为Int类型，添加一个自定义的 add方法
    // 调用隐式类
    println(4.add_10(10))
  }
}
