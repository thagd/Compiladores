lexer grammar LALexer;

// Regra léxica para iniciar o algoritmo
ALGORITMO: 'algoritmo';
FIMALGORITMO: 'fim_algoritmo';

// Regra léxica para declarar variáveis
DECLARE: 'declare';

// Rega léxica para realizar a leitura de variáveis
LEIA: 'leia';

// Regra léxica para printar
ESCREVA: 'escreva';

// Regras léxicas para descrever o tipo da variável
LITERAL: 'literal';
INTEIRO: 'inteiro';
REAL: 'real';
LOGICO: 'logico';
CONSTANTE: 'constante';
VAR: 'var';

// Regra léxica para iniciar uma função
FUNCAO: 'funcao';
FIMFUNCAO: 'fim_funcao';

// Regra lexica para retornar um valor
RETORNE: 'retorne';

// Regras léxicas para determinar a relação de um ou mais casos
E: 'e';
OU: 'ou';

TIPO: 'tipo';

// Regra léxica para iniciar um registro
REGISTRO: 'registro';
FIMREGISTRO: 'fim_registro';

// Regra léxica para iniciar um procedimento
PROCEDIMENTO: 'procedimento';
FIMPROCEDIMENTO: 'fim_procedimento';

// Regra léxica para verificar se uma sentença é falsa ou verdadeira
FALSO: 'falso';
VERDADEIRO: 'verdadeiro';

// Regra léxica para especificar um bloco de código a ser executado, se uma condição especificada for verdadeira
SE: 'se';
ENTAO: 'entao';
// Regra léxica para especificar um bloco de código a ser executado, se a mesma condição for falsa
SENAO: 'senao';
FIMSE: 'fim_se';

// Regra léxica para especificar um bloco de código a ser executado, se a condição for igual a um dos items da lista de selação
CASO: 'caso';
SEJA: 'seja';
FIMCASO: 'fim_caso';

// Regra léxica para realizar uma repetição e é usado quando se sabe quantas vezes o conjunto de comandos vai ser repetido
PARA: 'para';
ATE: 'ate';
FACA: 'faca';
FIMPARA: 'fim_para';

// Regra léxica para realizar uma repetição até uma condição ser avaliada como falsa
ENQUANTO: 'enquanto';
FIMENQUANTO: 'fim_enquanto';

// Regra léxica para pegar a resposta inversa de uma condição
NAO: 'nao';

// Regra léxica para realizar a atribuição de um valor para uma variável
ATRIBUICAO: '<-';

// Regra léxicas para iniciar números inteiros e reais
NUM_INT	: ('0'..'9')+;
NUM_REAL : ('0'..'9')+ ('.' ('0'..'9')+)?;

// Regra léxica para iniciar variáveis
IDENT : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

// Regra léxica para iniciar strings
CADEIA : '"' ( ~('\n') )*? '"';

fragment
ESC_SEQ	: '\\\'';
COMENTARIO : '{' ~('\n'|'\r'|'}')* '}' {skip();};
WS : ( ' ' | '\t' | '\r' | '\n') {skip();};

// Regras léxicas para realizar desigualdades
MAIOR: '>';
MENOR: '<';
MAIORIGUAL: '>=';
MENORIGUAL: '<=';
IGUAL: '=';
DIFERENCA: '<>';

// Regras léxicas para realizar operações
SOMA: '+';
SUBTRACAO: '-';
DIVISAO: '/';
MULTIPLICACAO: '*';
EXPONENCIAL: '^';
PORCENTAGEM: '%';

// Regra léxica para atribuir um intervalo
INTERVALO: '..';

// Regras léxicas para pontuações
VIRGULA: ',';
PONTO: '.';
DOISPONTOS: ':';
ABREPAR : '(';
FECHAPAR : ')';
ABRECOL: '[';
FECHACOL: ']';

// Regra léxima para determinar o endereço de uma variável
REFERENCIA: '&';

// Regras léxicas para verificação de erros
COMENT_ERRADO: '{' ~('}');
LITERAL_ERRADO: '"' ~('"');
ERRO: .;