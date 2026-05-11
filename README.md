API REST de Produtos com Spring Boot

API REST para gerenciamento de produtos, desenvolvida com Java e Spring Boot. O projeto implementa operações completas de CRUD, validação de dados, tratamento global de exceções e documentação automática com Swagger/OpenAPI.

🚀 Tecnologias Utilizadas
Java 21
Spring Boot
Spring Web
Spring Data JPA
Hibernate
Bean Validation (@Valid)
Maven
H2 Database
Swagger/OpenAPI
Postman
Git e GitHub
📌 Funcionalidades
✅ Cadastrar produtos
✅ Listar todos os produtos
✅ Buscar produto por ID
✅ Atualizar produto
✅ Excluir produto
✅ Validar dados de entrada
✅ Evitar produtos com nomes duplicados
✅ Tratamento global de exceções
✅ Documentação interativa com Swagger
📂 Estrutura do Projeto
src/main/java/br/com/lucasitalo/produtos
├── controller
├── dto
├── entity
├── exceptions
├── repository
└── service
📡 Endpoints da API
Método	Endpoint	Descrição
POST	/produtos	Cadastra um novo produto
GET	/produtos	Lista todos os produtos
GET	/produtos/{id}	Busca um produto por ID
PUT	/produtos/{id}	Atualiza um produto existente
DELETE	/produtos/{id}	Remove um produto
📝 Exemplo de Requisição
POST /produtos
{
  "nome": "Notebook",
  "descricao": "Notebook Dell Inspiron",
  "preco": 3500.00,
  "quantidade": 10
}
📄 Exemplo de Resposta
{
  "id": 1,
  "nome": "Notebook",
  "descricao": "Notebook Dell Inspiron",
  "preco": 3500.00,
  "quantidade": 10
}
⚠️ Validações
Nome obrigatório
Descrição obrigatória
Preço obrigatório e maior que zero
Quantidade obrigatória e maior que zero
Nome do produto deve ser único
❌ Tratamento de Erros

A API retorna códigos HTTP adequados para cada situação:

400 Bad Request → Dados inválidos
404 Not Found → Produto não encontrado
409 Conflict → Produto com nome já existente
📚 Documentação Swagger

Após iniciar a aplicação, acesse:

http://localhost:8080/swagger-ui/index.html
▶️ Como Executar o Projeto
1. Clonar o repositório
git clone https://github.com/lucasitalo/api-produtos-spring-boot.git
2. Entrar no diretório
cd api-produtos-spring-boot
3. Executar a aplicação
./mvnw spring-boot:run

Ou execute a classe principal pelo IntelliJ IDEA.

🧪 Testes

Os endpoints foram testados com o Postman e também podem ser testados diretamente pelo Swagger UI.

👨‍💻 Autor

Lucas Ítalo Neres da Rocha

LinkedIn: https://www.linkedin.com/in/lucas-italo-59163822b/
GitHub: https://github.com/lucasitalo
🎯 Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de consolidar conhecimentos em Java e Spring Boot e compor meu portfólio para conquistar minha primeira oportunidade como Desenvolvedor Java Júnior.
