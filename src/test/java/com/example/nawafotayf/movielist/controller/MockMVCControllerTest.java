package com.example.nawafotayf.movielist.controller;

import com.example.nawafotayf.movielist.entity.Users;
import com.example.nawafotayf.movielist.service.implementations.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MockMVCControllerTest {
    private MockMvc mockMvc;



    @Test
    public void testListAllUsers() throws Exception {
        MvcResult result = mockMvc.perform(get("/movielist-admin/users/allusers"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON)).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("admin"));
    }
    @Test
    public void testListAllseries() throws Exception {
        MvcResult result = mockMvc.perform(get("/movielist/series/allseries"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON)).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("nine"));
    }
    @Test
    public void testListAllrating() throws Exception {
        MvcResult result = mockMvc.perform(get("/movielist/rating/allratin"))
                .andExpect(status ().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON)).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("good"));
    }
    @Test
    public void testListAllmovies() throws Exception {
        MvcResult result = mockMvc.perform(get("/movielist/movie/allmovies"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON)).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("got"));
    }

}

