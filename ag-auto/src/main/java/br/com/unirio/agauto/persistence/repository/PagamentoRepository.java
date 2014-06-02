package br.com.unirio.agauto.persistence.repository;

import org.springframework.stereotype.Repository;

import br.com.unirio.agauto.persistence.entity.Pagamento;
import br.com.unirio.agauto.persistence.repository.generic.GenericSpringHibernateService;

@Repository
public class PagamentoRepository extends
		GenericSpringHibernateService<Pagamento, Long> {

	public PagamentoRepository() {
		super.setClazz(Pagamento.class);
	}

}
