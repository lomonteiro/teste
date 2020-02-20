package br.com.lomonteiro.teste.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.lomonteiro.teste.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

	Pedido findOneByNumeroControle(Integer numeroControle);
	
	Iterable<Pedido> findByNumeroControle(Integer numeroControle);
	
	Iterable<Pedido> findByIdCliente(Integer idCliente);
	
	Iterable<Pedido> findByDataCadastro(Date dataCadastro);
	
	Iterable<Pedido> findByNumeroControleAndIdCliente(Integer numeroControle, Integer idCliente);
	
	Iterable<Pedido> findByNumeroControleAndDataCadastro(Integer numeroControle, Date dataCadastro);

	Iterable<Pedido> findByDataCadastroAndIdCliente(Date dataCadastro, Integer idCliente);
	
	Iterable<Pedido> findByNumeroControleAndDataCadastroAndIdCliente(Integer numeroControle, Date dataCadastro, Integer idCliente);
}
