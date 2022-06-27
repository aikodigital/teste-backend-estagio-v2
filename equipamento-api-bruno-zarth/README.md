<h1>Equipamento API</h1> 

Esta API foi desenvolvida para o teste de estágio backend da AIKO Digita. Consiste em um CRUD com 6 entidades. API testada, documentada e com deploy via Heroku. 

### Tópicos 

:small_blue_diamond: [Funcionalidades da API](#funcionalidades-da-API)

:small_blue_diamond: [Deploy da Aplicação](#deploy-da-aplicação-dash)

:small_blue_diamond: [Como rodar a aplicação](#como-rodar-a-aplicação-arrow_forward)

:small_blue_diamond: [Testes](#Testes)

:small_blue_diamond: [Linguagens, dependencias e frameworks utilizados :books:](#Linguagens-dependencias-e-frameworks-utilizados-books)



## Funcionalidades da API

Segue a lista documentada de endpoints com suas funcionalidades via swagger:

:heavy_check_mark: Equipment: https://equipamento-api.herokuapp.com/swagger-ui/index.html#/equipment-controller

:heavy_check_mark: Equipment Model: https://equipamento-api.herokuapp.com/swagger-ui/index.html#/equipment-model-controller

:heavy_check_mark: Equipment State: https://equipamento-api.herokuapp.com/swagger-ui/index.html#/equipment-state-controller

:heavy_check_mark: Equipment Model State Hourly Earnings: https://equipamento-api.herokuapp.com/swagger-ui/index.html#/equipment-model-state-hourly-earnings-controller  

:heavy_check_mark: Equipment State History: https://equipamento-api.herokuapp.com/swagger-ui/index.html#/equipment-state-history-controller

:heavy_check_mark: Equipment Position History: https://equipamento-api.herokuapp.com/swagger-ui/index.html#/equipment-position-history-controller

## Deploy da Aplicação :dash:

https://equipamento-api.herokuapp.com/swagger-ui/index.html#/


## Como rodar a aplicação :arrow_forward:

Para rodar localmente será necessário abrir o projeto na IDE de sua preferência e configurar devidamente o arquivo application.properties com os dados
de acesso ao banco de dados (Postgres). 

## Testes

Foram testadas todas as funcionalidades, ou seja, o CRUD de cada entidade.
Os testes de API foram todos executados e desenvolvidos com Postman + Newman.
O relatório está documentado no arquivo "Relatorio De Testes - EquipamentoAPI.html".
Para acessar o relatório basta baixar o arquivo e abrir no browser. 

## Linguagens, dependencias e frameworks utilizados :books:

O app foi desenvolvido inteiramente com Java, Spring boot, banco de dados Postgres e testado via Postman/Newman.
Dependências do Spring Boot:
SpringDoc, Spring Data JPA, Spring Web, Devtools, Postgres Drive e Lombok. 
