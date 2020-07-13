package com.strzalkom;

import com.strzalkom.controllers.StateController;

import com.strzalkom.services.CarService;
import com.strzalkom.services.StateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class WebContextTest {

    @Mock
    CarService carService;

    @Mock
    StateService stateService;



    @InjectMocks
    StateController stateController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(stateController).build();
    }

    @Test
    public void testCheckQuest() throws Exception {

        mockMvc.perform(get("/checkStates"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/cars"));
    }

    @Test
    public void contextLoads() {
    }


}
