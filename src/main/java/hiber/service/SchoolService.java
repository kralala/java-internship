package hiber.service;

import hiber.model.School;
import hiber.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School findById(UUID id) {
        return schoolRepository.getById(id);
    }

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public void deleteSchoolById(UUID id) {
        schoolRepository.deleteById(id);
    }
}
