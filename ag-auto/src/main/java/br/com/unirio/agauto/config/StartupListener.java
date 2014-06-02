package br.com.unirio.agauto.config;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unirio.agauto.persistence.entity.Endereco;
import br.com.unirio.agauto.persistence.entity.Funcionario;
import br.com.unirio.agauto.persistence.entity.Sexo;
import br.com.unirio.agauto.persistence.repository.EnderecoRepository;
import br.com.unirio.agauto.persistence.repository.FuncionarioRepository;

@Component
public class StartupListener {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public void createBasicData() {
		System.out.println("Criando Funcionario - START");
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Botafogo");
		endereco.setCep("22250-040");
		endereco.setEstado("RJ");
		endereco.setMunicipio("Rio de Janeiro");
		endereco.setNumero(519);
		endereco.setPais("Brasil");
		endereco.setRua("Praia de Botafogo");
		enderecoRepository.save(endereco);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setEndereco(endereco);
		funcionario.setMatricula("100456");
		funcionario.setNome("FulanoX");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1988);
		calendar.set(Calendar.MONTH, 10);
		calendar.set(Calendar.DAY_OF_MONTH, 14);
		funcionario.setNascimento(calendar.getTime());
		funcionario.setSexo(Sexo.MASCULINO);
		funcionario.setEmail("a@a.com");
		funcionario.setTelefone("2199999999");
		
		funcionarioRepository.save(funcionario);
		System.out.println("Criando Funcionario - DONE");
	}

}
