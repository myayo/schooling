package com.schooling.app.features.school.infra.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.schooling.app.features.school.application.usecase.FindAllSchoolsUseCase;
import com.schooling.app.features.school.domain.model.School;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SchoolController.class)
class SchoolControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private FindAllSchoolsUseCase findAllSchoolsUseCase;

  @Test
  void should_find_all_schools_using_findAllSchoolsUseCase() throws Exception {
    School school1 = new School("id1", "school1");
    School school2 = new School("id2", "school2");
    when(findAllSchoolsUseCase.handle()).thenReturn(List.of(school1, school2));

    this.mockMvc.perform(get("/schooling/api/v1/schools"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("""
            [
               {
                  "id":"id1",
                  "name":"school1"
               },
               {
                  "id":"id2",
                  "name":"school2"
               }
            ]
            """));
  }

}