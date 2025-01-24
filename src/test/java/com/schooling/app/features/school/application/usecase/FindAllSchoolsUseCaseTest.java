package com.schooling.app.features.school.application.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.schooling.app.features.school.application.port.SchoolStorage;
import com.schooling.app.features.school.domain.model.School;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindAllSchoolsUseCaseTest {

  @Mock
  private School school1;

  @Mock
  private School school2;

  @Mock
  private SchoolStorage schoolStorage;

  @InjectMocks
  private FindAllSchoolsUseCase findAllSchoolsUseCase;

  @Test
  void should_find_all_schools_from_school_storage() {
    when(schoolStorage.findAll()).thenReturn(List.of(school1, school2));

    List<School> schools = findAllSchoolsUseCase.handle();

    verify(schoolStorage).findAll();
    assertThat(schools).containsExactlyInAnyOrder(school1, school2);
  }
}