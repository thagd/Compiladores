# Compiladores

### Grupo
743596 - Thaís Gagliardo Dordan

### T1
#### Programas
Para utilizar o compilar da linguagem LA e suas regras léxicas, é necessário instalar os seguintes programas e suas respectivas versões:

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

Substituir pelos caminhos do seu computador:  
    ARG1 - caminho do compilador;  
    ARG2 - variável JAVA_HOME, diretório de instalação do java;  
    ARG3 - caminho do executável mvn do NetBeans.

- Executar o programa utilizando o seguinte comando:
```
java -jar /home/liven/NetBeansProjects/T1/target/T1-1.0-SNAPSHOT-jar-with-dependencies.jar /home/liven/Downloads/casos-de-teste/1.casos_teste_lexico/entrada/28-algoritmo_10-4_apostila_LA.txt /home/liven/Downloads/temp.txt
```

Substituir pelos caminhos do seu computador:  
    ARG1 - caminho executável do compilador;  
    ARG1 - arquivo de entrada;  
    ARG3 - arquivo de saída.
