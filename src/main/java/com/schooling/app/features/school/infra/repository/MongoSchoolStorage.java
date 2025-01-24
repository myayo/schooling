package com.schooling.app.features.school.infra.repository;

import com.schooling.app.features.school.application.port.SchoolStorage;
import com.schooling.app.features.school.domain.model.School;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoSchoolStorage  implements SchoolStorage {

  private final MongoTemplate mongoTemplate;

  public MongoSchoolStorage(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public List<School> findAll() {
    return mongoTemplate.findAll(School.class, "school");
  }
}
