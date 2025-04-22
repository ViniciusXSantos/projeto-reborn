package com.example.agencia_viagens.resource;


import com.example.agencia_viagens.event.RecursoCriadoEvent;
import com.example.agencia_viagens.model.Telefone;
import com.example.agencia_viagens.model.Usuario;
import com.example.agencia_viagens.repository.UsuarioRepository;

import com.example.agencia_viagens.repository.filter.UsuarioFilter;
import com.example.agencia_viagens.service.UsuarioService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
// @CrossOrigin(origins = "*")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	/*
	@GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
	
	@GetMapping("/pesquisar")
	public List<Usuario> pesquisar(UsuarioFilter usuarioFilter) {
		return usuarioRepository.filtrar(usuarioFilter);
	}
	*/
	
	@GetMapping
	public List<Usuario> listarOuPesquisar(UsuarioFilter usuarioFilter) {
		return (usuarioFilter != null && possuiFiltro(usuarioFilter))
				? usuarioRepository.filtrar(usuarioFilter)
				: usuarioRepository.findAll();
	}

    private boolean possuiFiltro(UsuarioFilter filter) {
        return StringUtils.isNotBlank(filter.getNome()) ||
            StringUtils.isNotBlank(filter.getEmail()) || 
            StringUtils.isNotBlank(filter.getTelefone());
    }
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		// Associa cada telefone ao usuário antes de salvar
		if (usuario.getTelefones() != null) {
			usuario.getTelefones().forEach(telefone -> telefone.setUsuario(usuario));
		}
		
		Usuario usuarioSalva = usuarioRepository.save(usuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalva.getIdUsuario()));

		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalva);
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> buscarPeloId(@PathVariable Long idUsuario) {
	    Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);

		if (usuario != null) {
			// Garante que a lista de telefones seja carregada antes de retornar o objeto
			usuario.getTelefones().size();
			return ResponseEntity.ok(usuario);
		}

		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	    //return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{idUsuario}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long idUsuario) {
	    usuarioRepository.deleteById(idUsuario);
	}

	@PutMapping("/{idUsuario}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long idUsuario, @Valid @RequestBody Usuario usuario) {
	    /*Usuario usuarioSalva = usuarioService.atualizar(idUsuario, usuario);
	    return ResponseEntity.ok(usuarioSalva);*/

		return usuarioRepository.findById(idUsuario).map(usuarioExistente -> {
			// Atualiza os dados básicos do usuário
			usuarioExistente.setNome(usuario.getNome());
			usuarioExistente.setEmail(usuario.getEmail());
			usuarioExistente.setAtivo(usuario.getAtivo());
	
			// Atualiza os telefones
			if (usuario.getTelefones() != null) {
				usuario.getTelefones().forEach(telefone -> telefone.setUsuario(usuarioExistente));
				usuarioExistente.getTelefones().clear();
				usuarioExistente.getTelefones().addAll(usuario.getTelefones());
			}
	
			Usuario usuarioAtualizado = usuarioRepository.save(usuarioExistente);
			return ResponseEntity.ok(usuarioAtualizado);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{idUsuario}/email")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeEmail(@PathVariable Long idUsuario, @RequestBody String email) {
	    usuarioService.atualizarPropriedadeEmail(idUsuario, email);
	}
	
	@PutMapping("/{idUsuario}/telefones/{idTelefone}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarTelefone(@PathVariable Long idUsuario, @PathVariable Long idTelefone, @RequestBody Telefone telefoneAtualizado) {
		usuarioRepository.findById(idUsuario).ifPresent(usuario -> {
			usuario.getTelefones().stream()
				.filter(t -> t.getId().equals(idTelefone))
				.findFirst()
				.ifPresent(telefone -> {
					telefone.setNumero(telefoneAtualizado.getNumero());
					telefone.setTipo(telefoneAtualizado.getTipo());
					usuarioRepository.save(usuario);
				});
		});
	}

	@PutMapping("/{idUsuario}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long idUsuario, @RequestBody Boolean ativo) {
	    usuarioService.atualizarPropriedadeAtivo(idUsuario, ativo);
	}
	
}
