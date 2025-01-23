package com.schooling.app.features.school.application.port;

import com.schooling.app.features.school.domain.model.School;
import java.util.List;

public interface SchoolStorage {

  List<School> findAll();

}
