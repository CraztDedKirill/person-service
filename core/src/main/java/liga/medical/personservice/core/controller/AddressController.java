package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.AddressEntity;
import liga.medical.personservice.core.service.AddressService;
import liga.medical.personservice.dto.AddressDto;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;
    private ModelMapper modelMapper;

    public AddressController(AddressService addressService, ModelMapper modelMapper) {
        this.addressService = addressService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    void saveNewAddressEntity(@RequestBody @Valid AddressDto addressDto) {
        AddressEntity addressEntity = modelMapper.map(addressDto, AddressEntity.class);
        addressService.insert(addressEntity);
    }

    @PostMapping("/save-all")
    void saveNewAddressEntity(@RequestBody @Valid List<AddressDto> addressEntity) {
        List<AddressEntity> addressEntityList = addressEntity.stream()
                .map(el -> modelMapper.map(el, AddressEntity.class))
                .collect(Collectors.toList());
        addressService.insertAll(addressEntityList);
    }

    @GetMapping("/{id}")
    AddressDto getAddressById(@PathVariable Long id) {
        AddressEntity addressEntity = addressService.getAddressById(id);
        return modelMapper.map(addressEntity, AddressDto.class);
    }

    @GetMapping("")
    List<AddressDto> getAddressByIds(@RequestParam List<Long> ids) {
        List<AddressEntity> addressEntity = addressService.getAddressByIds(ids);
        return addressEntity.stream()
                .map(el -> modelMapper.map(el, AddressDto.class))
                .collect(Collectors.toList());
    }
}
