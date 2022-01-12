package projetoDio.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum PhoneType {
    Home("Home"),
    Mobile( "Mobile"),
    Comercial("Comercial");
    private final String descricao;
}
