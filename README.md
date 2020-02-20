Teste
-


Orientações para rodar a aplicação:
- Criar uma base de dados PostgreSQL com nome teste, rodar o script teste.sql na raiz do projeto (ou rodar a aplicação,
ela já cria os objetos do banco automaticamente);
- O usuário da base de dados é postgres e a senha é 123456;

Orientações para utilização da API:
- Serviço de recebimento de pedidos:
      1. Acessar o recurso http://localhost:8080/pedido/enviar-pedido via POST passando json com os campos do objeto PedidoVO: 
         id, numeroControle, dataCadastro, total, nomeProduto, valorProduto, quantidadeProduto, idCliente;
- Serviço de listagem:
      1. Acessar o recurso http://localhost:8080/pedido/listar-pedido via GET, acessando o recurso sem paramentros lista todos os                pedidos, para utilizar os filtros é só adicionar os parametros (http://localhost:8080/pedido/listar-pedido?numeroControle=1).

Cenário descrito:

Criar uma solução java em formato de API REST que atenda aos seguintes requisitos para a recepção de pedidos dos clientes:
- Todos os serviços devem trabalhar com XML e JSON para chamadas e retornos;
- Criar um serviço que receba pedidos com 6 campos:
      1. número controle - número aleatório informado pelo cliente;
      2. data cadastro (opcional)
      3. nome - nome do produto
      4. valor - valor monetário unitário produto
      5. quantidade (opcional) - quantidade de produtos.
      6. codigo cliente - identificação numérica do cliente.
- Critérios de aceitação e uso dos serviço:
      1. O arquivo pode conter 1 ou mais pedidos, limitado a 10;
      2. Não poderá aceitar um número de controle já cadastrado;
      3. Caso a data de cadastro não seja enviada o sistema deve assumir a data atual;
      4. Caso a quantidade não seja enviada considerar 1;
      5. Caso a quantidade seja maior que 5 aplicar 5% de desconto no valor total, para quantidades a partir de 10 aplicar 10% de       desconto no valor total;
      6. O sistema deve calcular e gravar o valor total do pedido;

Criar um serviço onde possa consultar os pedidos enviados pelos clientes:
- Filtros da consulta: número controle, data cadastro, cliente e todos;
- Critérios aceitação:
    1. O retorno deve trazer todos os dados do pedido;

Frameworks:
- Fica a critério do candidato utilizar ou não, sem restrições de escolha.

Desejável:
- Padrões de projeto;
- Testes unitários;



Obrigatório:
- Injeção de dependência;
- Utilizar framework ORM;
- Utilizar a linguagem java 1.8;
- Maven;

Obs.:
- A solução deve ser publicada no github;
- Enviar script de criação das tabelas;
- Enviar descritivo de como efetuar a chamada dos serviços;
- Deve ser enviado o link do repositório da solução para este email;
