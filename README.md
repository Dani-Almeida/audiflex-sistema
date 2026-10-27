# Audiflex Sistema

Sistema de orçamentos para cortinas e persianas, desenvolvido em Java como projeto de estudo e aplicação prática de conceitos de desenvolvimento de software.

## Sobre o projeto

O Audiflex Sistema surgiu da necessidade de facilitar a elaboração de orçamentos em uma empresa do segmento de cortinas e persianas.

O objetivo é organizar as informações dos clientes, selecionar produtos e automatizar os cálculos dos orçamentos, reduzindo a necessidade de cálculos manuais.

O projeto está em desenvolvimento e utiliza uma aplicação de console.

## Tecnologias utilizadas

- Java 21
- Maven
- MySQL
- JDBC
- JUnit 5
- Git e GitHub

## Funcionalidades implementadas

- Entrada de informações do cliente.
- Consulta de produtos cadastrados no MySQL.
- Cadastro de produtos no banco de dados por meio da classe DAO.
- Seleção de produtos para o orçamento.
- Cálculo de área da persiana.
- Aplicação de percentual de acréscimo.
- Inclusão de adicionais, como motor tubular.
- Inclusão de múltiplos itens no orçamento.
- Cálculo do valor total.
- Exibição do resumo do orçamento no console.

## Status do projeto

**Em desenvolvimento.**

O sistema utiliza atualmente uma regra provisória de área mínima cobrada de 1,20 m². As regras de cálculo ainda serão revisadas para contemplar diferentes modelos e condições comerciais.

Os valores utilizados em exemplos e testes são fictícios e não representam tabelas comerciais reais.

## Próximas melhorias

- Aprimorar as validações de entrada.
- Implementar testes unitários das regras de negócio.
- Revisar as regras de cálculo por modelo.
- Melhorar o tratamento de erros.
- Ampliar as operações de cadastro e consulta.
- Evoluir a interface do sistema.

## Autoria

Projeto desenvolvido por [Dani Almeida](https://github.com/Dani-Almeida) como parte dos estudos em desenvolvimento de software, com foco em Java e backend.


## Configuração do banco de dados

O projeto utiliza MySQL para consultar e cadastrar produtos.

### Pré-requisitos

- Java 21
- Maven
- MySQL

### Configuração

1. Criar um banco de dados MySQL chamado `audiflex`.
2. Configurar a conexão com o banco de dados na classe `Conexao.java`.
3. Definir a variável de ambiente `AUDIFLEX_DB_PASSWORD` com a senha do usuário MySQL.
4. Criar a tabela `produto`, utilizada pela classe `ProdutoDAO`.

**Estrutura esperada da tabela `produto`:**

```sql
CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(150) NOT NULL,
    preco_tabela DOUBLE NOT NULL
);
```

A estrutura acima é uma sugestão compatível com as consultas implementadas no projeto.

**Importante:** utilize apenas dados fictícios para testes. Não publique senhas, informações pessoais de clientes ou tabelas comerciais reais.

### Execução

O sistema possui uma classe principal chamada `App.java`, localizada no pacote `br.com.audiflex`.

Após configurar o banco de dados e suas credenciais, execute essa classe pela IDE.

O programa permite selecionar produtos, informar medidas, adicionar itens e visualizar o orçamento no console.