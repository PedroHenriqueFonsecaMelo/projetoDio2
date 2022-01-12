package projetoDio.personapi.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private List<Phone> phone;
    private long id;
    private String FirstName;
    private String LastName;
    private String CPF;
    private LocalDate Nascimento;
}
