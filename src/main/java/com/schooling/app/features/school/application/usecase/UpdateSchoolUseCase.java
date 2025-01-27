package com.schooling.app.features.school.application.usecase;

import com.schooling.app.features.school.application.port.SchoolStorage;
import com.schooling.app.features.school.domain.model.School;
import com.schooling.app.shared.annotation.UseCaseService;

@UseCaseService
public class UpdateSchoolUseCase {

  private SchoolStorage schoolStorage;

  public UpdateSchoolUseCase(SchoolStorage schoolStorage) {
    this.schoolStorage = schoolStorage;
  }

  public School handle(School school) {
    if (! schoolStorage.exist(school)) {
      throw new RuntimeException("School does not exist");
    }

    return schoolStorage.update(school);
  }
}
