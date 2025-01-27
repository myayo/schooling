package com.schooling.app.features.school.infra.repository.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "school")
public record SchoolMongoDto (String id, String name) {

}
