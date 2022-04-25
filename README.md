# Teste Estágio Backend V2

## Introdução

Este projeto foi desenvolvido para o case técnico da Aiko Digital. O objetivo é desenvolver uma aplicação backend que exponha alguns dados de equipamentos usados numa determinada atuação florestal através de uma API. Para este projeto foram usadas as tecnologias Java, ORM Hibernate, PostgreSQL, Postman.

## Endpoints

Endpoints utilizados:

**get** _/equipamento/estado/recente_ : retorna uma lista com todos os estados mais recentes dos equipamentos.
200 ok.

```
{
“equipamento” : “string”
“estadoEquipamento” : “string”
“cor” : “string”
“data” : “21/04/2022 00:00:00”
}
``` 

**get** _/equipamento/posicao/recente_ : retorna uma lista com todas as posições mais recentes dos equipamentos.
200 ok.

```
{
“equipamento” : "1"
“latitude” : "string"
“longitude”: "string"
“data” : "21/04/2022 00:00:00"
}
```

CRUD API (GET, POST, PUT, DELETE): Equipamento, Estado de equipamento, Modelo de Equipamento, Ganhos por hora por estado, Histórico de posições de um equipamento, Histórico de estados de um equipamento.
