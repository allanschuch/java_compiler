import java.io.*;

enum TokenType{ NUM,SOMA,MULT,SUB,DIV,APar,FPar,EOF}

class Token{
  String lexema;
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
		String naturalNumberString = "";
		boolean nextIsNumber = false;
		int currchar1;

			do{
				currchar1 = arquivo.read();  
				currchar = (char) currchar1;
				arquivo.mark(1);
				char nextChar = (char) arquivo.read();
				if(nextChar >= '0' && nextChar <= '9' && currchar >= '0' && currchar <= '9') nextIsNumber = true;
				else nextIsNumber = false;
				arquivo.reset();
				if(currchar >= '0' && currchar <= '9') naturalNumberString = naturalNumberString + currchar;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r' || nextIsNumber);

			if(currchar1 != eof && currchar1 !=10)
			{
							
	
				if (currchar >= '0' && currchar <= '9')
					return (new Token (naturalNumberString, TokenType.NUM));
				
				else
					switch (currchar){
						case '(':
							return (new Token ("" + currchar,TokenType.APar));
						case ')':
							return (new Token ("" + currchar,TokenType.FPar));
						case '+':
							return (new Token ("" + currchar,TokenType.SOMA));
						case '*':
							return (new Token ("" + currchar,TokenType.MULT));
						case '/':
							return (new Token ("" + currchar,TokenType.DIV));
						case '-':
							return (new Token ("" + currchar,TokenType.SUB));
							
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();

		return (new Token("" + currchar, TokenType.EOF));
		
	}
}
