package com.schooling.app.features.school.infra.web;

import com.schooling.app.features.school.application.usecase.CreateSchoolUseCase;
import com.schooling.app.features.school.application.usecase.FindAllSchoolsUseCase;
import com.schooling.app.features.school.application.usecase.UpdateSchoolUseCase;
import com.schooling.app.features.school.domain.model.School;
import com.schooling.app.features.school.infra.web.dto.SchoolWebDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schooling/api/v1/schools")
public class SchoolController {

  private final FindAllSchoolsUseCase findAllSchoolsUseCase;

  private final CreateSchoolUseCase createSchoolUseCase;

  private final UpdateSchoolUseCase updateSchoolUseCase;

  public SchoolController(FindAllSchoolsUseCase findAllSchoolsUseCase,
      CreateSchoolUseCase createSchoolUseCase, UpdateSchoolUseCase updateSchoolUseCase) {
    this.findAllSchoolsUseCase = findAllSchoolsUseCase;
    this.createSchoolUseCase = createSchoolUseCase;
    this.updateSchoolUseCase = updateSchoolUseCase;
  }

  @GetMapping
  public List<SchoolWebDto> findAll() {
    return findAllSchoolsUseCase.handle()
        .stream()
        .map(this::mapToDto)
        .toList();
  }

  @PostMapping
  public SchoolWebDto create(@RequestBody SchoolWebDto dto) {
    return mapToDto(createSchoolUseCase.handle(mapToDomain(dto)));
  }

  @PutMapping
  public SchoolWebDto update(@RequestBody SchoolWebDto dto) {
    return mapToDto(updateSchoolUseCase.handle(mapToDomain(dto)));
  }

  private School mapToDomain(SchoolWebDto schoolWebDto) {
    return new School(schoolWebDto.id(), schoolWebDto.name());
  }

  private SchoolWebDto mapToDto(School school) {
    return new SchoolWebDto(school.id(), school.name());
  }

}
