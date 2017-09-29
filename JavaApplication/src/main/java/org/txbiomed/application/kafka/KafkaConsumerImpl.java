/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.kafka;

import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 *
 * @author lkacimi
 */
public class KafkaConsumerImpl {
    public static void consume(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "CountryCounter");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        
        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(props);
        
        consumer.subscribe(Collections.singletonList("CustomerCountry"));
       
        try{
            while(true){
            
            ConsumerRecords<String,String> records = consumer.poll(100);
            for(ConsumerRecord r: records){
                System.out.println("offset: "+ r.offset() +",value: " + r.value());
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            consumer.close();
        }
        
    } 
}
