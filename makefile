JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Text.java \
	PopUp.java \
	Calc.java \
	Download.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
