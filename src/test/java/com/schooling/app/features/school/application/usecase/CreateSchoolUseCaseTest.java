package com.schooling.app.features.school.application.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.schooling.app.features.school.application.port.SchoolStorage;
import com.schooling.app.features.school.domain.model.School;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateSchoolUseCaseTest {

  @InjectMocks
  private CreateSchoolUseCase createSchoolUseCase;

  @Mock
  private SchoolStorage schoolStorage;

  @Mock
  private School schoolToCreate;

  @Mock
  private School schoolCreated;

  @Test
  void handle_should_call_storage_create_school() {
    when(schoolStorage.create(schoolToCreate)).thenReturn(schoolCreated);

    School result = createSchoolUseCase.handle(schoolToCreate);

    assertThat(result).isSameAs(schoolCreated);
  }
}