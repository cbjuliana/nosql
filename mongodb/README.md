# Mongodb

#### Exercício 1

Insira os seguintes registros no MongoDB e em seguida responda as questões abaixo: 

```
use petshop 
db.pets.insert({name: "Mike", species: "Hamster"}) 
db.pets.insert({name: "Dolly", species: "Peixe"}) 
db.pets.insert({name: "Kilha", species: "Gato"}) 
db.pets.insert({name: "Mike", species: "Cachorro"})
db.pets.insert({name: "Sally", species: "Cachorro"}) 
db.pets.insert({name: "Chuck", species: "Gato"})
```

1 - Adicione outro Peixe e um Hamster com nome Frodo 
#### Resposta

```
> db.pets.insert({name: "Frodo", species: "Peixe"})
WriteResult({ "nInserted" : 1 })
> db.pets.insert({name: "Frodo", species: "Hamster"})
WriteResult({ "nInserted" : 1 })
```

2 - Faça uma contagem dos pets na coleção 
#### Resposta

```
> db.pets.count()
8
```

3 - Retorne apenas um elemento o método prático possível 
#### Resposta

```
> db.pets.findOne()
{
        "_id" : ObjectId("5e96fde3a74544cacf089991"),
        "name" : "Mike",
        "species" : "Hamster"
}
```

4 - Identifique o ID para o Gato Kilha
#### Resposta

```
> db.pets.find({"name" : "Kilha", "species" : "Gato"})
{ "_id" : ObjectId("5e96fe5ca74544cacf089993"), "name" : "Kilha", "species" : "Gato" }
```

5 - Faça uma busca pelo ID e traga o Hamster Mike 
#### Resposta

```

```

6 - Use o find para trazer todos os Hamsters
#### Resposta

```
```

7 - Use o find para listar todos os pets com nome Mike 
#### Resposta

```
```

8 - Liste apenas o documento que é um Cachorro chamado Mike 
#### Resposta

```
```
