package projetoDio.personapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoDio.personapi.PersonMapper;
import projetoDio.personapi.entidade.Pessoa;
import projetoDio.personapi.repository.PersonRepository;
import projetoDio.personapi.dtos.*;
import projetoDio.personapi.dito.resposta.MessageResponseDTO;

@Service
public class PersonServices {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO criaPessoa(PessoaDTO pessoaDTO){
        Pessoa ParaSalvar = personMapper.toModel(pessoaDTO);
        Pessoa PessoaSalva = personRepository.save(ParaSalvar);

        return MessageResponseDTO
                .builder()
                .message("created Person with ID "+PessoaSalva.getId())
                .build();
    }
}
