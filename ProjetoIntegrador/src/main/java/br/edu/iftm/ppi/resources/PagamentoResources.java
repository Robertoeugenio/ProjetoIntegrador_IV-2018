package br.edu.iftm.ppi.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.edu.iftm.ppi.domain.Pagamento;
import br.edu.iftm.ppi.services.PagamentoService;

@RestController
@RequestMapping(value="/pagamentos")
public class PagamentoResources {
	
	@Autowired
	private PagamentoService service;
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pagamento> find(@PathVariable Integer id) {
		Pagamento obj = service.find(id);	
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pagamento obj){
		//Cliente obj = service.fromDTO(obj);
		Pagamento obj1 = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
//	public ResponseEntity<Void> update(@Valid @RequestBody Pagamento obj, @PathVariable Integer id){
//		//Pagamento obj = service.fromDTO(objDto);
//		obj.setId(id);
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();
//	}
//	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Pagamento> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
//
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<Pagamento>> findAll() {
			
		List<Pagamento> list = service.findAll();
		
		//List<ClienteDTO> listDto = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
//	
//	@RequestMapping(value="page", method=RequestMethod.GET)
//	public ResponseEntity<Page<ClienteDTO>> findPage(
//			@RequestParam(value="page", defaultValue="0") Integer page,
//			@RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage, 
//			@RequestParam(value="orderBy", defaultValue="nome")String orderBy,
//			@RequestParam(value="direction", defaultValue="ASC")String direction
//			) {
//			
//		Page<Cliente> list = service.findPage(page,linesPerPage,orderBy,direction);
//		
//		Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));
//		return ResponseEntity.ok().body(listDto);
//	}
	

}
