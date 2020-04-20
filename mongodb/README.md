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
> db.pets.find({"_id" : ObjectId("5e96fde3a74544cacf089991")})
{ "_id" : ObjectId("5e96fde3a74544cacf089991"), "name" : "Mike", "species" : "Hamster" }
```

6 - Use o find para trazer todos os Hamsters
#### Resposta

```
> db.pets.find({"species" : "Hamster"})
{ "_id" : ObjectId("5e96fde3a74544cacf089991"), "name" : "Mike", "species" : "Hamster" }
{ "_id" : ObjectId("5e97092aa74544cacf089998"), "name" : "Frodo", "species" : "Hamster" }
```

7 - Use o find para listar todos os pets com nome Mike 
#### Resposta

```
> db.pets.find({"name" : "Mike"})
{ "_id" : ObjectId("5e96fde3a74544cacf089991"), "name" : "Mike", "species" : "Hamster" }
{ "_id" : ObjectId("5e96fe77a74544cacf089994"), "name" : "Mike", "species" : "Cachorro" }
```

8 - Liste apenas o documento que é um Cachorro chamado Mike 
#### Resposta

```
> db.pets.find({"name" : "Mike", "species" : "Cachorro"})
{ "_id" : ObjectId("5e96fe77a74544cacf089994"), "name" : "Mike", "species" : "Cachorro" }
```

### Exercício 2

1 - Liste/Conte todas as pessoas que tem exatamente 99 anos. Você pode usar um count para indicar a quantidade
#### Resposta

```
 db.italians.find({"age" : 99})
```

2 - Identifique quantas pessoas são elegíveis atendimento prioritário (pessoas com mais de 65 anos) 
#### Resposta

```
> db.italians.find({"age" : {"$gt" : 65}}).count()
1692
```

3 - Identifique todos os jovens (pessoas entre 12 a 18 anos)
#### Resposta

```
> db.italians.find({"age" : {"$gte" : 12, "$lte" : 18}}).count()
887
```

4 - Identifique quantas pessoas tem gatos, quantas tem cachorro e quantas não tem nenhum dos dois
#### Resposta

```

```

5 - Liste/Conte todas as pessoas acima de 60 anos que tenham gato 
#### Resposta

```

```

6 - Liste/Conte todos os jovens com cachorro 
#### Resposta

```

```

7 - Utilizando o $where, liste todas as pessoas que tem gato e cachorro 
#### Resposta

```

```

8 - Liste todas as pessoas mais novas que seus respectivos gatos
#### Resposta

```

```

9 - Liste as pessoas que tem o mesmo nome que seu bichano (gatou ou cachorro)
#### Resposta

```

```

10 - Projete apenas o nome e sobrenome das pessoas com tipo de sangue de fator RH negativo
#### Resposta

```

```

11 - Projete apenas os animais dos italianos. Devem ser listados os animais com nome e idade. Não mostre o identificado do mongo (ObjectId) 
#### Resposta

```

```

12 - Quais são as 5 pessoas mais velhas com sobrenome Rossi? 
#### Resposta

```

```

13 - Crie um italiano que tenha um leão como animal de estimação. Associe um nome e idade ao bichano 
#### Resposta

```

```

14 - Infelizmente o Leão comeu o italiano. Remova essa pessoa usando o Id
#### Resposta

```

```

15 - Passou um ano. Atualize a idade de todos os italianos e dos bichanos em 1
#### Resposta

```

```

16 - O Corona Vírus chegou na Itália e misteriosamente atingiu pessoas somente com gatos e de 66 anos. Remova esses italianos
#### Resposta

```

```

17 - Utilizando o framework agregate, liste apenas as pessoas com nomes iguais a sua respectiva mãe e que tenha gato ou cachorro
#### Resposta

```

```

18 - Utilizando aggregate framework, faça uma lista de nomes única de nomes. Faça isso usando apenas o primeiro nome 
#### Resposta

```

```

19 - Agora faça a mesma lista do item acima, considerando nome completo
#### Resposta

```

```

20 - Procure pessoas que gosta de Banana ou Maçã, tenham cachorro ou gato, mais de 20 e  menos de 60 anos
#### Resposta

```

```
