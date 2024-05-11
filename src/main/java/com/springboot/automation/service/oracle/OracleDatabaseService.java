//package com.springboot.automation.service.oracle;
//
//import com.automation.entity.oracle.OracleEntity;
//import com.automation.repository.oracle.OracleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OracleDatabaseService {
//
//    @Autowired
//    OracleRepository oracleRepository;
//
//    public Long getIdWithUsername(String username){
//        return oracleRepository.findByUsername(username).stream().map(OracleEntity::getId).findFirst().orElse(null);
//    }
//
//
//}
