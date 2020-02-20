package br.com.lomonteiro.teste.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.lomonteiro.teste.entity.Pedido;
import br.com.lomonteiro.teste.error.RequestValidationException;
import br.com.lomonteiro.teste.repository.PedidoRepository;
import br.com.lomonteiro.teste.transformer.PedidoTransformer;
import br.com.lomonteiro.teste.vo.PedidoVO;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional(value = TxType.REQUIRED)
	public List<PedidoVO> processarPedidos(List<PedidoVO> lista) {
		
		if(ObjectUtils.isEmpty(lista)) {
			throw new RequestValidationException("Nenhum pedido foi informado!");
		}
		else {
			
			if(lista.size() > 10) {
				throw new RequestValidationException("O serviço está limitado a 10 pedidos");
			}
			
			List<Pedido> listaPedido = gerarListaPedidos(lista);
			processamentoPedidos(listaPedido);
			gravar(listaPedido);
			
			return gerarRetorno(listaPedido);
		}
				
	}
	
	@Transactional(value = TxType.REQUIRED)
	private void gravar(List<Pedido> listaPedido) {
		listaPedido.forEach(pedido -> {
			Pedido dbObj = pedidoRepository.findOneByNumeroControle(pedido.getNumeroControle());
			if(dbObj != null) {
				throw new RequestValidationException("O pedido de numero " + pedido.getNumeroControle() + " já existe na base de dados.");
			}
			pedidoRepository.save(pedido);
		});
		
	}

	private void processamentoPedidos(List<Pedido> listaPedido) {
		listaPedido.forEach(pedido -> {
			if(ObjectUtils.isEmpty(pedido.getDataCadastro())) {
				pedido.setDataCadastro(new Date());
			}
			gerarValorTotal(pedido);
		});
	}

	private List<PedidoVO> gerarRetorno(Iterable<Pedido> listaPedido) {
		List<PedidoVO> listaRetorno = new ArrayList<PedidoVO>();
		listaPedido.forEach(p -> listaRetorno.add(PedidoTransformer.transform(p)));
		return listaRetorno;
	}

	private void gerarValorTotal(Pedido pedido) {
		BigDecimal desconto = BigDecimal.ZERO;
		if(ObjectUtils.isEmpty(pedido.getQuantidadeProduto())) {
			pedido.setQuantidadeProduto(1);
		}
		else if(pedido.getQuantidadeProduto() > 10) {
			desconto = gerarDesconto(pedido, 0.1);
		}
		else if(pedido.getQuantidadeProduto() > 5) {
			desconto = gerarDesconto(pedido, 0.05);
		}
		pedido.setTotal(pedido.getValorProduto().multiply(new BigDecimal(pedido.getQuantidadeProduto())).subtract(desconto));
	}

	private BigDecimal gerarDesconto(Pedido pedido, Double porcentagem) {
		return pedido.getValorProduto().multiply(new BigDecimal(porcentagem));
	}

	private List<Pedido> gerarListaPedidos(List<PedidoVO> listaPedidoVO) {
		List<Pedido> listaPedido = new ArrayList<Pedido>();
		listaPedidoVO.forEach(pedidoVO -> listaPedido.add(PedidoTransformer.transform(pedidoVO)));
		return listaPedido;
	}
	
	@Transactional(value = TxType.SUPPORTS)
	public List<PedidoVO> listarPedidos(Integer numeroControle, Date dataCadastro, Integer idCliente) {
		
		Iterable<Pedido> lista = null;
		
		if(numeroControle == null && dataCadastro == null && idCliente == null) {
			lista =	pedidoRepository.findAll();
		}
		else if (numeroControle != null && dataCadastro == null && idCliente == null) {
			lista =	pedidoRepository.findByNumeroControle(numeroControle);
		}
		else if (numeroControle == null && dataCadastro != null && idCliente == null) {
			lista =	pedidoRepository.findByDataCadastro(dataCadastro);
		}
		else if (numeroControle == null && dataCadastro == null && idCliente != null) {
			lista =	pedidoRepository.findByIdCliente(idCliente);
		}
		else if (numeroControle != null && dataCadastro != null && idCliente == null) {
			lista =	pedidoRepository.findByNumeroControleAndDataCadastro(numeroControle, dataCadastro);
		}
		else if (numeroControle != null && dataCadastro == null && idCliente != null) {
			lista =	pedidoRepository.findByNumeroControleAndIdCliente(numeroControle, idCliente);
		}
		else if (numeroControle == null && dataCadastro != null && idCliente != null) {
			lista =	pedidoRepository.findByDataCadastroAndIdCliente(dataCadastro, idCliente);
		}
		else {
			lista =	pedidoRepository.findByNumeroControleAndDataCadastroAndIdCliente(numeroControle, dataCadastro, idCliente);
		}
		
		return gerarRetorno(lista);		
	}	
}
