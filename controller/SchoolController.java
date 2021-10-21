package hiber.controller;

import hiber.model.School;
import hiber.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/school")
public class SchoolController {
    private final SchoolService schoolService;

    @Autowired

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/get_school/{id}")
    public School findSchoolById(@PathVariable("id") UUID id) {
        return schoolService.findById(id);
    }

    @PostMapping("/delete_school/{id}")
    public void deleteSchoolById(@PathVariable("id") UUID id) {
        schoolService.deleteSchoolById(id);
    }
}
