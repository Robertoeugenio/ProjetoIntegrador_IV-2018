package br.edu.iftm.ppi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.iftm.ppi.domain.Fazenda;



@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Integer> {

}
