package com.schooling.app.features.school.application.usecase;

import com.schooling.app.features.school.application.port.SchoolStorage;
import com.schooling.app.features.school.domain.exception.SchoolNotFoundException;
import com.schooling.app.features.school.domain.model.School;
import com.schooling.app.shared.annotation.UseCaseService;

@UseCaseService
public class UpdateSchoolUseCase {

  private final SchoolStorage schoolStorage;

  public UpdateSchoolUseCase(SchoolStorage schoolStorage) {
    this.schoolStorage = schoolStorage;
  }

  public School handle(School school) {
    if (! schoolStorage.exist(school.id())) {
      throw new SchoolNotFoundException("School '%s' does not exist".formatted(school.id()));
    }

    return schoolStorage.update(school);
  }
}
