package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.service.ContactService;
import liga.medical.personservice.dto.ContactDto;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/contact")
public class ContactController {

    private  ContactService contactService;
    private  ModelMapper modelMapper;

    public ContactController(ContactService contactService, ModelMapper modelMapper) {
        this.contactService = contactService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    void saveNewContactEntity(@RequestBody @Valid ContactDto contactDto) {
        ContactEntity contactEntity = modelMapper.map(contactDto, ContactEntity.class);
        contactService.insert(contactEntity);
    }

    @PostMapping("/save-all")
    void saveNewContactEntity(@RequestBody @Valid List<ContactDto> contactEntity) {
        List<ContactEntity> contactEntityList = contactEntity.stream()
                .map(el -> modelMapper.map(el, ContactEntity.class))
                .collect(Collectors.toList());
        contactService.insertAll(contactEntityList);
    }

    @GetMapping("/{id}")
    ContactDto getContactById(@PathVariable Long id) {
        ContactEntity contactEntity = contactService.getContactById(id);
        return modelMapper.map(contactEntity, ContactDto.class);
    }

    @GetMapping("")
    List<ContactDto> getContactByIds(@RequestParam List<Long> ids) {
        List<ContactEntity> contactEntity = contactService.getContactByIds(ids);
        return contactEntity.stream()
                .map(el -> modelMapper.map(el, ContactDto.class))
                .collect(Collectors.toList());
    }
}
