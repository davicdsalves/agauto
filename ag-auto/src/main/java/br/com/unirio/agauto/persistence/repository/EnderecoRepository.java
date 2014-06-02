package br.com.unirio.agauto.persistence.repository;

import org.springframework.stereotype.Repository;

import br.com.unirio.agauto.persistence.entity.Endereco;
import br.com.unirio.agauto.persistence.repository.generic.GenericSpringHibernateService;

@Repository
public class EnderecoRepository extends
		GenericSpringHibernateService<Endereco, Long> {

	public EnderecoRepository() {
		super.setClazz(Endereco.class);
	}

	
}
