package br.edu.iftm.ppi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.iftm.ppi.domain.Orcamento;



@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {

}
