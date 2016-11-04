//package kafka
//
///**
//  * Created by jiangzl on 2016/10/29.
//  */
//
//package kafka
//
//import java.util.Properties
//
//import org.apache.kafka.clients.consumer.{ConsumerRecords, KafkaConsumer}
//import org.apache.kafka.clients.producer.ProducerConfig
//
//import scala.io.Source
//import scala.reflect.io.Path
//
//
///**
//  * Kafka Producer
//  */
//class KafkaProduceMsg(brokerList : String, topic : String) extends Runnable{
//
//  private val BROKER_LIST = brokerList //"master:9092,worker1:9092,worker2:9092"
//  private val TARGET_TOPIC = topic //"new"
//  private val DIR = "/root/Documents/"
//
//  /**
//    * 1、配置属性
//    * metadata.broker.list : kafka集群的broker，只需指定2个即可
//    * serializer.class : 如何序列化发送消息
//    * request.required.acks : 1代表需要broker接收到消息后acknowledgment,默认是0
//    * producer.type : 默认就是同步sync
//    */
////  private val props = new Properties()
////  props.put("metadata.broker.list", this.BROKER_LIST)
////  props.put("serializer.class", "kafka.serializer.StringEncoder")
////  props.put("request.required.acks", "1")
////  props.put("producer.type", "async")
//
//  var props = new Properties()
//  props.put("bootstrap.servers", this.BROKER_LIST)
//  props.put("group.id", "test")
//  props.put("enable.auto.commit", "true");  //自动commit
//  props.put("auto.commit.interval.ms", "1000"); //定时commit的周期
//  props.put("session.timeout.ms", "30000"); //consumer活性超时时间
//  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
//  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
//  val consumer = new KafkaConsumer(props)
//  consumer.subscribe(List("foo", "bar")) //  Arrays.asList("foo", "bar")); //subscribe，foo，bar，两个topic
//  while (true) {
//    val records = consumer.poll(100);  //poll 100 条 records
//    for (record <- records)
//      printf("offset = %s, key = %s, value = %s", record.offset(), record.key(), record.value())
//  }
//
//
//
//
//
//
//  /**
//    * 2、创建Producer
//    */
//  private val config = new ProducerConfig(this.props)
//  private val producer = new Producer[String, String](this.config)
//
//  /**
//    * 3、产生并发送消息
//    * 搜索目录dir下的所有包含“transaction”的文件并将每行的记录以消息的形式发送到kafka
//    *
//    */
//  def run() : Unit = {
//    while(true){
//      val files = Path(this.DIR).walkFilter(p => p.isFile && p.name.contains("transaction"))
//
//      try{
//        for(file <- files){
//          val reader = Source.fromFile(file.toString(), "UTF-8")
//
//          for(line <- reader.getLines()){
//            val message = new KeyedMessage[String, String](this.TARGET_TOPIC, line)
//            producer.send(message)
//          }
//
//          //produce完成后，将文件copy到另一个目录，之后delete
//          val fileName = file.toFile.name
//          file.toFile.copyTo(Path("/root/Documents/completed/" +fileName + ".completed"))
//          file.delete()
//        }
//      }catch{
//        case e : Exception => println(e)
//      }
//
//      try{
//        //sleep for 3 seconds after send a micro batch of message
//        Thread.sleep(3000)
//      }catch{
//        case e : Exception => println(e)
//      }
//    }
//  }
//
//}
//
//class Producer {
//  def main(args : Array[String]): Unit ={
//    if(args.length < 2){
//      println("Usage : ProduceMsg master:9092,worker1:9092 new")
//
//      System.exit(1)
//    }
//
//    new Thread(new KafkaProduceMsg(args(0),args(1))).start()
//  }
//}
