package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.repository.PersonDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class PersonDataService {

    private PersonDataRepository personDataRepository;

    public PersonDataService(PersonDataRepository personDataRepository) {
        this.personDataRepository = personDataRepository;
    }

    public void insert(PersonDataEntity personData) {
        personDataRepository.insert(personData);
    }
    public void insertAll(List<PersonDataEntity> personDataEntityList) {
        personDataRepository.insertAll(personDataEntityList);
    }

    public PersonDataEntity getPersonDataById( Long id) {
        return personDataRepository.findById(id);
    }

    public List<PersonDataEntity> getPersonDataByIds(@RequestParam List<Long> ids) {
        return personDataRepository.findByIds(ids);
    }
}
