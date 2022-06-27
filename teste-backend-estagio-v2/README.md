#TESTE ESTÁGIO BACKEND V2 AIKO – RODRIGO SANTANA PEREIRA

### 1.	INTRODUÇÃO

Este projeto foi desenvolvido para a etapa de Case Técnico do processo de estágio da Aiko. Nele é desenvolvido um sistema back-end de uma empresa que coleta dados de equipamentos utilizados em uma operação florestal. Para isso foi desenvolvido um programa Spring Boot utilizando o Spring Web e o banco de dados PostgreSQL. 

#### REQUISITOS DO PROGRAMA

•	API de CRUD: Desenvolver uma API que exponha os métodos de Criar, Excluir, Editar e Ler para as seguintes entidades:

    o	Equipamento.

    o	Estado de equipamento.

    o	Modelo de Equipamento.

    o	Ganhos por hora por estado.

    o	Histórico de posições de um equipamento.

    o	Histórico de estados de um equipamento.

•	Estado atual do equipamento: Criar Endpoint na API que deve retornar o estado mais recente dos equipamentos.

•	Posição atual por equipamento: Criar Endpoint na API que deve retornar a posição mais recente dos equipamentos.

#### DEPENDÊNCIAS UTILIZADAS

Para o desenvolvimento do trabalho foram utilizadas as seguintes dependências:
•	Spring Web
•	PostgreSQL
•	JPA
•	Lombok 
•	Bean Validation 

#### CONTEINERIZAÇÃO

Não foi gerado a imagem dessa aplicação e por consequência a sua conteinerização. O Docker foi utilizado apenas para rodar a imagem do banco de dados, gerando um Container do PostgreSQL.

### 2.	PROGRAMA

#### CURRENT EQUIPMENT STATE
Retorna uma lista com o estado mais recente dos equipamentos. Seu retorno é no formato:

    [
        {
            "equipmentId": " ",
            "equipmentName": " ",
            "stateName": ,
            "stateColor": 
        },
        ...
    ]


#### CURRENT EQUIPMENT POSITION
Retorna uma lista com a posição mais recente dos equipamentos. Seu retorno é no formato:

    [
        {
            "equipmentId": " ",
            "equipmentName": " ",
            "lat": ,
            "lon": 
        },
        ...
    ]


#### CRUD

O CRUD é composto pelos métodos getAll, getById,  create, update e delete, no qual:
    
    •	GetAll: Retorna todos os objetos
        
    •	GetById: Recebe um Id como parâmetro e retorna o objeto com esse id. Caso esse objeto não exista retorna uma mensagem de erro.
        
    •	Create: Recebe uma requisição no corpo e cria um objeto com os atributos passados
        
    •	Update: Recebe como parâmetro um Id e uma requisição. O id determina qual o objeto será modificado e a requisição informa as informações para serem modificadas.
        
    •	Delete: Recebe um Id como parâmetro e deleta o objeto do banco de dados com esse Id.
Obs: Para alterar um objeto do banco de dados é necessário passar todos os atributos do objeto (Tanto os que devem ser alterados e os que devem permanecer iguais)

#### ENDPOINTS:
a)	Equipment

    GetAll: /equipment
    GetById: /equipment/{id}
    Post: /equipment
        Body:
            {
                "name": " ",
                "equipmentModelId": " "
            }
    Put: /equipment/{id}
        Body:
            {
                "name": " ",
                "equipmentModelId": " "
            }
    Delete: /equipment/{id}

b)	Equipment Model

    GetAll: /equipmentModel
    GetById: /equipmentModel /{id}
    Post: /equipmentModel
        Body:
            {
                "name": " "
            }
    Put: /equipmentModel /{id}
        Body:
            {
                "name": " "
            }
    Delete: /equipmentModel /{id}

c)	Equipment Model State Hourly Earnings

    GetAll: /equipmentModelStateHourlyEarnings
    GetById: /equipmentModelStateHourlyEarnings /{id}
    Post: /equipmentModelStateHourlyEarnings
        Body:
            {
                "value": ,
                "equipmentModelId": " ",
                "equipmentStateId": " " 
            }
    Put: /equipmentModelStateHourlyEarnings /{id}
        Body:
            {
                "value": ,
                "equipmentModelId": " ",
                "equipmentStateId": " " 
            }
    Delete: /equipmentModelStateHourlyEarnings /{id}

d)	Equipment Position History

    GetAll: / equipmentPositionHistory
    GetById: / equipmentPositionHistory/{id}
    Post: / equipmentPositionHistory
        Body:
            {
                "lat” : ,
                "lon": ,
                "equipmentId": " " 
            }
    Put: / equipmentPositionHistory/{id}
        Body:
            {
                "lat” : ,
                "lon": ,
                "equipmentId": " " 
            }
    Delete: / equipmentPositionHistory/{id}

e)	Equipment State

    GetAll: / equipmentState
    GetById: /equipmentState/{id}
    Post: /equipmentState
        Body:
            {
                "name": " "
            }
    Put: /equipmentState/{id}
        Body:
            {
                "name": " "
            }
    Delete: /equipmentState/{id}
OBS: O atributo name de Equipment State é determinado por um Enum, portanto só aceita os valores: “Operando”, “Parado” ou em “Manutenção”. A partir deste valor, é definido também a cor do Equipment State, que são: 

    •	Verde(#00FF00) para operando; 
    
    •	Amarelo(#FFFF00) para parado; 
    
    •	Vermelho(#FF0000) para manutenção.

f)	Equipment State History

    GetAll: /equipmentStateHistory
    GetById: /equipmentStateHistory/{id}
    Post: /equipmentStateHistory
        Body:
            {
                "equipmentId": " ",
                "equipmentStateId": " "
            }
    Put: /equipmentStateHistory/{id}
        Body:
            {
                "equipmentId": " ",
                "equipmentStateId": " "
            }
    Delete: /equipmentStateHistory/{id}
g)	Current Equipment Position

    GetAll: /currentEquipmentPosition

h)	Current Equipment State

    GetAll: /currentEquipmentState


###3.	CONSIDERAÇÔES FINAIS

####LINKS UTEIS
Link do Postman contendo os endpoints e requisições:
https://www.postman.com/rosanper/workspace/teste-estgio-backend-v2-aiko/collection/19670354-ae0d1f8d-d955-46f4-988d-9d0b6b043a19?action=share&creator=19670354

####RECOMENDAÇÕES FUTURAS
Fica como recomendação para melhorias futuras deste trabalho a realização de testes e a sua conteinerização.
