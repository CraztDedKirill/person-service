package liga.medical.personservice.core.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PersonDataEntity {

    private Long id;

    private String lastName;

    private String firstName;

    private LocalDate birthDt;

    private int age;

    private char sex;

    private Long contactId;

    private Long medicalCardId;

    private Long parentId;
}
