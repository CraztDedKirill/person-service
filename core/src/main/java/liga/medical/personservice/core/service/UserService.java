package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.model.AddressEntity;
import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.model.IllnessEntity;
import liga.medical.personservice.core.repository.UserRepository;
import liga.medical.personservice.dto.ContactDto;
import liga.medical.personservice.dto.MedicalCardDto;
import liga.medical.personservice.dto.AddressDto;
import liga.medical.personservice.dto.PersonDataDto;
import liga.medical.personservice.dto.IllnessDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ContactDto findContact(Long contactId) {
        ContactEntity contact = userRepository.findContact(contactId);
        return modelMapper.map(contact, ContactDto.class);
    }

    public MedicalCardDto findMedicalCard(Long cardId) {
        MedicalCardEntity medicalCard = userRepository.findMedicalCard(cardId);
        return modelMapper.map(medicalCard, MedicalCardDto.class);
    }

    public AddressDto findAddress(Long addressId) {
        AddressEntity address = userRepository.findAddress(addressId);
        return modelMapper.map(address, AddressDto.class);
    }

    public PersonDataDto findPersonData(Long personDataId) {
        PersonDataEntity personData = userRepository.findPersonData(personDataId);
        return modelMapper.map(personData, PersonDataDto.class);
    }

    public IllnessDto findIllness(Long illnessId) {
        IllnessEntity illness = userRepository.findIllness(illnessId);
        return modelMapper.map(illness, IllnessDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

}