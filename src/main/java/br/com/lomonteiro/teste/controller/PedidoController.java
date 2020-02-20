package br.com.lomonteiro.teste.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lomonteiro.teste.service.PedidoService;
import br.com.lomonteiro.teste.vo.MensagemVO;
import br.com.lomonteiro.teste.vo.PedidoVO;

@RestController
@RequestMapping(path = "/pedido", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping("/enviar-pedido")
	public ResponseEntity<MensagemVO>  enviarPedido(@RequestBody List<PedidoVO> listaPedido) {
		List<PedidoVO> retorno = pedidoService.processarPedidos(listaPedido);
		return new ResponseEntity<MensagemVO>(new MensagemVO("Pedido realizado com sucesso!", retorno), HttpStatus.OK);
	}

	@GetMapping("/listar-pedido")
	public List<PedidoVO> listarPedido(@RequestParam(required = false) Integer numeroControle, @RequestParam(required = false) Date dataCadastro, @RequestParam(required = false) Integer idCliente) {
		return pedidoService.listarPedidos(numeroControle, dataCadastro, idCliente);
	}

}
