package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IllnessDto {

    private Long medicalCardId;

    private Long typeId;

    private Character hearviness;

    private LocalDateTime appearanceDateTime;

    private LocalDate recoveryDate;
}
