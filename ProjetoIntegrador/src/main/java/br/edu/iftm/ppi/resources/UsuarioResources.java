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
import br.edu.iftm.ppi.domain.Usuario;
import br.edu.iftm.ppi.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResources {
	
	@Autowired
	private UsuarioService service;
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		Usuario obj = service.find(id);	
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Usuario obj){
		//Cliente obj = service.fromDTO(obj);
		Usuario obj1 = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
//	public ResponseEntity<Void> update(@Valid @RequestBody Usuario obj, @PathVariable Integer id){
//		//Usuario obj = service.fromDTO(objDto);
//		obj.setId(id);
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();
//	}
//	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Usuario> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
//
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
			
		List<Usuario> list = service.findAll();
		
		//List<ClienteDTO> listDto = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
		@RequestMapping( value="/login",method=RequestMethod.POST)
		public ResponseEntity<Usuario>login(@RequestBody UsuarioRequest obj){
			
			List<Usuario> list = service.findAll();
			for(Usuario e: list) {
				
				System.out.println(e.getSenha());
				System.out.println(e.getLogin());
				
				if(obj.getLogin.equals(e.getLogin())&& obj.getSenha().equals(e.getSenha())){
					
					return ResponseEntity.ok().body(e);
					
				}
				return null;
			}
			
		}
		@RequestMapping( value="/{id}",method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody Usuario obj,@PathVariable Integer id){
			
			obj.setId(id);
			obj = service.updateData(obj, obj);
			return ResponseEntity.noContent().build();
		}

}
