package projetoDio.personapi.Controler;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/api/V1/teste")
public class Controler {
    @GetMapping
    public String getBook(){
        return "teste";

    }
}
