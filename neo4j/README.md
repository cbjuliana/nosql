# neo4j

#### Exercício 1 Retrieving Nodes 

#### Exercise 1.1: Retrieve all nodes from the database. 

```
MATCH (n) RETURN n
```

#### Exercise 1.2: Examine the data model for the graph.

```
call db.schema.visualization()
```

#### Exercise 1.3: Retrieve all Person nodes. 

```
MATCH (p:Person) RETURN p
```

#### Exercise 1.4: Retrieve all Movie nodes. 

```
MATCH (m:Movie) RETURN m
```

#### Exercício 2 Filtering queries using property values 

#### Exercise 2.1: Retrieve all movies that were released in a specific year. 

```
MATCH (m:Movie) WHERE m.released = 2003 RETURN m
```
ou

```
MATCH (m:Movie {released:2003}) RETURN m
```

#### Exercise 2.2: View the retrieved results as a table

```
MATCH (m:Movie {released:2003}) RETURN m
```

#### Exercise 2.3: Query the database for all property keys

```
CALL db.propertyKeys
```

#### Exercise 2.4: Retrieve all Movies released in a specific year, returning their titles

```
MATCH (m: Movie {released: 2006}) RETURN m.title
```




