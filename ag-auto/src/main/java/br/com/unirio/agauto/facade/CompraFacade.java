package br.com.unirio.agauto.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unirio.agauto.controller.dto.CompraDTO;
import br.com.unirio.agauto.controller.dto.CompraDetailDTO;
import br.com.unirio.agauto.persistence.entity.Automovel;
import br.com.unirio.agauto.persistence.entity.Compra;
import br.com.unirio.agauto.persistence.entity.Funcionario;
import br.com.unirio.agauto.persistence.entity.Modelo;
import br.com.unirio.agauto.persistence.entity.Pagamento;
import br.com.unirio.agauto.persistence.entity.Proprietario;
import br.com.unirio.agauto.persistence.repository.AutomovelRepository;
import br.com.unirio.agauto.persistence.repository.CompraRepository;
import br.com.unirio.agauto.persistence.repository.FuncionarioRepository;
import br.com.unirio.agauto.persistence.repository.ModeloRepository;
import br.com.unirio.agauto.persistence.repository.PagamentoRepository;
import br.com.unirio.agauto.persistence.repository.ProprietarioRepository;

@Component
public class CompraFacade {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@Autowired
	private AutomovelRepository automovelRepository;

	@Autowired
	private ModeloRepository modeloRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private CompraRepository compraRepository; 

	public void save(CompraDTO dto) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");

		Proprietario proprietario = new Proprietario();
		proprietario.setNome(dto.getProprName());
		proprietario.setCpf(dto.getProprCpf());
		proprietario.setEmail(dto.getProprEmail());
		proprietario.setNascimento(format.parse(dto.getProprNascimento()));
		proprietario.setSexo(dto.getProprSexo());
		proprietario.setTelefone(dto.getProprTel());

		proprietarioRepository.save(proprietario);

		Modelo modelo = new Modelo();
		modelo.setAno(dto.getModAno());
		modelo.setCilindradas(dto.getModCil());
		modelo.setFabricante(dto.getModFabricante());
		modelo.setNome(dto.getModNome());
		modelo.setNumeroDePassageiros(dto.getModNumPass());
		modelo.setNumeroDePortas(dto.getModNumPort());

		Automovel automovel = new Automovel();
		automovel.setAnoDeFabricacao(dto.getAutoAno());
		automovel.setCombustivel(dto.getAutoCombustivel());
		automovel.setCor(dto.getAutoCor());
		automovel.setPlaca(dto.getAutoPlaca());
		automovel.setPrecoMinimoDeVenda(dto.getAutoPrecMinVenda());

		modeloRepository.save(modelo);
		automovel.setModelo(modelo);
		automovelRepository.save(automovel);

		Pagamento pagamento = new Pagamento();
		pagamento.setData(new Date());
		pagamento.setFormaDePagamento(dto.getPagForma());
		pagamento.setNumeroDeParcelas(dto.getPagNumParc());
		pagamento.setValorDeEntrada(dto.getPagValEntr());
		pagamento.setValorDePrestacoes(dto.getPagValPrest());

		pagamentoRepository.save(pagamento);
		
		Funcionario funcionario = funcionarioRepository.findOne(dto.getFuncionario());
		
		Compra compra = new Compra();
		compra.setAutomovel(automovel);
		compra.setData(new Date());
		compra.setFuncionario(funcionario);
		compra.setPagamento(pagamento);
		compra.setProprietario(proprietario);
		Double preco = (dto.getPagNumParc() * dto.getPagValPrest()) + dto.getPagValEntr(); 
		compra.setPreco(preco);
		
		compraRepository.save(compra);
	}
	
	public List<CompraDetailDTO> getCompras() {
		List<CompraDetailDTO> dtos = new ArrayList<>();
		List<Compra> compras = compraRepository.findAll("ID");
		for (Compra compra : compras) {
			CompraDetailDTO dto = new CompraDetailDTO();
			dto.setFuncNome(compra.getFuncionario().getNome());
			dto.setPlaca(compra.getAutomovel().getPlaca());
			dto.setPropNome(compra.getProprietario().getNome());
			dto.setValCompra(compra.getPreco());
			dtos.add(dto);
		}
		return dtos;
	}
}
