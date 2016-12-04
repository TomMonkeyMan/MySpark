
import java.util.HashMap
import org.apache.kafka.clients.producer.{ProducerConfig, KafkaProducer, ProducerRecord}

// Produces some random words between 1 and 100.
object TestProdeucer {

  def main(args: Array[String]) {
//    if (args.length < 4) {
//      System.err.println("Usage: KafkaWordCountProducer <metadataBrokerList> <topic> " +
//        "<messagesPerSec> <wordsPerMessage>")
//
//      """
//        |sparkmaster:9092 kafkatopictest 5 8
//        |sparkmaster:9092 为  broker-list地址
//        |kafkatopictest，top名称
//        |5表示每秒发多少条消息
//        |8表示每条消息中有几个单词
//      """
//
//      System.exit(1)
//    }

//    val Array(brokers, topic, messagesPerSec, wordsPerMessage) = args

    val brokers = "localhost:9092"
    val topic = "ScalaKafka"
    val messagesPerSec = 5
    val wordsPerMessage = 8

    // Zookeeper connection properties
    val props = new HashMap[String, Object]()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
      "org.apache.kafka.common.serialization.StringSerializer")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
      "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)

    // Send some messages
    while(true) {
       (1 to messagesPerSec.toInt).foreach { messageNum =>
        val str = (1 to wordsPerMessage.toInt).map(x => scala.util.Random.nextInt(10).toString).mkString("\t")

        val message = new ProducerRecord[String, String](topic, null, str)
        producer.send(message)
      }

      Thread.sleep(1000)
    }
  }
}