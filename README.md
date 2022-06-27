# **EquipmentAPI**
O sistema dispõe de um CRUD para cada tabela de dados com algumas pesquisas de histórico de estados e histórico de posição dos equimapentos. A documentação da API é disponibilizada através do Swagger incluído na mesma.

## **Informações do sistema**
- C#
- .NET Core 5.0
- Tiles 2.2
- EntityFrameworkCore

###### Estrutura de diretórios
- **Controllers** _Controllers da API_
- **Data** _Contexto_
    - **Interfaces** _Interfaces dos repositórios utilizados no projeto_
    - **Repositories** _Repositórios do projeto_
- **Dtos** _Controllers da API_
    - **CreateDtos** _Dtos com informações necessárias criação de objetos_
    - **DeleteDtos** _Dtos com informações necessárias para deletar objetos_
    - **ReadDtos** _Dtos com informações necessárias para mostrar durante as consultas da API_
- **Entities** _Entidades utilizadas no projeto_
- **Helpers** _Profile para mapeamento dos objetos para seus respectivos DTOs_
   
###### Funcionalidades
- [x] Adicionar, remover, atualizar e consultar: equipamentos, modelos, estados e localização;
- [x] Consultar histórico de posições dos equipamentos;
- [x] Consultar histórico de estados dos equipamentos;
