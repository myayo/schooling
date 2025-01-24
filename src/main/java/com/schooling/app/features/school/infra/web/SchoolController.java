package com.schooling.app.features.school.infra.web;

import com.schooling.app.features.school.application.usecase.FindAllSchoolsUseCase;
import com.schooling.app.features.school.domain.model.School;
import com.schooling.app.features.school.infra.web.dto.SchoolDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schooling/api/v1")
public class SchoolController {

  private FindAllSchoolsUseCase findAllSchoolsUseCase;

  public SchoolController(FindAllSchoolsUseCase findAllSchoolsUseCase) {
    this.findAllSchoolsUseCase = findAllSchoolsUseCase;
  }

  @GetMapping("/schools")
  public List<SchoolDto> findAll() {
    return findAllSchoolsUseCase.handle()
        .stream()
        .map(this::mapToDto)
        .toList();
  }

  private SchoolDto mapToDto(School school) {
    return new SchoolDto(school.id(), school.name());
  }

}
