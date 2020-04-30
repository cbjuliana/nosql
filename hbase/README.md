# hbase

### Exercício 1

#### 1. Crie a tabela com 2 famílias de colunas:  a. personal-data b. professional-data 

```
create 'italians', 'personal-data', 'professional-data'
```

#### 2. Importe o arquivo via linha de comando 

```
hbase shell /tmp/italians.txt
```
 
### Exercício 2

#### 1. Adicione mais 2 italianos mantendo adicionando informações como data de nascimento nas informações pessoais e um atributo de anos de experiência nas informações profissionais; 

```
put 'italians', '11', 'personal-data:born', '15/10/1991' 
put 'italians', '11', 'personal-data:city', 'Roma'
put 'italians', '11', 'professional-data:role', 'Computer Programmer'
put 'italians', '11', 'professional-data:salary', '2394'
put 'italians', '11', 'professional-data:years', '9'

put 'italians', '12', 'personal-data:name', 'Julio Cesar'
put 'italians', '12', 'personal-data:city', 'Roma'
put 'italians', '12', 'personal-data:born', '16/11/1992'
put 'italians', '12', 'professional-data:role', 'Computer Programmer'
put 'italians', '12', 'professional-data:salary', '2394'
put 'italians', '12', 'professional-data:years' , '8'

```

#### 2. Adicione o controle de 5 versões na tabela de dados pessoais. 

```
alter 'italians', NAME => 'personal-data', VERSIONS => 5
```

#### 3. Faça 5 alterações em um dos italianos; 

```
put 'italians', '12', 'personal-data:name', 'Julio Cesar Batista'
put 'italians', '12', 'personal-data:city', 'Veneza'
put 'italians', '12', 'professional-data:role', 'Data Scientist'
put 'italians', '12', 'professional-data:salary', '3000'
put 'italians', '12', 'professional-data:years' , '9'
```

#### 4. Com o operador get, verifique como o HBase armazenou o histórico.

```
get 'italians', '12',{COLUMN => 'personal-data:city', VERSIONS => 5}
```

#### 5. Utilize o scan para mostrar apenas o nome e profissão dos italianos.

```
scan 'italians', {COLUMNS => ['personal-data:name', 'professional-data:role']}
```

#### 6.  Apague os italianos com row id ímpar 

```
```

#### 7. Crie um contador de idade 55 para o italiano de row id 5 

```
put 'italians', '5', 'personal-data:yearsOld',  '55'
```

#### 8. Incremente a idade do italiano em 1 

```
incr 'italians', '5', 'personal-data:yearsOld'
```

### Exercício 3

#### 1. Quantidade de gatos e cachorros na amostra 

```
```

#### 2. Média de gatos e cachorros na população 

```
```

#### 3. Quantidade de pais e mães  

```
```

#### 4. Média de pais e mães  

```
```

#### 5. Média de frutas e filmes por italiano 

```
```

#### 6. Salário médio dos italianos  

```
```
 
 
