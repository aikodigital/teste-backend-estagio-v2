package com.aikoequipment.equipment.testGET;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EquipmentTestGetIT {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void findAllShouldReturnAllEquipments() throws Exception {

		ResultActions result1 = mockMvc.perform(get("/models").contentType(MediaType.APPLICATION_JSON));
		ResultActions result2 = mockMvc.perform(get("/earnings").contentType(MediaType.APPLICATION_JSON));
		ResultActions result3 = mockMvc.perform(get("/positions").contentType(MediaType.APPLICATION_JSON));
		ResultActions result4 = mockMvc.perform(get("/equipments").contentType(MediaType.APPLICATION_JSON));
		ResultActions result5 = mockMvc.perform(get("/stateHistories").contentType(MediaType.APPLICATION_JSON));
		ResultActions result6 = mockMvc.perform(get("/states").contentType(MediaType.APPLICATION_JSON));

		result1.andExpect(status().isOk());
		result2.andExpect(status().isOk());
		result3.andExpect(status().isOk());
		result4.andExpect(status().isOk());
		result5.andExpect(status().isOk());
		result6.andExpect(status().isOk());

	}

}