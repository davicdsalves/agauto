package br.com.unirio.agauto.persistence.repository;

import org.springframework.stereotype.Repository;

import br.com.unirio.agauto.persistence.entity.Automovel;
import br.com.unirio.agauto.persistence.repository.generic.GenericSpringHibernateService;

@Repository
public class AutomovelRepository extends
		GenericSpringHibernateService<Automovel, Long> {

	public AutomovelRepository() {
		super.setClazz(Automovel.class);
	}

}
