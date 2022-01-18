package projetoDio.personapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoDio.personapi.dito.resposta.MessageResponseDTO;
import projetoDio.personapi.entidade.Pessoa;
import projetoDio.personapi.repository.PersonRepository;

@Service
public class PersonServices {
    private PersonRepository personRepository;


    @Autowired
    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO criaPessoa(Pessoa pessoa){
        Pessoa PessoaSalva = personRepository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message("created Person with ID "+PessoaSalva.getId())
                .build();
    }
}
