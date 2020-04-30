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
```

#### 3. Faça 5 alterações em um dos italianos; 

```
```

#### 4. Com o operador get, verifique como o HBase armazenou o histórico.

```
```

#### 5. Utilize o scan para mostrar apenas o nome e profissão dos italianos.

```
```

#### 6.  Apague os italianos com row id ímpar 

```
```

#### 7. Crie um contador de idade 55 para o italiano de row id 5 

```
```

#### 8. Incremente a idade do italiano em 1 

```
```
 
 
