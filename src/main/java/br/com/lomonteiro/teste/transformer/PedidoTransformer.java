package br.com.lomonteiro.teste.transformer;

import br.com.lomonteiro.teste.entity.Pedido;
import br.com.lomonteiro.teste.vo.PedidoVO;

public class PedidoTransformer {
	
	public static Pedido transform(PedidoVO pedidoVO) {
		Pedido pedido = new Pedido();
		pedido.setId(pedidoVO.getId());
		pedido.setNumeroControle(pedidoVO.getNumeroControle());
		pedido.setDataCadastro(pedidoVO.getDataCadastro());
		pedido.setNomeProduto(pedidoVO.getNomeProduto());
		pedido.setValorProduto(pedidoVO.getValorProduto());
		pedido.setQuantidadeProduto(pedidoVO.getQuantidadeProduto());
		pedido.setTotal(pedidoVO.getTotal());
		pedido.setIdCliente(pedidoVO.getIdCliente());
		return pedido;
	}
	
	public static PedidoVO transform(Pedido pedido) {
		PedidoVO pedidoVO = new PedidoVO();
		pedidoVO.setId(pedido.getId());
		pedidoVO.setNumeroControle(pedido.getNumeroControle());
		pedidoVO.setDataCadastro(pedido.getDataCadastro());
		pedidoVO.setNomeProduto(pedido.getNomeProduto());
		pedidoVO.setValorProduto(pedido.getValorProduto());
		pedidoVO.setQuantidadeProduto(pedido.getQuantidadeProduto());
		pedidoVO.setTotal(pedido.getTotal());
		pedidoVO.setIdCliente(pedido.getIdCliente());
		return pedidoVO;
	}
	
}
