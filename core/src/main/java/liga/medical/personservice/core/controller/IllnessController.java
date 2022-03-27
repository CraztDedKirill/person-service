package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.IllnessEntity;
import liga.medical.personservice.core.service.IllnessService;
import liga.medical.personservice.dto.IllnessDto;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/illness")
public class IllnessController {

    private IllnessService illnessService;
    private ModelMapper modelMapper;

    public IllnessController(IllnessService illnessService, ModelMapper modelMapper) {
        this.illnessService = illnessService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    void saveNewIllnessEntity(@RequestBody @Valid IllnessDto illnessDto) {
        IllnessEntity illnessEntity = modelMapper.map(illnessDto, IllnessEntity.class);
        illnessService.insert(illnessEntity);
    }

    @PostMapping("/save-all")
    void saveNewIllnessEntity(@RequestBody @Valid List<IllnessDto> illnessEntity) {
        List<IllnessEntity> illnessEntityList = illnessEntity.stream()
                .map(el -> modelMapper.map(el, IllnessEntity.class))
                .collect(Collectors.toList());
        illnessService.insertAll(illnessEntityList);
    }

    @GetMapping("/{id}")
    IllnessDto getIllnessById(@PathVariable Long id) {
        IllnessEntity illnessEntity = illnessService.getIllnessById(id);
        return modelMapper.map(illnessEntity, IllnessDto.class);
    }

    @GetMapping("")
    List<IllnessDto> getIllnessByIds(@RequestParam List<Long> ids) {
        List<IllnessEntity> illnessEntity = illnessService.getIllnessByIds(ids);
        return illnessEntity.stream()
                .map(el -> modelMapper.map(el, IllnessDto.class))
                .collect(Collectors.toList());
    }
}
