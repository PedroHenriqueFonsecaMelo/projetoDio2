package projetoDio.personapi.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetoDio.personapi.dtos.PessoaDTO;
import projetoDio.personapi.entidade.Pessoa;
import projetoDio.personapi.exception.PersonNotFoundException;
import projetoDio.personapi.dtos.PersonMapper;
import projetoDio.personapi.repository.PersonRepository;
import projetoDio.personapi.dtos.MessageResponseDTO;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonServices {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;


    public MessageResponseDTO create(PessoaDTO personDTO) {
        Pessoa person = personMapper.toModel(personDTO);
        Pessoa savedPerson = personRepository.save(person);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ",
                savedPerson.getId());

        return messageResponse;
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }

    public PessoaDTO findById(Long id) throws PersonNotFoundException {
        Pessoa person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PessoaDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Pessoa updatedPerson = personMapper.toModel(personDTO);
        Pessoa savedPerson = personRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }

    public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }

}
