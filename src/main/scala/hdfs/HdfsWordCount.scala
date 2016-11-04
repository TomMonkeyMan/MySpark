package hdfs

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkContext, SparkConf}

object HdfsWordCount {

  def main(args: Array[String]) {

    val sparkConf = new SparkConf().setAppName("HdfsWordCount")
      .setMaster("local")

    val sc = new SparkContext(sparkConf)

    val lines = sc.textFile("file:/Users/jiangzl/Desktop/testSet.txt")
//    val lines = sc.textFile("hdfs://localhost:9000/user/datasys/input/*")

    val words = lines.flatMap(_.split(""))
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._2, true).cache()
    println("-----开始-----")
    // 终端输出
    wordCounts.foreach(wordCounts => println(wordCounts._1 + " : " + wordCounts._2))
    // 文件输出
    wordCounts.repartition(1).saveAsTextFile("file:/Users/jiangzl/Desktop/result.txt")
    // hdfs写入
//    wordCounts.repartition(1).saveAsTextFile("hdfs://localhost:9000/user/datasys/result.txt")

    val hiveContext = new HiveContext(sc)
    import hiveContext.implicits._
    wordCounts.toDF.repartition(1).write.mode("overwtite").text("file:/Users/jiangzl/Desktop/result.txt")

    sc.stop()
  }
}