package br.com.unirio.agauto.persistence.repository;

import org.springframework.stereotype.Repository;

import br.com.unirio.agauto.persistence.entity.Modelo;
import br.com.unirio.agauto.persistence.repository.generic.GenericSpringHibernateService;

@Repository
public class ModeloRepository extends
		GenericSpringHibernateService<Modelo, Long> {

	public ModeloRepository() {
		super.setClazz(Modelo.class);
	}

}
