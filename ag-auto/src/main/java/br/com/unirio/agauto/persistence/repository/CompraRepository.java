package br.com.unirio.agauto.persistence.repository;

import org.springframework.stereotype.Repository;

import br.com.unirio.agauto.persistence.entity.Compra;
import br.com.unirio.agauto.persistence.repository.generic.GenericSpringHibernateService;

@Repository
public class CompraRepository extends
		GenericSpringHibernateService<Compra, Long> {

	public CompraRepository() {
		super.setClazz(Compra.class);
	}

}
