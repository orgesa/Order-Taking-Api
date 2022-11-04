package com.melita.service;

import com.melita.model.Order;
import com.melita.model.PackageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class OrderService {

    private KafkaTemplate<String, String> kafkaTemplate;
    private final static String kafkaTopic = "melita-order-api";


    @Autowired
    public OrderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ResponseEntity<?> order(Order request) {

         ObjectMapper mapper = new ObjectMapper();
         try{

            if(PackageType.getTypePakage(request.getProduct().getName(),request.getProduct().getPackageType())){
               kafkaTemplate.send(kafkaTopic, mapper.writeValueAsString(request));

                return  new ResponseEntity<>(request, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity<>("ORDER NOT CORRECT", HttpStatus.OK);
    }
}
