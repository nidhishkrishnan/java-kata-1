package org.echocat.kata.java.part1.controller;

import org.echocat.kata.java.part1.domain.Magazine;
import org.echocat.kata.java.part1.service.MagazineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.time.format.DateTimeFormatter.ofPattern;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@DisplayName("Testing Magazine Controller")
public class MagazineControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MagazineService magazineService;

    @InjectMocks
    private MagazineController magazineController;


    @BeforeEach
    void setMockOutput()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(magazineController).build();
    }

    @Test
    @DisplayName("Test for getting Magazine details ('v1/magazines/')")
    public void getMagazineTest() throws Exception
    {
        when(magazineService.getMagazines()).thenReturn(buildMagazines());
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/magazines/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].publishedAt", is(LocalDate.now().format(ofPattern("dd.MM.yyyy")))));
    }

    private List<Magazine> buildMagazines() {
        Magazine magazine = new Magazine();
        magazine.setAuthors(Collections.singletonList("someAuthor@email.com"));
        magazine.setPublishedAt(new Date());;
        magazine.setIsbn("someIsbn");
        magazine.setTitle("someTitle");
        return Collections.singletonList(magazine);
    }

}
