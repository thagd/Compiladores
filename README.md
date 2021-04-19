# Compiladores

### T1

### Grupo

743596 - Thaís Gagliardo Dordan

#### Programas

Para utilizar o compilador da linguagem LA e suas regras léxicas, é necessário instalar os seguintes programas e suas respectivas versões:

- Java, versão 11.0.2 ou superior;
- NetBeans IDE, versão 11.2.

#### Como utilizar

Para utilizar o compilador da linguagem LA é necessário os seguintes passos:

- Fazer o download do respositório utilizando o seguinte comando:

```
git clone https://github.com/thagd/Compiladores.git
```

- Compilar o progama utilizando o seguinte comando:

```
cd /home/liven/NetBeansProjects/T1; JAVA_HOME=/usr /home/liven/netbeans-11.2/netbeans/java/maven/bin/mvn --debug install
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Substituir pelos caminhos do seu computador:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - caminho do compilador;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG2 - variável JAVA_HOME, diretório de instalação do java;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG3 - caminho do executável mvn do NetBeans.

- Executar o programa utilizando o seguinte comando:

```
java -jar /home/liven/NetBeansProjects/T1/target/T1-1.0-SNAPSHOT-jar-with-dependencies.jar /home/liven/Downloads/casos-de-teste/1.casos_teste_lexico/entrada/28-algoritmo_10-4_apostila_LA.txt /home/liven/Downloads/temp.txt
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Substituir pelos caminhos do seu computador:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - caminho executável do compilador;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - arquivo de entrada;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG3 - arquivo de saída.

### T2

### Grupo

743596 - Thaís Gagliardo Dordan  
743575 - Marcelo Riceto Bertier

#### Programas

Para utilizar o compilador da linguagem LA e suas regras léxicas e semânticas, é necessário instalar os seguintes programas e suas respectivas versões:

- Java, versão 11.0.2 ou superior;
- NetBeans IDE, versão 11.2.

#### Como utilizar

Para utilizar o compilador da linguagem LA é necessário os seguintes passos:

- Fazer o download do respositório utilizando o seguinte comando:

```
git clone https://github.com/thagd/Compiladores.git
```

- Compilar o progama utilizando o seguinte comando:

```
cd /home/liven/NetBeansProjects/T2; JAVA_HOME=/usr /home/liven/netbeans-11.2/netbeans/java/maven/bin/mvn --debug install
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Substituir pelos caminhos do seu computador:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - caminho do compilador;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG2 - variável JAVA_HOME, diretório de instalação do java;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG3 - caminho do executável mvn do NetBeans.

- Executar o programa utilizando o seguinte comando:

```
java -jar /home/liven/NetBeansProjects/T2/target/T2-1.0-SNAPSHOT-jar-with-dependencies.jar /home/liven/Downloads/casos-de-teste/1.casos_teste_lexico/entrada/28-algoritmo_10-4_apostila_LA.txt /home/liven/Downloads/temp.txt
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Substituir pelos caminhos do seu computador:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - caminho executável do compilador;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - arquivo de entrada;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG3 - arquivo de saída.

### T3

### Grupo

743596 - Thaís Gagliardo Dordan  
743575 - Marcelo Riceto Bertier

#### Programas

Para utilizar o compilador da linguagem LA e suas regras léxicas e semânticas, é necessário instalar os seguintes programas e suas respectivas versões:

- Java, versão 11.0.2 ou superior;
- NetBeans IDE, versão 11.2.

#### Como utilizar

Para utilizar o compilador da linguagem LA é necessário os seguintes passos:

- Fazer o download do respositório utilizando o seguinte comando:

```
git clone https://github.com/thagd/Compiladores.git
```

- Compilar o progama utilizando o seguinte comando:

```
cd /home/liven/NetBeansProjects/T2; JAVA_HOME=/usr /home/liven/netbeans-11.2/netbeans/java/maven/bin/mvn --debug install
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Substituir pelos caminhos do seu computador:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - caminho do compilador;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG2 - variável JAVA_HOME, diretório de instalação do java;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG3 - caminho do executável mvn do NetBeans.

- Executar o programa utilizando o seguinte comando:

```
java -jar /home/liven/NetBeansProjects/T2/target/T2-1.0-SNAPSHOT-jar-with-dependencies.jar /home/liven/Downloads/casos-de-teste/1.casos_teste_lexico/entrada/28-algoritmo_10-4_apostila_LA.txt /home/liven/Downloads/temp.txt
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Substituir pelos caminhos do seu computador:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - caminho executável do compilador;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - arquivo de entrada;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG3 - arquivo de saída.

### T4

### Grupo

743596 - Thaís Gagliardo Dordan  
743575 - Marcelo Riceto Bertier

#### Descrição da linguagem

A linguagem Compras é um modelo de uma lista de compras. Nela você pode acrescentar itens nas seguintes listas: padaria, açougue, hortifruti, higiene, limpeza, bebidas e alimentaçao. Cada item por sua vez contém uma descrição e um valor. Além disso pode-se adicionar o total da compra ao final das listas.
Temos 3 principais regras semânticas: não pode existir mais de 1 item com a mesma descrição, o campo de valor precisa ser um inteiro ou real e o total da compra deve corresponder a soma dos valores dos itens adicionados.

#### Como utilizar a linguagem

Para utilizar a linguagem compras temos que iniciar a nossa lista utilizando a palavra-chave Compras. Logo após, temos que adicionar as categorias da nossa lista, que são: padaria, açougue, hortifruti, higiene, limpeza, bebidas e alimentaçao. Dentro de cada uma dessas listas, podemos adicionar nossos itens, com nome e valor, no seguinte modelo: "nome", "valor". Ao final da nossa lista de compras, podemos adicionar o valor total da compra no seguinte modelo: total: "valor".

Segue um exemplo de como implementar a sua lista de compras:

```
compras
    padaria
        pao, 2.00
        doce, 4.00
    açougue
        frango, 5.00
    hortifruti
        alface, 2.00
    higiene
        pasta de dente, 4.00
    limpeza
        veja, 2.00
    bebidas
        cerveja, 2.00
    alimentação
        arroz, 12.00
    total: 47.00
```

#### Programas

Para utilizar o compilador da linguagem Compras e suas regras léxicas, sintáticas e semânticas, é necessário instalar os seguintes programas e suas respectivas versões:

- Java, versão 11.0.2 ou superior;
- NetBeans IDE, versão 11.2.

#### Como utilizar o compilador

Para utilizar o compilador da linguagem LA é necessário os seguintes passos:

- Fazer o download do respositório utilizando o seguinte comando:

```
git clone https://github.com/thagd/Compiladores.git
```

- Compilar o progama utilizando o seguinte comando:

```
cd /home/liven/NetBeansProjects/T2; JAVA_HOME=/usr /home/liven/netbeans-11.2/netbeans/java/maven/bin/mvn --debug install
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Substituir pelos caminhos do seu computador:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - caminho do compilador;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG2 - variável JAVA_HOME, diretório de instalação do java;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG3 - caminho do executável mvn do NetBeans.

- Executar o programa utilizando o seguinte comando:

```
java -jar /home/liven/NetBeansProjects/T2/target/T2-1.0-SNAPSHOT-jar-with-dependencies.jar /home/liven/Downloads/casos-de-teste/1.casos_teste_lexico/entrada/28-algoritmo_10-4_apostila_LA.txt /home/liven/Downloads/temp.txt
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Substituir pelos caminhos do seu computador:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - caminho executável do compilador;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG1 - arquivo de entrada;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ARG3 - arquivo de saída.
