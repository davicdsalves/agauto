package br.com.unirio.agauto.persistence.repository;

import org.springframework.stereotype.Repository;

import br.com.unirio.agauto.persistence.entity.Funcionario;
import br.com.unirio.agauto.persistence.repository.generic.GenericSpringHibernateService;

@Repository
public class FuncionarioRepository extends
		GenericSpringHibernateService<Funcionario, Long> {

	public FuncionarioRepository() {
		super.setClazz(Funcionario.class);
	}

}
