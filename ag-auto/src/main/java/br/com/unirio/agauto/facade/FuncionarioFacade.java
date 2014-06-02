package br.com.unirio.agauto.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unirio.agauto.controller.dto.FuncionarioDTO;
import br.com.unirio.agauto.persistence.entity.Funcionario;
import br.com.unirio.agauto.persistence.repository.FuncionarioRepository;

@Component
public class FuncionarioFacade {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<FuncionarioDTO> getFuncionarios() {
		List<FuncionarioDTO> dtos = new ArrayList<>();
		List<Funcionario> funcionarios = funcionarioRepository.findAll("ID");
		for (Funcionario funcionario : funcionarios) {
			FuncionarioDTO dto = new FuncionarioDTO();
			dto.setId(funcionario.getId());
			dto.setMatricula(funcionario.getMatricula());
			dto.setNome(funcionario.getNome());
			dtos.add(dto);
		}
		return dtos;
	}
}
