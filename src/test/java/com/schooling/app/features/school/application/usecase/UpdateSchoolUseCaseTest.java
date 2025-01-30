package com.schooling.app.features.school.application.usecase;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import com.schooling.app.features.school.application.port.SchoolStorage;
import com.schooling.app.features.school.domain.exception.SchoolNotFoundException;
import com.schooling.app.features.school.domain.model.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateSchoolUseCaseTest {

  @Mock
  private SchoolStorage schoolStorage;

  @InjectMocks
  private UpdateSchoolUseCase updateSchoolUseCase;

  @Mock
  private School schoolToUpdate;

  @BeforeEach
  void setUp() {
    when(schoolToUpdate.id()).thenReturn("school");
  }

  @Test
  void shoudl_throw_school_not_found_when_school_does_not_exist() {
    when(schoolStorage.exist("school")).thenReturn(false);

    assertThatThrownBy(() -> updateSchoolUseCase.handle(schoolToUpdate))
    .isInstanceOf(SchoolNotFoundException.class)
        .hasMessage("school 'school' not found");


  }
}