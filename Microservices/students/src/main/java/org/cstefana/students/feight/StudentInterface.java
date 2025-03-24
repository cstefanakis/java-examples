package org.cstefana.students.feight;

import org.cstefana.students.models.School;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("SCHOOLS")
public interface StudentInterface {

    @GetMapping("/api/school")
    public ResponseEntity<List<School>> getAllSchools();

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable long id);

}
