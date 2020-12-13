# CCC PHARMA - BACK-END

Link para o Front-end: https://github.com/vitoriaHeliane/ccc-pharma

## Descrição

Uma nova farmácia vai ser aberta em Campina Grande e precisa de um sistema que gerencie o estoque de produtos vendidos. Neste sistema, o administrador deve obter uma visão geral e o controle sobre o funcionamento da farmácia, por exemplo, ele deve poder adicionar novos produtos, acompanhar quantas unidades do produto estão disponíveis, alterar preços, ser notificado sobre eventos críticos, gerenciar as vendas e oferecer alguns serviços personalizados para o cliente.

## Funcionalidades Implementadas

### Obrigatórias
- Eu, como administrador, gostaria de ter o sistema armazenando todos os seus dados de forma persistente em um banco de dados. 
- Eu, como usuário, gostaria de acessar o sistema através de um link na web, preferencialmente usando o Heroku.
- Eu, como administrador, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas ao administrador.
- Eu, como cliente, gostaria de realizar o cadastro no sistema, para poder obter acesso ao sistema.
- Eu, como cliente, gostaria de logar no sistema, para poder ter acesso às funcionalidades destinadas ao cliente.

### Opcionais
- Foram adicionadas as seguintes User Stories: 1, 2, 3, 4, 5, 7, 9, 10, 13, 14.
- A US 11 foi implementada de forma incompleta, apenas no Back-end.
- A relação de todos os requisito:

CCC PHARMA

Uma nova farmácia vai ser aberta em Campina Grande e precisa de um sistema que gerencie o estoque de produtos vendidos. Neste sistema, o administrador deve obter uma visão geral e o controle sobre o funcionamento da farmácia, por exemplo, ele deve poder adicionar novos produtos, acompanhar quantas unidades do produto estão disponíveis, alterar preços, ser notificado sobre eventos críticos, gerenciar as vendas e oferecer alguns serviços personalizados para o cliente.
 
User Stories obrigatórias
 
Eu, como administrador, gostaria de ter o sistema armazenando todos os seus dados de forma persistente em um banco de dados.
Eu, como usuário, gostaria de acessar o sistema através de um link na web, preferencialmente usando o Heroku.
Eu, como administrador, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas ao administrador.
Eu, como cliente, gostaria de realizar o cadastro no sistema, para poder obter acesso ao sistema.
Eu, como cliente, gostaria de logar no sistema, para poder ter acesso às funcionalidades destinadas ao cliente.
User Stories optativas (escolher 10)
Eu, como administrador, gostaria de adicionar um novo produto no sistema, informando seu nome, código de barra, fabricante, situação e categoria. As categorias disponíveis na farmácia são: medicamentos, produtos de higiene pessoal, cosméticos e alimentos.
Eu, como administrador, gostaria de consultar a disponibilidade e o preço de cada produto da farmácia.
Eu, como administrador, gostaria de atribuir um preço (R$) a um determinado produto no sistema.
Eu, como administrador, gostaria de criar lotes associados aos produtos, informando a quantidade de itens disponíveis e a data de validade.
Eu, como cliente, gostaria de consultar a disponibilidade e o preço de cada produto da farmácia (não precisa estar logado).
Eu, como administrador, gostaria de ordenar os produtos e os registros de vendas da farmácia de acordo com informações importantes deles (por exemplo, ordenar os produtos por nome, preço, data, categoria).
Eu, como administrador, gostaria de atribuir descontos para cada categoria de produto, dessa forma, o cliente recebe um abatimento no valor final da compra. Tipos de desconto: sem desconto (0%), bom desconto (10%), ótimo desconto (25%) e super desconto (50%).
Eu, como administrador, gostaria de consultar um relatório geral da farmácia, visualizando informações do estoque dos produtos (nº de lotes, nº de itens, datas de validade), registros de vendas e receita arrecadada.
Eu, como administrador, gostaria que um produto fosse marcado como indisponível quando a quantidade de itens dele for igual a zero. Dessa forma, o seu preço não pode ser mais exibido para os clientes e ele deve ser adicionado na lista de produtos em falta.
Eu, como administrador, gostaria que um produto fosse marcado como indisponível quando todos os lotes do produto ultrapassarem a data de validade. Dessa forma, o seu preço não pode ser mais exibido para os clientes e ele deve ser adicionado na lista de produtos vencidos.
Eu, como administrador, gostaria de registrar uma venda, informando os produtos, a quantidade de itens e registrando o valor total da venda (descontos devem ser considerados). O número de itens do produto deve ser decrementado.
Eu, como administrador, gostaria de cancelar uma venda, dessa forma, o registro de venda deve ser deletado e o número itens do produto deve ser incrementado, tornando-os disponíveis para venda novamente.
Eu, como administrador, gostaria de receber notificações na tela inicial do sistema, avisando quando a quantidade de itens de um produto está baixa (abaixo de 15 unidades).
Eu, como administrador, gostaria de receber notificações na tela inicial do sistema, avisando quando a validade de um lote está próxima ao vencimento (um mês de antecedência).
Eu, como cliente, gostaria de reservar minhas compras pelo sistema, assim, minhas compras seriam coletadas e empacotadas com antecedência.
