package liga.medical.personservice.core.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class IllnessEntity {

    private Long id;

    private Long medicalCardId;

    private Long typeId;

    private char heaviness;

    private LocalDate appearanceDttm;

    private LocalDate recoveryDt;
}
