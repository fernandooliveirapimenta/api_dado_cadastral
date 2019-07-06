### Dependência
    * Java 8
    * Maven 3.5 +
    
### Arquitetura 
    * domain: classes de modelos
    * usecase: implementação das regras de negócio
    * http: api Restfull spring boot exposto na porta 8080 que liga os demais módulos.
    * db: banco de dados em memória
    
### Compilar
`mvn clean install -U`

### Rodar API
`java -jar http/target/http.jar`

### Testar
`mvn test`

#### Importar no postman
`api_dados_cadastrais.postman_collection.json`

#### Consultar Cliente
```
GET: http://localhost:8080/cliente/{cpf}
```

#### Consultar CEP
```
GET: http://localhost:8080/cep/{cep}
```

#### Consultar Estados
```
GET: http://localhost:8080/estados
```

#### Consultar Municípios
```
GET: http://localhost:8080/estados/{idEstado}/municipios
```

#### Alterar Endereço
```
PUT: http://localhost:8080/cliente/{cpf}/endereco
Body:
{
    id: "d7666sEddg888000fhhghgj",
    logradouro: "Rua Panorama",
    bairro: "Jardim Santo Eduardo"
    localidade: "Embu das Artes"
    uf: "SP"
    cep: "06823-250"
    numero: "203"
}
```

#### HTTP Trace
```
GET: http://localhost:8080/actuator/httptrace
```
