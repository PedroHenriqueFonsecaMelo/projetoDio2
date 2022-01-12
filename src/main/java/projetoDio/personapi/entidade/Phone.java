package projetoDio.personapi.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projetoDio.personapi.enums.PhoneType;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    private long id;
    private PhoneType type;
    private String number;

}
