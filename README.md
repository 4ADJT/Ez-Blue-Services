# Ez-Blue - The Blue Zone Easy
## Ez-Blue-Services

Ez-Blue-Services é um microserviço que gerência as informações de localização e tarifas de estacionamento no sistema de parquímetro.

## Intenção

O objetivo deste serviço é fornecer APIs para gerenciar localidades e tarifas de estacionamento, incluindo operações de criação, leitura, atualização e exclusão (CRUD).

## Como executar

### Requisitos

- JDK 17+
- Maven 3.6.3+
- Docker (opcional para execução com Docker)

## Executar localmente

1. Clone o repositório:
```sh
git clone https://github.com/4ADJT/Ez-Blue-Services.git
cd Ez-Blue-Services
```

2. Compile e execute o projeto
```sh
mvn clean package
mvn spring-boot:run
```
## Executar com Docker

1. Compile o projeto e crie a imagem Docker:
```sh
docker build -t ez-blue-services .
```

2. Execute o container:
```sh
docker run -p 8081:8081 ez-blue-services
```

## Configuração
A configuração do Ez-Blue-Services pode ser encontrada no arquivo application.properties na pasta src/main/resources.