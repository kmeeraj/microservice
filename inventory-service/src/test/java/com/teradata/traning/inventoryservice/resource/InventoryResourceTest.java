package com.teradata.traning.inventoryservice.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teradata.traning.inventoryservice.service.InventoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class InventoryResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldLoadTheContext() throws Exception{
        InventoryService.InventoryDTO inventoryDTO = InventoryService.InventoryDTO.builder()
                .name("Samsung S10")
                .description("Samsung 6.5 IN")
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String valueAsString = mapper.writeValueAsString(inventoryDTO);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/inventory")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }
}