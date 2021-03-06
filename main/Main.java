// for testing
package main;

import java.util.*;
import java.io.*;
import lexer.*;
//import parser.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Lexer lex = new Lexer();
    
    System.out.println("start...");
    ArrayList<ArrayList<Tag> > tokens = new ArrayList<ArrayList<Tag> >();
    tokens.add(new ArrayList<Tag>());
    Token tok = lex.scan(); // temporary block is used to test earlier states
    do {
      if (tok.tag == Tag.NEW_LINE)
        tokens.add(new ArrayList<Tag>());
      else
        tokens.get(tokens.size() - 1).add(tok.tag);
      tok = lex.scan();
    } while (tok.tag != Tag.EOF);
    
    for(ArrayList<Tag> t: tokens)
      System.out.println(t);
    
    //Parser parse = new Parser(lex);
    //parse.program();
    System.out.println();
  }
}
