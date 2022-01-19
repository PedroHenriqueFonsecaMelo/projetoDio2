package projetoDio.personapi;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import projetoDio.personapi.*;
import projetoDio.personapi.dtos.PessoaDTO;
import projetoDio.personapi.entidade.Pessoa;


@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO dto);

    PessoaDTO toDTO(Pessoa pessoa);
}
