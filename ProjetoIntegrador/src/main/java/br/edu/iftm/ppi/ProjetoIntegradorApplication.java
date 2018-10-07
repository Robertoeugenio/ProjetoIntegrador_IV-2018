package br.edu.iftm.ppi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.ppi.domain.Fazenda;
import br.edu.iftm.ppi.domain.Usuario;
import br.edu.iftm.ppi.repositories.FazendaRepository;
import br.edu.iftm.ppi.repositories.UsuarioRepository;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ProjetoIntegradorApplication implements CommandLineRunner {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private FazendaRepository fazendaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoIntegradorApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario(null, "breno mendes","1234",  "0234566", "breno@gmail.com", "enoisqvoa123");
		Usuario user2 = new Usuario(null, "bryan mendes","4567",  "0987654", "bryan@gmail.com", "enoisqcorre456");
	
		Fazenda faz1 = new Fazenda(null,"Bom Caminho",234434.3434,23232323.2232323, user1);
		Fazenda faz2 = new Fazenda(null,"Olhos Dágua",98786764.3434,22323.2323, user1);
		
		user1.getFazendas().addAll(Arrays.asList(faz1,faz2));
		//user2.getFazendas().addAll(Arrays.asList(faz2));
		
		
	
	usuarioRepository.saveAll(Arrays.asList(user1, user2));
	fazendaRepository.saveAll(Arrays.asList(faz1, faz2));
	
	}
		
} 
