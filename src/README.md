![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

## 💻 Sobre o projeto

**•**  O mapeamento das entitades foi feito tentando respeitar ao máximo as tabelas mostradas no DER.

**•**  A API foi desenvolvida seguindo um padrão de camadas, contendo as seguintes:

 `models` - onde ficam as entidades de domínio, ou seja, classes que represetam as tabelas do banco e suas relações.
 
 `repositories` - camada de acesso a dados.
 
 `services` - aqui ficam as regras de negócio, lógicas para manipulação dos dados que vieram do banco, etc.
 
 `controllers` - camada responsável por mapear e lidar com as requisições recebidas.

## ❔ Como rodar o projeto

**•** Basta clonar esta branch para sua máquina e importar o projeto na sua IDE favorita.

## 📄 Documentação

**•** Ao rodar o projeto, a documentação pode ser acessada em:

 `http://localhost:8080/docs` (JSON)
 
 `http://localhost:8080/swagger-ui.html` (HTML)
