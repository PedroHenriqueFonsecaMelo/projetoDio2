package projetoDio.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoDio.personapi.entidade.Pessoa;

public interface PersonRepository extends JpaRepository <Pessoa, Long> {
}
