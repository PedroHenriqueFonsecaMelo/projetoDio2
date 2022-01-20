package projetoDio.personapi.Controler;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projetoDio.personapi.dtos.PessoaDTO;
import projetoDio.personapi.dtos.MessageResponseDTO;

import projetoDio.personapi.exception.PersonNotFoundException;
import projetoDio.personapi.services.PersonServices;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping ("/api/V1/teste")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Controller {

    private final PersonServices personServices;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PessoaDTO personDTO) {
        return personServices.create(personDTO);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PessoaDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personServices.findById(id);
    }

    @GetMapping
    public List<PessoaDTO> listAll() {
        return personServices.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PessoaDTO personDTO) throws PersonNotFoundException {
        return personServices.update(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        personServices.delete(id);
    }
}
