


class: Cubex*.java TokenTranslationListener.java MyTokenStreamRewriter.java
	javac $^

jar: *.class *.java *.g4 MANIFEST.MF
	jar cvfm Lexer.jar MANIFEST.MF *.class *.java *.g4

.PHONY: class jar
