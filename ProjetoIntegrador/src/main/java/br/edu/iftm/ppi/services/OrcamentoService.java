package br.edu.iftm.ppi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.iftm.ppi.domain.Orcamento;
import br.edu.iftm.ppi.exceptions.DataIntegrityException;
import br.edu.iftm.ppi.exceptions.ObjectNotFoundException;
import br.edu.iftm.ppi.repositories.OrcamentoRepository;

@Service
public class OrcamentoService {
	
	@Autowired
	private OrcamentoRepository repo;
	
//	@Autowired
//	private CidadeRepository cidadeRepository;
//	
//	@Autowired
//	private EnderecoRepository enderecoRepository;
	
	public Orcamento find(Integer id){
		Optional<Orcamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+", Tipo: "+ Orcamento.class.getName()));

	}
	
	//@Transactional
	public Orcamento insert(Orcamento obj) {
		obj.setId(null);
		obj = repo.save(obj);
		//OrcamentoRepository.saveAll(obj);
		return obj;
		
	}
//	
//	public Orcamento update(Orcamento obj) {
//		Orcamento newObj = find(obj.getId());
//		updateData(newObj, obj);
//		return repo.save(newObj);
//		
//	}
//	
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
	public List<Orcamento> findAll(){
		return repo.findAll();
		
	}
//	
//	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
//		
//		PageRequest pageRequest =  PageRequest.of(page,linesPerPage, Direction.valueOf(direction), orderBy);
//		return repo.findAll(pageRequest);
//	}
//	
//	public Cliente fromDTO(ClienteDTO objDto) {
//		
//		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
//
//	}
//	
//	public Cliente fromDTO(ClienteNewDTO objDto) {
//		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
//Cidade cid = cidadeRepository.getOne(objDto.getCidadeId());
//		Endereco end = new Endereco(null,objDto.getLogradouro(),objDto.getNumero(),objDto.getComplemento(), objDto.getBairro(),objDto.getCep(), cli, cid);
//	
//	cli.getEnderecos().add(end);
//	cli.getTelefones().add(objDto.getTelefone1());
//	if(objDto.getTelefone2()!= null) {
//		
//		cli.getTelefones().add(objDto.getTelefone2());
//	}
//if(objDto.getTelefone2()!= null) {
//		
//		cli.getTelefones().add(objDto.getTelefone2());
//		
//		return cli;
//	}
//return cli;
//	}
//	
//	private void updateData(Cliente newObj, Cliente obj) {
//		newObj.setNome(obj.getNome());
//		newObj.setEmail(obj.getEmail());
//		
//	}
}
