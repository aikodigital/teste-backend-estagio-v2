# Desafio estágio back end java
Teste V2 para a vaga de estagiário em desenvolvimento Backend.

## Rodando o projeto
### Inicialize o arquivo compose
O projeto não vai funcionar se o arquivo compose não estiver ativo. 
Ele é responsável por inicializar o banco de dados PostgreSQL.
```shell
docker-compose up
```

### Gerando o jar do projeto com Maven
Após o banco de dados ser inicializado, executado o comando abaixo para gerar o jar do projeto.
```shell
mvn clean package
```

### Rodando o projeto
Para executar o projeto, acesse o diretório target e rode o comando abaixo no arquivo jar.
```shell
cd target
java -jar *.jar
```

### Acessando a documentação gerada pelo Swagger
```
localhost:8080/api/swagger-ui.html
```

## Tecnologias usadas
- Java
- Spring, Spring Boot, Spring Data JPA, Spring Web
- Swagger
- JUnit5 e Mockito
- PostgreSQL
- Docker e docker-compose