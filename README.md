# desafio-cielo

Para rodar a aplicação é necessário subir um banco PostgreSQL com o docker:

docker run --name bootcamp-cielo -e POSTGRES_USER=dev -e POSTGRES_PASSWORD=dev -e POSTGRES_DB=clientes -p 5432:5432 --restart always -d postgres

Criar um banco com o nome clientes

Executar a aplicação

Para executar as funcionalidades basta acessar o Swagger: 
http://localhost:8080/swagger-ui/index.html