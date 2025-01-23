package com.schooling.app.features.school.infra.web;

import com.schooling.app.features.school.application.usecase.FindAllSchoolsUseCase;
import com.schooling.app.features.school.domain.model.School;
import com.schooling.app.features.school.infra.web.dto.SchoolDto;
import java.util.List;

public class SchoolController {

  private FindAllSchoolsUseCase findAllSchoolsUseCase;

  public SchoolController(FindAllSchoolsUseCase findAllSchoolsUseCase) {
    this.findAllSchoolsUseCase = findAllSchoolsUseCase;
  }



  public List<SchoolDto> findAll() {
    return findAllSchoolsUseCase.handle()
        .stream()
        .map(this::mapToDto)
        .toList();
  }

  private SchoolDto mapToDto(School school) {
    return null;
  }

}
