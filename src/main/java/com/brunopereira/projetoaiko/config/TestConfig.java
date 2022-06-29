package com.brunopereira.projetoaiko.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.brunopereira.projetoaiko.entities.Equipment;
import com.brunopereira.projetoaiko.entities.EquipmentModel;
import com.brunopereira.projetoaiko.entities.EquipmentPositionHistory;
import com.brunopereira.projetoaiko.entities.EquipmentStateHistory;
import com.brunopereira.projetoaiko.entities.ValuePerHour;
import com.brunopereira.projetoaiko.entities.enums.EquipmentState;
import com.brunopereira.projetoaiko.repositores.EquipmentModelRepository;
import com.brunopereira.projetoaiko.repositores.EquipmentPositionHistoryRepository;
import com.brunopereira.projetoaiko.repositores.EquipmentRepository;
import com.brunopereira.projetoaiko.repositores.EquipmentStateHistoryRepository;
import com.brunopereira.projetoaiko.repositores.ValuePerHourRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private EquipmentModelRepository equipmentModelRepository;
	
	@Autowired
	private EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;
	
	@Autowired
	private EquipmentStateHistoryRepository equipmentStateHistoryRepository;
	
	@Autowired
	private ValuePerHourRepository valuePerHourRepository;

	@Override
	public void run(String... args) throws Exception {
		
		EquipmentModel m1 = new EquipmentModel(null,  "T250D" );
		EquipmentModel m2 = new EquipmentModel(null, "845E" );
		EquipmentModel m3 = new EquipmentModel(null, "1075C" );
		
		Equipment e1 = new Equipment (null, "Carregadeira", m1 );
		Equipment e2 = new Equipment (null, "Feller Buncher", m2 );
		Equipment e3 = new Equipment (null, "Forwarder", m3 );
		
		equipmentModelRepository.saveAll(Arrays.asList(m1,m2,m3));
		equipmentRepository.saveAll(Arrays.asList(e1,e2,e3));
		
		SimpleDateFormat dateHistory = new SimpleDateFormat("dd/MM/yyyy"); 
		
		EquipmentPositionHistory h1 = new EquipmentPositionHistory(null, -3.468163, -62.221906, Arrays.asList(e1), dateHistory.parse("23/09/2022"));
		EquipmentPositionHistory h2 = new EquipmentPositionHistory(null, -2.360146, -63.055500, Arrays.asList(e2), dateHistory.parse("24/06/2022"));
		EquipmentPositionHistory h3 = new EquipmentPositionHistory(null, -19.934319815979762, -43.936084272764774, Arrays.asList(e3), dateHistory.parse("02/05/2022"));
		
		equipmentPositionHistoryRepository.saveAll(Arrays.asList(h1, h2, h3));
		
		SimpleDateFormat dateStateHistory = new SimpleDateFormat("dd/MM/yyyy");
		
		EquipmentStateHistory eh1 = new EquipmentStateHistory(null, dateStateHistory.parse("02/06/2018"), e1, EquipmentState.MANUTENCAO);
		EquipmentStateHistory eh2 = new EquipmentStateHistory(null, dateStateHistory.parse("03/05/2019"), e2, EquipmentState.PARADO);
		EquipmentStateHistory eh3 = new EquipmentStateHistory(null, dateStateHistory.parse("09/05/2022"), e3, EquipmentState.OPERANDO);
		
		equipmentStateHistoryRepository.saveAll(Arrays.asList(eh1,eh2,eh3));
		
		ValuePerHour vph1 = new ValuePerHour(null, m1, EquipmentState.MANUTENCAO, 120.2);
		ValuePerHour vph2 = new ValuePerHour(null, m3, EquipmentState.OPERANDO, 300.0);
		ValuePerHour vph3 = new ValuePerHour(null, m2, EquipmentState.PARADO, 10.9);
		
		valuePerHourRepository.saveAll(Arrays.asList(vph1,vph2,vph3));
	}

}
