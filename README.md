# CR - API Java com Spring Boot

Este repositório contém uma aplicação Java utilizando Spring Boot, pronta para rodar localmente e configurada para deploy em produção. Abaixo estão os passos necessários para clonar o projeto e iniciar a aplicação em diferentes ambientes.

## Clonando o Projeto

Para clonar o projeto, execute o seguinte comando:

```sh
git clone https://github.com/soupaulodev/dio-crud-api-spring.git
cd dio-crud-api-springs
```

## Executando Localmente no IntelliJ IDEA

Para executar a aplicação localmente no IntelliJ IDEA, siga os passos abaixo:

1. Importar o projeto:

   - Abra o IntelliJ IDEA.
   - Selecione "File" > "Open" e navegue até o diretório onde o projeto foi clonado.
   - Selecione o arquivo pom.xml e clique em "Open" para importar o projeto.

2. Configurar o arquivo de configuração do banco de dados:

   - Renomeie o arquivo ./src/main/resources/application-for-prod-example.yml para application.properties.
   - Edite o arquivo ./src/main/resources/application.properties e preencha com as configurações do seu banco de dados PostgreSQL.

3. Executar a aplicação:

   - No IntelliJ IDEA, localize o arquivo principal da aplicação, geralmente nomeado Application.java dentro do pacote principal.
   - Clique com o botão direito do mouse no arquivo e selecione "Run 'Application.main()'".

4. Verificar a execução:

   - Após a inicialização, verifique o console do IntelliJ IDEA para mensagens de inicialização da aplicação.
   - Acesse as rotas da aplicação conforme descrito na seção "Rotas da Aplicação" deste README.

## Configuração para Deploy em Produção

Para configurar a aplicação para deploy em produção, siga os passos abaixo (já mencionados anteriormente):

1. Excluir o arquivo de configuração local:

   - Exclua o arquivo ./src/main/resources/application.yml.

2. Renomear o arquivo de exemplo para produção:

   - Renomeie o arquivo ./src/main/resources/application-for-prod-example.yml para application.properties.

3. Preencher application.properties com os dados do PostgreSQL:

   - Edite o arquivo ./src/main/resources/application.properties e preencha com as configurações do seu banco de dados PostgreSQL.

4. Limpar e construir com Maven:

   - Execute os seguintes comandos:

   ```sh
   mvn clean
   mvn install
   ```

5. Atualizar o arquivo JAR Docker:

   - Delete o arquivo ./docker-spring-boot.jar.
   - Copie o arquivo gerado pela build Maven para a raiz do projeto e renomeie-o para docker-spring-boot.jar.

6. Deploy:

- Suba a aplicação para um serviço de hospedagem como Railway ou outro de sua escolha.

## Estrutura do Usuário

Um usuário possui os seguintes atributos:

- id: Identificador único do usuário.
- name: Nome do usuário.
- account:
  - id: Identificador único da conta.
  - number: Número da conta.
  - agency: Agência da conta.
  - balance: Saldo da conta.
  - limit: Limite da conta.
- card:
  - id: Identificador único do cartão.
  - number: Número do cartão.
  - limit: Limite do cartão.
- features: Lista de funcionalidades adicionais do usuário.

  - id: Identificador único da funcionalidade.
  - icon: Ícone representativo da funcionalidade.
  - description: Descrição da funcionalidade.

- news: Lista de notícias ou novidades para o usuário.
  - id: Identificador único da notícia.
  - icon: Ícone representativo da notícia.
  - description: Descrição da notícia.

## Rotas da Aplicação

A aplicação define as seguintes rotas principais:

- GET /users/{id}:

  - Retorna os detalhes do usuário com o ID especificado.
  - Exemplo: /users/1

- POST /users:
  - Cria um novo usuário com base nos dados fornecidos no corpo da requisição.
  - Exemplo de corpo da requisição:

```json
{
  "name": "João Silva",
  "account": {
    "number": "12345-6",
    "agency": "7890-1",
    "balance": 1000.0,
    "limit": 500.0
  },
  "card": {
    "number": "1234-5678-9012-3456",
    "limit": 2000.0
  },
  "features": [
    {
      "icon": "icon-path",
      "description": "Descrição da funcionalidade 1"
    },
    {
      "icon": "icon-path",
      "description": "Descrição da funcionalidade 2"
    }
  ],
  "news": [
    {
      "icon": "icon-path",
      "description": "Notícia 1"
    },
    {
      "icon": "icon-path",
      "description": "Notícia 2"
    }
  ]
}
```

## Autor

Este projeto foi desenvolvido durante o curso "Publicando Sua API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway", parte do bootcamp Santander 2024 - Backend com Java.
