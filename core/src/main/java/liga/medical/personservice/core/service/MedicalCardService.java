package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Service
public class MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;

    public MedicalCardService(MedicalCardRepository medicalCardRepository) {
        this.medicalCardRepository = medicalCardRepository;
    }

    public void insert(MedicalCardEntity medicalCard) {
        medicalCardRepository.insert(medicalCard);
    }

    public void insertAll(List<MedicalCardEntity> cardEntityList) {
        medicalCardRepository.insertAll(cardEntityList);
    }

    public MedicalCardEntity getCardById( Long id) {
        return medicalCardRepository.findById(id);
    }

    public List<MedicalCardEntity> getCardByIds(@RequestParam List<Long> ids) {
        return medicalCardRepository.findByIds(ids);
    }
}
