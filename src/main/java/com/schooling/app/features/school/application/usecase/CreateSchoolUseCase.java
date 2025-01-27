package com.schooling.app.features.school.application.usecase;

import com.schooling.app.features.school.application.port.SchoolStorage;
import com.schooling.app.features.school.domain.model.School;
import com.schooling.app.shared.annotation.UseCaseService;

@UseCaseService
public class CreateSchoolUseCase {

  private SchoolStorage schoolStorage;

  public CreateSchoolUseCase(SchoolStorage schoolStorage) {
    this.schoolStorage = schoolStorage;
  }

  public School handle (School newSchool) {
    return schoolStorage.create(newSchool);
  }

}
