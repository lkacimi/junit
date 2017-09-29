/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 *
 * @author lkacimi
 */
public class KafkaProducerImpl {
    public static void produce(){
        Properties kafkaProperties = new Properties();
        kafkaProperties.put("bootstrap.servers", "localhost:9092");
        kafkaProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        
        KafkaProducer<String,String> producer = new KafkaProducer(kafkaProperties);
        ProducerRecord<String,String> record = new ProducerRecord<>("CustomerCountry","Precision Products","France");
        
        try{
            producer.send(record).get();
            producer.send(record,(r,e) -> {System.out.println(r.topic());});
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
