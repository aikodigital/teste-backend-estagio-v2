package com.aiko.testebackendestagiov2.config;

import java.util.List;

import com.aiko.testebackendestagiov2.models.Equipment;
import com.aiko.testebackendestagiov2.models.EquipmentPositionHistory;
import com.aiko.testebackendestagiov2.repositories.EquipmentPositionHistoryRepository;
import com.aiko.testebackendestagiov2.repositories.EquipmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Equipment> equipments = equipmentRepository.findAll();
        equipments.stream().forEach(
            equipment -> System.out.println("UUID: "+equipment.getId()+"\nName: "+equipment.getName()+"\n")
            );

        List<EquipmentPositionHistory> positionHistories = equipmentPositionHistoryRepository.findAll();
        positionHistories.stream().forEach( 
            history -> System.out.println("UUID: "+history.getEquipment().getId()+"\nDate: "+history.getDate()+"\nLat: "+history.getLat()+"\n")
            );

    }

}
