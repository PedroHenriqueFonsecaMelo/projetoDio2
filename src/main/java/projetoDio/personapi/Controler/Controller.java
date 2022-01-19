package projetoDio.personapi.Controler;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projetoDio.personapi.dtos.PessoaDTO;
import projetoDio.personapi.dtos.MessageResponseDTO;

import projetoDio.personapi.services.PersonServices;

import javax.validation.Valid;


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
}
