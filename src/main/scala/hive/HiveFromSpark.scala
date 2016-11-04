/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
package hive

import com.google.common.io.{ByteStreams, Files}
import java.io.File
// spark初始化相关
import org.apache.spark.{SparkConf, SparkContext}

// hive初始化相关
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql._


object HiveFromSpark {
  case class Record(key: Int, value: String)

//  // Copy kv1.txt file from classpath to temporary directory
  val kv1Stream = HiveFromSpark.getClass.getResourceAsStream("/kv1.txt")
  val kv1File = File.createTempFile("kv1", "txt")
  kv1File.deleteOnExit()
  ByteStreams.copy(kv1Stream, Files.newOutputStreamSupplier(kv1File))

  def main(args: Array[String]) {

    // 配置sc对象
    val sparkConf = new SparkConf()
      .setAppName("HiveFromSpark")
      .setMaster("local[1]")
      .set("spark.driver.memory", "1g")
      .set("spark.executor.memory", "512m")

    val sc = new SparkContext(sparkConf)

    // 配置hiveconf对象
    // A hive context adds support for finding tables in the MetaStore and writing queries using HiveQL.
    val hiveContext = new HiveContext(sc)



    import hiveContext.sql
    sql("create table if not exists src (key int, value string) ")
    sql(s"load data local inpath '${kv1File.getAbsolutePath}' into table src")

    // Queries are expressed in HiveQL
    println("Result of 'SELECT *': ")
    sql("SELECT * FROM src").collect().foreach(println)


    // Aggregation queries are also supported.
    val count = sql("select count(*) from tmp_words").collect().head.getLong(0)
    println(s"总共: $count 数据")

    import hiveContext.implicits._
    // You can also register RDDs as temporary tables within a HiveContext.
    val rdd = sc.parallelize((1 to 100).map(i => Record(i, s"val_$i")))

    rdd.toDF().registerTempTable("records")

    // Queries can then join RDD data with data stored in Hive.
    println("Result of SELECT *:")
    sql("select * from records r join tmp_words s on r.id = s.id").collect().foreach(println)




    // The results of SQL queries are themselves RDDs and support all normal RDD functions.  The
    // items in the RDD are of type Row, which allows you to access each column by ordinal.
    val rddFromSql = sql("select key, value from tmp_words")
    println("Result of RDD.map:")
    val rddAsStrings = rddFromSql.map {
      case Row(key: Int, value: String) => s"Key: $key, Value: $value"
    }





    sc.stop()
  }
}