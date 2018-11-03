package br.edu.iftm.ppi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.iftm.ppi.domain.Proposta;



@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer> {

//	@Transactional(readOnly = true)
//	Cliente findByEmail(String email);
}
