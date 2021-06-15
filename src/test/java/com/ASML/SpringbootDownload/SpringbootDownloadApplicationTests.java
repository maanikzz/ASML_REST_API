//package com.ASML.SpringbootDownload;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//import com.ASML.SpringbootDownload.model.FileInfo;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import java.io.UnsupportedEncodingException;
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//public class SpringbootDownloadApplicationTests {
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    public static final FileInfo fileInfo = FileInfo.builder()
//            .name("image")
//            .url("mng.png")
//            .build();
//
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//
//    }
//
//    ObjectMapper mapper = new ObjectMapper();
//
//
////  @Test
////  public void getgetAllScreenshots() throws Exception {
////		MvcResult result = mockMvc	
////				.perform(get("/ASML-REST-SERVICE/screenshots").content(MediaType.APPLICATION_JSON_VALUE))
////				.andExpect(status().isOk()).andReturn();
////		
////		String resultContent = result.getResponse().getContentAsString();
////		Response response = objectMapper.readValue(resultContent, Response.class);
////		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
////
////	}
//
//    @Test
//    public void saveFileInfo() throws Exception {
//        MvcResult result = mockMvc.perform(get("/ASML-REST-SERVICE/screenshots")
//                .content(MediaType.APPLICATION_JSON_VALUE)
//                .content(mapper.writeValueAsString(fileInfo)))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        FileInfo response = mapper.readValue(result.getResponse().getContentAsString(), FileInfo.class);
//
//
//        assertEquals(fileInfo, response);
//    }
//
//}
//
//
