package br.edu.iftm.ppi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.iftm.ppi.domain.Usuario;
import br.edu.iftm.ppi.exceptions.DataIntegrityException;
import br.edu.iftm.ppi.exceptions.ObjectNotFoundException;
import br.edu.iftm.ppi.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
//	@Autowired
//	private CidadeRepository cidadeRepository;
//	
//	@Autowired
//	private EnderecoRepository enderecoRepository;
	
	public Usuario find(Integer id){
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+", Tipo: "+ Usuario.class.getName()));

	}
	
	//@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		//UsuarioRepository.saveAll(obj);
		return obj;
		
	}
	
	

	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir por que há entidades relacionadas");
			
		}
	}
//	
	public List<Usuario> findAll(){
		return repo.findAll();
		
	}

//	
	private void updateData(Usuario newObj,Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setLogin(obj.getLogin());
		newObj.setCpf(obj.getCpf());
		newObj.setSenha(obj.getSenha());
		
	}
	
	

		
		
	
}
