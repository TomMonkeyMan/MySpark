package scala

/**
  * Created by jiangzl on 2016/10/21.
  */

object Test23ScalaCollectionOperations {

  def main(args: Array[String]) {

    val l = List(1, 2, 3, 4)


    // foreach 使用（类似于map，但是没返回值）
    l.foreach(print(_))
    println()
    val for1 = l.foreach(x => print(3 * x + "\t"))
    println(s"for1=$for1")

    // map 迭代
    println("\n" + "_" * 30)
    l.map(3 * _)
    println()
    l.map(print(_))
    println()
    val m1 = l.map(x => print(3 * x + "\t"))
    // 因为是打印输出，所以元素为空
    println(s"m1=$m1")

    // flatten (扁平化：多个List 压缩到一个List中 )
    println("\n" + "_" * 30)
    val fn1 = List(List(1, 2, 3), List(4, 5))
    val fn2 = List(List(1, 2, 3), List(4, 5)).flatten
    println(s"fn1=$fn1, fn2=$fn2")

    // flatMap(map + flatten)
    // flatMap: map是对大List的元素进行操作
    // _.map: 是对大list里面的小List的元素进行操作
    // flatMap: flatten对最终大List的元素进行平扁化操作
    println("\n" + "_" * 30)
    val fm = List(List(1, 2, 3), List(4, 5))
    val fm1 = fm.flatMap( _.map(3 * _))
    val fm2 = fm.flatMap(x => x.map(3 * _))
    println(s"fm1=$fm1, fm2=$fm2")




    // filter 过滤
    println("\n" + "_" * 30)
    val ft1 = l.filter(_ % 2 ==0)
    val ft2 = l.filter(x => x % 2 ==0)
    println(s"ft1=$ft1, ft2=$ft2")



    // zip (聚合 =>  生成一个装有元组的列表 ) 方法的使用
    println("\n" + "_" * 30)
    val a = List(1, 2, 3, 4)
    val b = List(11, 12, 13, 14)
    val z1 = a.zip(b)
    val z2 = a zip b
    println(s"z1=$z1, z2=$z2")



    // partition 列表分割
    println("\n" + "_" * 30)
    val p1 = l.partition(_ % 2 == 0)
    println(s"p1=$p1")



    // reduceLeft／reduceRight 和 foldLeft／foleRight 的使用 与 区别  
    println("\n" + "_" * 30)
    val lis = List(1,7,2,9)
    // 实际是： ((1 - 7) - 2) - 9 = 1 - 7 - 2 - 9 = -17
    val fc1 = lis.reduceLeft(_-_)
    // 实际是： 1 - (7 - (2 - 9)) = 1 - (7 + 7) = -13
    val fc2 = lis.reduceRight(_-_)
    // foldLeft(初始值)(函数)
    // 实际是： 0 - 1 - 7 - 2 - 9 = -19
    val fc3 = lis.foldLeft(0)(_-_)
    // 实际是： 1 - (7 - (2 - (9 - 0))) = 1 - 7+2 - 9 = -13
    val fc4 = lis.foldRight(0)(_-_)
    println(s"fc1=$fc1, fc2=$fc2, fc3=$fc3, fc4=$fc4")



    // sortWith
    println("\n" + "_" * 30)
    val tmp_l = List(1, -3, 4, 2, 6)
    println("小到大排序： "+ tmp_l.sortWith(_ < _))
    println("大到小排序： " + tmp_l.sortWith(_ > _))
  }
}
