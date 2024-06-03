# Desafio Técnico: Back-End

Este projeto é uma aplicação back-end desenvolvida em Java com Spring Boot para gerenciar sessões de votação em cooperativas.

## Objetivo

No universo cooperativista, cada associado é detentor de um voto e as deliberações ocorrem por meio de assembleias, nas quais são realizadas votações. Este projeto visa criar uma solução back-end para o gerenciamento dessas sessões de votação, permitindo o cadastro de pautas, abertura de sessões de votação, recebimento de votos dos associados e contabilização dos resultados das votações.

## Funcionalidades

A aplicação promove as seguintes funcionalidades através de uma API REST:

- Cadastrar uma nova pauta
- Abrir uma sessão de votação em uma pauta (com duração configurável)
- Receber votos dos associados em pautas
- Contabilizar os votos e dar o resultado da votação na pauta

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Gradle

## Dependências

- Spring Web
- Validation
- Spring for Apache Kafka
- Spring Data MongoDB
- Lombok
- Spring Cloud Starter Openfeign
- MapStruct

## Estrutura do Projeto

O projeto segue uma arquitetura hexagonal, dividindo o código em 3 camadas principais:

- **Application (Core da Aplicação)**: Contém a lógica de negócios da aplicação.
- **Adapters**: Responsável por conectar os casos de uso da camada de Application a elementos externos.
- **Ports (Interfaces)**: Define interfaces que representam as portas de comunicação entre a camada de Application e os adaptadores externos.

## Configuração e Execução

Para compilar e executar a aplicação, siga estas etapas:

1. Certifique-se de ter o Java 17 e o Gradle instalados em sua máquina.
2. Clone este repositório para o seu ambiente local.
3. Navegue até o diretório raiz do projeto.
4. Execute o seguinte comando para compilar o projeto:

```
gradle build
```

5. Execute o Docker Compose na pasta `docker-local` para iniciar o MongoDB e o Kafka:

```
docker-compose up
```

6. Após a compilação e a inicialização do Docker Compose, execute o seguinte comando para iniciar o servidor:

```
gradle bootRun
```

7. A aplicação estará disponível em `http://localhost:8081`.

## Aplicação Rodando na Nuvem AWS

Esta aplicação está atualmente hospedada na nuvem AWS e está disponível no seguinte endereço:

[ec2-184-72-163-91.compute-1.amazonaws.com:8081](http://ec2-184-72-163-91.compute-1.amazonaws.com:8081)

## Documentação da API

### Cadastro de Pauta

- **URL**: `/api/v1/pautas`
- **Método HTTP**: POST
- **Payload de Entrada**:
  ```json
  {
      "nome": "string",
      "descricao": "string"
  }
  ```
- **Payload de Saída**:
  ```json
  {
      "id": "string",
      "nome": "string",
      "descricao": "string"
  }
  ```

### Abertura de Sessão de Votação

- **URL**: `/api/v1/sessoes`
- **Método HTTP**: POST
- **Payload de Entrada**:
  ```json
  {
      "pautaId": "string",
      "duracaoEmMinutos": 1
  }
  ```
- **Payload de Saída**:
  ```json
  {
      "id": "string",
      "pauta": {
          "id": "string",
          "nome": "string",
          "descricao": "string"
      },
      "dataInicio": "string",
      "dataFim": "string",
      "encerrada": false,
      "votos": []
  }
  ```

### Votar em uma Sessão de Votação

- **URL**: `/api/v1/sessoes/{id}/votar`
- **Método HTTP**: POST
- **Payload de Entrada**:
  ```json
  {
      "cpfAssociado": "string",
      "voto": "string"
  }
  ```

### Resultado de uma Pauta

- **URL**: `/api/v1/pautas/{id}/resultado`
- **Método HTTP**: GET
- **Payload de Saída**:
  ```json
  {
      "pautaId": "string",
      "totalSim": 2,
      "totalNao": 2
  }
  ```

## Tarefas Bônus

As seguintes tarefas bônus foram implementadas:

1. **Integração com sistemas externos**: Foi implementada a integração com um sistema externo para verificação de CPFs dos associados, garantindo que apenas associados válidos possam votar.

2. **Mensageria e filas**: Foi implementada a utilização de mensageria e filas para comunicação entre os componentes da aplicação. Quando a sessão de votação é encerrada, uma mensagem com o resultado da votação é postada em uma fila.

4. **Versionamento da API**: Foi implementado o versionamento da API para garantir compatibilidade com clientes existentes. O versionamento é realizado através de prefixos de URL, por exemplo, `/api/v1`.

## Atenção

As linhas 41, 42 e 43 do arquivo `SendVotoUseCase.java` estão descomentadas por padrão. Estas linhas são responsáveis por ativar a validação via API externa para verificação dos CPFs dos associados, e essa API está sempre retornando 404 no momento (está aparentemente desligada). Para desativar esta validação, basta comentar essas linhas no código-fonte.

## Rafael Oliveira Silva

- GitHub: [rafaelos-git](https://github.com/rafaelos-git)
