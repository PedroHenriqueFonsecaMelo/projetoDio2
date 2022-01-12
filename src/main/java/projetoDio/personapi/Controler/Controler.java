package projetoDio.personapi.Controler;



import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetoDio.personapi.dito.resposta.MessageResponseDTO;
import projetoDio.personapi.entidade.Pessoa;
import projetoDio.personapi.repository.PersonRepository;

@RestController
@RequestMapping (value = "/api/V1/teste")
public class Controler {

    private PersonRepository personRepository;

    @Autowired
    public Controler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO criaPessoa(@RequestBody Pessoa pessoa){
        Pessoa PessoaSalva = personRepository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message("created Person with ID"+PessoaSalva.getId())
                .build();
    }
}
