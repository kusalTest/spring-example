package com.example.demo.controllers;

import com.example.demo.DemoApplication;
import com.example.demo.Entity.Users;
import com.example.demo.services.UserService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by dushman on 7/27/17.
 */

//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//@SpringBootTest
//@Import(MyTestsConfiguration.class)

/*@RunWith(SpringRunner.class)
@RestClientTest(RemoteVehicleDetailsService.class)*/


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {

  /*  @Autowired
    private MockRestServiceServer server;*/


    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;



    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }



    @Test
    public void setUserService() throws Exception {

    }


    @Test
    public void getUser() throws Exception {

       /* String jsonString = "{\"id\":3,"
                + "\"password\":\"1234567890\","
                + "\"email\":\"test\","
                + "\"reg_date\":2017-07-20 15:12:52.0,"
                + "\"type\":\"1\":[]}";
*/

       String postBodyContent = "test";
        mockMvc.perform(MockMvcRequestBuilders.post("/getuser")
                .contentType(MediaType.TEXT_PLAIN)
                .content(postBodyContent)
                .accept(MediaType.APPLICATION_JSON))  //MediaType yanau response eke return type ekaya
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.password").exists())
                .andExpect(jsonPath("$.regDate").exists())
                .andExpect(jsonPath("$.type").exists())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.email").value("test"))
                .andExpect(jsonPath("$.password").value("1234567890"))
                .andExpect(jsonPath("$.regDate").value("1500543772000"))
                .andExpect(jsonPath("$.type").value("1"))
                .andDo(print());
    }


    @Test
    public void addUser() throws Exception {


        String jsonString2 =   "{ \"id\":0, \"password\":\"1234567890\", \"email\":\"test0\", \"reg_date\":\"2017-07-20 15:12:52.0\",\"type\":\"1\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString2)
                .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
                //.andExpect(status().isCreated());
    }



    @Test
    public void getRegisteredMembers() throws Exception {

      //  UserController userController = new UserController();

        String type =   "1";
        mockMvc.perform(MockMvcRequestBuilders.post("/getRegisteredMembers")
                .contentType(MediaType.TEXT_PLAIN)
                .content(type)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());
        
    }



}