//package com.springboot.automation.service.postgre;
//
//import com.automation.entity.postgre.PostgreEntity;
//import com.automation.repository.postgre.PostgreRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PostgreDatabaseService {
//
//    @Autowired
//    PostgreRepository postgreRepository;
//
//    public String getOfferIdWithSubscriptionOfferId(int id){
//        return postgreRepository.findById(id).stream().map(PostgreEntity::getUsername).findFirst().orElse(null);
//    }
//}
