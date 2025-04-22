package com.example.agencia_viagens.repository.usuario;


import com.example.agencia_viagens.model.Usuario;
import com.example.agencia_viagens.repository.filter.UsuarioFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Usuario> filtrar(UsuarioFilter usuarioFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		Root<Usuario> root = criteria.from(Usuario.class);
		
		// Criar as restrições
		Predicate[] predicates = criarRestricoes(usuarioFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Usuario> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(UsuarioFilter usuarioFilter, CriteriaBuilder builder, Root<Usuario> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(StringUtils.hasText(usuarioFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get("nome")), "%" + usuarioFilter.getNome().toLowerCase() + "%"));
		}
		if(StringUtils.hasText(usuarioFilter.getEmail())) {
			predicates.add(builder.like(
					builder.lower(root.get("email")), "%" + usuarioFilter.getEmail().toLowerCase() + "%"));
		}
		if(StringUtils.hasText(usuarioFilter.getTelefone())) {
			predicates.add(builder.like(
					builder.lower(root.get("telefone")), "%" + usuarioFilter.getTelefone().toLowerCase() + "%"));
		}
        if (usuarioFilter.getAtivo() != null) {
            predicates.add(builder.equal(root.get("ativo"), usuarioFilter.getAtivo()));
        }        
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
