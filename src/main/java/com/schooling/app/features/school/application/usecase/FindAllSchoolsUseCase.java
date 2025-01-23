package com.schooling.app.features.school.application.usecase;

import com.schooling.app.features.school.application.port.SchoolStorage;
import com.schooling.app.features.school.domain.model.School;
import java.util.List;

public class FindAllSchoolsUseCase {

  private final SchoolStorage schoolStorage;

  public FindAllSchoolsUseCase(SchoolStorage schoolStorage) {
    this.schoolStorage = schoolStorage;
  }

  public List<School> handle() {
      return schoolStorage.findAll();
  }
}
