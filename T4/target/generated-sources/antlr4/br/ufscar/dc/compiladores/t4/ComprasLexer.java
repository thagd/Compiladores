// Generated from br/ufscar/dc/compiladores/t4/Compras.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.t4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ComprasLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMPRAS=1, PADARIA=2, ACOUGUE=3, HORTIFRUTI=4, HIGIENE=5, LIMPEZA=6, BEBIDAS=7, 
		ALIMENTACAO=8, TOTAL=9, NUM_INT=10, NUM_REAL=11, CADEIA=12, COMENTARIO=13, 
		WS=14, VIRGULA=15, DOISPONTOS=16, ERRO=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMPRAS", "PADARIA", "ACOUGUE", "HORTIFRUTI", "HIGIENE", "LIMPEZA", 
			"BEBIDAS", "ALIMENTACAO", "TOTAL", "NUM_INT", "NUM_REAL", "CADEIA", "ESC_SEQ", 
			"COMENTARIO", "WS", "VIRGULA", "DOISPONTOS", "ERRO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'compras'", "'padaria'", "'a\u00E7ougue'", "'hortifruti'", "'higiene'", 
			"'limpeza'", "'bebidas'", "'alimenta\u00E7\u00E3o'", "'total'", null, 
			null, null, null, null, "','", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMPRAS", "PADARIA", "ACOUGUE", "HORTIFRUTI", "HIGIENE", "LIMPEZA", 
			"BEBIDAS", "ALIMENTACAO", "TOTAL", "NUM_INT", "NUM_REAL", "CADEIA", "COMENTARIO", 
			"WS", "VIRGULA", "DOISPONTOS", "ERRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ComprasLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Compras.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 13:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 14:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void COMENTARIO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u00a3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\6\13v\n\13\r\13\16\13"+
		"w\3\f\6\f{\n\f\r\f\16\f|\3\f\3\f\6\f\u0081\n\f\r\f\16\f\u0082\5\f\u0085"+
		"\n\f\3\r\3\r\7\r\u0089\n\r\f\r\16\r\u008c\13\r\3\16\3\16\3\16\3\17\3\17"+
		"\7\17\u0093\n\17\f\17\16\17\u0096\13\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\2\35\17\37\20!\21#\22%\23\3\2\6\4\2C\\c|\5"+
		"\2\"\"C\\c|\5\2\f\f\17\17\177\177\5\2\13\f\17\17\"\"\2\u00a7\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2"+
		"\2\2\5/\3\2\2\2\7\67\3\2\2\2\t?\3\2\2\2\13J\3\2\2\2\rR\3\2\2\2\17Z\3\2"+
		"\2\2\21b\3\2\2\2\23n\3\2\2\2\25u\3\2\2\2\27z\3\2\2\2\31\u0086\3\2\2\2"+
		"\33\u008d\3\2\2\2\35\u0090\3\2\2\2\37\u009a\3\2\2\2!\u009d\3\2\2\2#\u009f"+
		"\3\2\2\2%\u00a1\3\2\2\2\'(\7e\2\2()\7q\2\2)*\7o\2\2*+\7r\2\2+,\7t\2\2"+
		",-\7c\2\2-.\7u\2\2.\4\3\2\2\2/\60\7r\2\2\60\61\7c\2\2\61\62\7f\2\2\62"+
		"\63\7c\2\2\63\64\7t\2\2\64\65\7k\2\2\65\66\7c\2\2\66\6\3\2\2\2\678\7c"+
		"\2\289\7\u00e9\2\29:\7q\2\2:;\7w\2\2;<\7i\2\2<=\7w\2\2=>\7g\2\2>\b\3\2"+
		"\2\2?@\7j\2\2@A\7q\2\2AB\7t\2\2BC\7v\2\2CD\7k\2\2DE\7h\2\2EF\7t\2\2FG"+
		"\7w\2\2GH\7v\2\2HI\7k\2\2I\n\3\2\2\2JK\7j\2\2KL\7k\2\2LM\7i\2\2MN\7k\2"+
		"\2NO\7g\2\2OP\7p\2\2PQ\7g\2\2Q\f\3\2\2\2RS\7n\2\2ST\7k\2\2TU\7o\2\2UV"+
		"\7r\2\2VW\7g\2\2WX\7|\2\2XY\7c\2\2Y\16\3\2\2\2Z[\7d\2\2[\\\7g\2\2\\]\7"+
		"d\2\2]^\7k\2\2^_\7f\2\2_`\7c\2\2`a\7u\2\2a\20\3\2\2\2bc\7c\2\2cd\7n\2"+
		"\2de\7k\2\2ef\7o\2\2fg\7g\2\2gh\7p\2\2hi\7v\2\2ij\7c\2\2jk\7\u00e9\2\2"+
		"kl\7\u00e5\2\2lm\7q\2\2m\22\3\2\2\2no\7v\2\2op\7q\2\2pq\7v\2\2qr\7c\2"+
		"\2rs\7n\2\2s\24\3\2\2\2tv\4\62;\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2"+
		"\2\2x\26\3\2\2\2y{\4\62;\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0084"+
		"\3\2\2\2~\u0080\7\60\2\2\177\u0081\4\62;\2\u0080\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084"+
		"~\3\2\2\2\u0084\u0085\3\2\2\2\u0085\30\3\2\2\2\u0086\u008a\t\2\2\2\u0087"+
		"\u0089\t\3\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\32\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e"+
		"\7^\2\2\u008e\u008f\7)\2\2\u008f\34\3\2\2\2\u0090\u0094\7}\2\2\u0091\u0093"+
		"\n\4\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\7\177"+
		"\2\2\u0098\u0099\b\17\2\2\u0099\36\3\2\2\2\u009a\u009b\t\5\2\2\u009b\u009c"+
		"\b\20\3\2\u009c \3\2\2\2\u009d\u009e\7.\2\2\u009e\"\3\2\2\2\u009f\u00a0"+
		"\7<\2\2\u00a0$\3\2\2\2\u00a1\u00a2\13\2\2\2\u00a2&\3\2\2\2\t\2w|\u0082"+
		"\u0084\u008a\u0094\4\3\17\2\3\20\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}