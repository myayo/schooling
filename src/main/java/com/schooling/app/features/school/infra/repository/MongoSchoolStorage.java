package com.schooling.app.features.school.infra.repository;

import com.schooling.app.features.school.application.port.SchoolStorage;
import com.schooling.app.features.school.domain.model.School;
import com.schooling.app.features.school.infra.repository.dto.SchoolMongoDto;
import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class MongoSchoolStorage  implements SchoolStorage {

  private final MongoTemplate mongoTemplate;

  public MongoSchoolStorage(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public List<School> findAll() {
    return mongoTemplate.findAll(SchoolMongoDto.class)
        .stream()
        .map(this::map)
        .toList();
  }

  @Override
  public School create(School school) {
    SchoolMongoDto schoolMongoDto = new SchoolMongoDto(UUID.randomUUID().toString(), school.name());
    return map(mongoTemplate.insert(schoolMongoDto));
  }

  @Override
  public School update(School school) {
    SchoolMongoDto schoolMongoDto = new SchoolMongoDto(school.id(), school.name());
    return map(mongoTemplate.save(schoolMongoDto));
  }

  @Override
  public boolean exist(School school) {
    return mongoTemplate.exists(Query.query(Criteria.where("_id").is(school.id())),
        SchoolMongoDto.class);
  }

  private School map(SchoolMongoDto schoolMongoDto) {
    return new School(schoolMongoDto.id(), schoolMongoDto.name());
  }
}
