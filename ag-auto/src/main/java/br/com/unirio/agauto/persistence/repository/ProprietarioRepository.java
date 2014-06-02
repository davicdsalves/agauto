package br.com.unirio.agauto.persistence.repository;

import org.springframework.stereotype.Repository;

import br.com.unirio.agauto.persistence.entity.Proprietario;
import br.com.unirio.agauto.persistence.repository.generic.GenericSpringHibernateService;

@Repository
public class ProprietarioRepository extends
		GenericSpringHibernateService<Proprietario, Long> {

	public ProprietarioRepository() {
		super.setClazz(Proprietario.class);
	}

}
