package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.service.PersonDataService;
import liga.medical.personservice.dto.PersonDataDto;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/admin/person-data")
public class PersonDataController {

    private  PersonDataService personDataService;
    private  ModelMapper modelMapper;

    public PersonDataController(ModelMapper modelMapper, PersonDataService personDataService) {
        this.modelMapper = modelMapper;
        this.personDataService = personDataService;
    }

    @PostMapping("/save")
    void saveNewPersonDataEntity(@RequestBody @Valid PersonDataDto personDataDto) {
        PersonDataEntity personDataEntity = modelMapper.map(personDataDto, PersonDataEntity.class);
        personDataService.insert(personDataEntity);
    }

    @PostMapping("/save-all")
    void saveNewPersonDataEntity(@RequestBody @Valid List<PersonDataDto> personDataEntity) {
        List<PersonDataEntity> personDataEntityList = personDataEntity.stream()
                .map(el -> modelMapper.map(el, PersonDataEntity.class))
                .collect(Collectors.toList());
        personDataService.insertAll(personDataEntityList);
    }

    @GetMapping("/{id}")
    PersonDataDto getPersonDataById(@PathVariable Long id) {
        PersonDataEntity personDataEntity = personDataService.getPersonDataById(id);
        return modelMapper.map(personDataEntity, PersonDataDto.class);
    }

    @GetMapping("")
    List<PersonDataDto> getPersonDataByIds(@RequestParam List<Long> ids) {
        List<PersonDataEntity> personDataEntity = personDataService.getPersonDataByIds(ids);
        return personDataEntity.stream()
                .map(el -> modelMapper.map(el, PersonDataDto.class))
                .collect(Collectors.toList());
    }
}