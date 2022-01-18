package projetoDio.personapi.Controler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projetoDio.personapi.dito.resposta.MessageResponseDTO;
import projetoDio.personapi.entidade.Pessoa;

import projetoDio.personapi.services.PersonServices;

@RestController
@RequestMapping (value = "/api/V1/teste")
public class Controler {

    private PersonServices personServices;

    public Controler(PersonServices personServices) {
        this.personServices = personServices;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criaPessoa(@RequestBody Pessoa pessoa){
        return personServices.criaPessoa(pessoa);
    }
}
