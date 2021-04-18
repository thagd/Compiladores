grammar Compras;

/*
    Declaração das regras léxicas
*/

// Regra léxica para iniciar lista de compras
COMPRAS: 'compras';

// Regra léxica para iniciar a categoria dos items da lista de compras
PADARIA: 'padaria';
ACOUGUE: 'açougue';
HORTIFRUTI: 'hortifruti';
HIGIENE: 'higiene';
LIMPEZA: 'limpeza';
BEBIDAS: 'bebidas';
ALIMENTACAO: 'alimentação';

// Regra léxica para iniciar o total da compra
TOTAL: 'total';

// Regra léxicas para iniciar números inteiros e reais utilizado para indicar o valor de cada item
NUM_INT	: ('0'..'9')+;
NUM_REAL : ('0'..'9')+ ('.' ('0'..'9')+)?;

// Regra léxica para iniciar o nome de cada item da lista de compras
CADEIA : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z' | ' ')*;

fragment
ESC_SEQ	: '\\\'';
COMENTARIO : '{' ~('\n'|'\r'|'}')* '}' {skip();};
WS : ( ' ' | '\t' | '\r' | '\n') {skip();};

// Regras léxicas para pontuações
VIRGULA: ',';
DOISPONTOS: ':';

// Regra léxica para verificação de erros
ERRO: .;

/*
    Declaração das regras sintáticas
*/

lista_compras: 'compras' lista_padaria lista_acougue lista_hortifruti lista_higiene lista_limpeza lista_bebidas lista_alimentacao total_compra <eof>;
lista_padaria: 'padaria' item+;
lista_acougue: 'açougue' item+;
lista_hortifruti: 'hortifruti' item+;
lista_higiene: 'higiene' item+;
lista_limpeza: 'limpeza' item+;
lista_bebidas: 'bebidas' item+;
lista_alimentacao: 'alimentação' item+;
total_compra: 'total' ':' valor;

item: nome ',' valor;
nome: CADEIA;
valor: NUM_INT | NUM_REAL;