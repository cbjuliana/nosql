# Mongodb

### Exercício 1

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
> db.italians.find( {cat: { $exists: true }}).count()
5962

> db.italians.find( {dog: { $exists: true }}).count()
3970

> db.italians.find( {
... $and: [
... { cat: { $exists: false }},
... { dog: { $exists: false }}
... ]
... }).count()
2451
```

5 - Liste/Conte todas as pessoas acima de 60 anos que tenham gato 
#### Resposta

```
> db.italians.find({
... "age" : {"$gt" : 60},
... cat : { $exists: true }
... }).count()
1009
```

6 - Liste/Conte todos os jovens com cachorro 
#### Resposta

```
> db.italians.find({
... "age" : {"$gte" : 15, "$lte" : 29},
...  dog : { $exists: true }
... }).count()
736
```

7 - Utilizando o $where, liste todas as pessoas que tem gato e cachorro 
#### Resposta

```
db.italians.find( { 
	$and: [ 
		{ cat: { $exists: true }}, 
		{ dog: { $exists: true }}
	] 
}).count()
2383
```

8 - Liste todas as pessoas mais novas que seus respectivos gatos
#### Resposta

```

```

9 - Liste as pessoas que tem o mesmo nome que seu bichano (gato ou cachorro)
#### Resposta

```
db.italians.find({
  $or:[{$and: [{ cat: { $exists: true }}, { $where: "this.firstname == this.cat.name" }]}, 
       {$and: [{ dog: { $exists: true }}, { $where: "this.firstname == this.dog.name" }]}
  ]
}, 
{"cat.name": 1, "dog.name": 1, "firstname": 1})
```

10 - Projete apenas o nome e sobrenome das pessoas com tipo de sangue de fator RH negativo
#### Resposta

```
db.italians.find({bloodType: /-/}, {"firstname": 1, "surname": 1})
```

11 - Projete apenas os animais dos italianos. Devem ser listados os animais com nome e idade. Não mostre o identificado do mongo (ObjectId) 
#### Resposta

```
db.italians.find({
  $or:[{$and: [{ cat: { $exists: true }}] }, 
       {$and: [{ dog: { $exists: true }}] }
  ]
}, 
{"_id": 0, "cat.name": 1, "dog.name": 1})
```

12 - Quais são as 5 pessoas mais velhas com sobrenome Rossi? 
#### Resposta

```
db.italians.find({"surname" : "Rossi"}).sort({age : -1}).limit(5) 
```

13 - Crie um italiano que tenha um leão como animal de estimação. Associe um nome e idade ao bichano 
#### Resposta

```
> db.italians.insert({"firstname" : "Giuseppe", "surname" : "Garibaldi", "username" : "user9995", "age" : 28, "email" : "garibaldi@gmail.com", "bloodType" : "A+", "id_num" : "468313016241", "registerDate" : ISODate("1991-03-02T14:45:02.059Z"), "ticketNumber" : 2285, "jobs" : [ "Advogado" ], "favFruits" : [ "Morango" ], "movies" : [ { "title" : "Star Wars, Episódio V: O Império Contra-Ataca (1980)", "rating" : 3.28 }, { "title" : "A Lista de Schindler (1993)", "rating" : 0.82 } ], "father" : { "firstname" : "Francesco", "surname" : "Garibaldi", "age" : 60 }, "leao" : { "name" : "Simba", "age" : 2 } })
WriteResult({ "nInserted" : 1 })
```

14 - Infelizmente o Leão comeu o italiano. Remova essa pessoa usando o Id
#### Resposta

```
> db.italians.remove({"_id" : ObjectId("5ea72fbc3b71967e96beb313")}, true)
WriteResult({ "nRemoved" : 1 })
```

15 - Passou um ano. Atualize a idade de todos os italianos e dos bichanos em 1
#### Resposta

```
> db.italians.update({}, {"$inc": {"age": 1}}, {multi: true});
WriteResult({ "nMatched" : 10001, "nUpserted" : 0, "nModified" : 10001 })
> db.italians.update({}, {"$inc": {"cat.age": 1}}, {multi: true});
WriteResult({ "nMatched" : 10001, "nUpserted" : 0, "nModified" : 10001 })
> db.italians.update({}, {"$inc": {"dog.age": 1}}, {multi: true});
WriteResult({ "nMatched" : 10001, "nUpserted" : 0, "nModified" : 10001 })
```

16 - O Corona Vírus chegou na Itália e misteriosamente atingiu pessoas somente com gatos e de 66 anos. Remova esses italianos
#### Resposta

```
db.italians.remove({
...   age : 66,
...   cat : { $exists: true }
...  }, true)
WriteResult({ "nRemoved" : 1 })
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

### Exercício 3 - Stockbrokers 

1 - Liste as ações com profit acima de 0.5 (limite a 10 o resultado) 
#### Resposta

```
db.stocks.find({
 "Profit Margin" : {"$gte" : 0.5}
}).limit(10)
```

2 - Liste as ações com perdas (limite a 10 novamente) 
#### Resposta

```

```

3 - Liste as 10 ações mais rentáveis 
#### Resposta

```
> db.stocks.find({}, {Ticker : 1, _id : 0}).sort({"Profit Margin" : -1}).limit(10)
{ "Ticker" : "BPT" }
{ "Ticker" : "CACB" }
{ "Ticker" : "ROYT" }
{ "Ticker" : "NDRO" }
{ "Ticker" : "WHZ" }
{ "Ticker" : "MVO" }
{ "Ticker" : "AGNC" }
{ "Ticker" : "VOC" }
{ "Ticker" : "MTR" }
{ "Ticker" : "OLP" }
```

4 - Qual foi o setor mais rentável? 
#### Resposta

```
> db.stocks.find({}, {Industry : 1, _id : 0}).sort({"Profit Margin" : -1}).limit(1)
{ "Industry" : "Oil & Gas Refining & Marketing" }
```

5 - Ordene as ações pelo profit e usando um cursor, liste as ações. 
#### Resposta

```

```

6 - Renomeie o campo “Profit Margin” para apenas “profit”. 
#### Resposta

```

```

7 - Agora liste apenas a empresa e seu respectivo resultado 
#### Resposta

```
db.stocks.find({}, {Company : 1, "Profit Margin" : 1, _id : 0})
```

8 - Analise as ações. É uma bola de cristal na sua mão... Quais as três ações você investiria? 
#### Resposta

```
BPT, CACB e ROYT
```

9 - Liste as ações agrupadas por setor 
#### Resposta

```

```

### Exercício 3 - Fraude na Enron! 

1 - Liste as pessoas que enviaram e-mails (de forma distinta, ou seja, sem repetir). Quantas pessoas são? 
#### Resposta

```
> db.enron.distinct('sender').length
2200
```

2 - Contabilize quantos e-mails tem a palavra “fraud” 
#### Resposta

```
> db.enron.find({text: /fraud/}).count()
23
```

