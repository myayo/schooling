package com.schooling.app.features.school.infra.repository;

import com.schooling.app.features.school.application.port.SchoolStorage;
import com.schooling.app.features.school.domain.model.School;
import java.util.List;

public class MongoSchoolStorage  implements SchoolStorage {

  @Override
  public List<School> findAll() {
    return List.of();
  }
}
