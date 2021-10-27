//import statements
import java.util.*;
//Defining of class parser
public class Parser {
    //String array that contains all keywords relative to their respective tokens
    public static String[] keywords = new String[]{"let", "if", "then", "for_to", "next", "input", "print", "end", "plus", "minus",
                                                    "multiply", "divide", "equals", "num", "var"};
    //Method tokenize that tokenizes all strings and builds the parse tree. Parse tree provides keyword, token and value
    //associated with each token found in the test file
    public static void tokenize(ArrayList<String> fileContent, String[] readTokens){
        String[] content = fileContent.toArray(new String[0]);

        for(int i = 0 ; i < content.length; i ++){
            System.out.print("\n----------------");
            System.out.print("\n" + content[i]);
            String line = content[i];
            //for loop that parses through each token found in the input file and builds the parse tree
            for(String val : line.split(" ")) {
                for (int j = 0 ; j < readTokens.length; j++){
                    if(val.contains("LET")){
                        System.out.print("\n" + keywords[0] + "\t"+ val + "\tnull");
                        break;
                    } else if(val.contains("IF")){
                        System.out.print("\n" + keywords[1] + "\t" + val + "\tnull");
                        break;
                    } else if(val.contains("THEN")){
                        System.out.print("\n" + keywords[2] + "\t" + val + "\tnull");
                        break;
                    } else if(val.contains("FOR")){
                        System.out.print("\n" + keywords[3] + "\t"+ val + "\tnull");
                        break;
                    } else if(val.contains("TO")){
                        System.out.print("\n" + keywords[3] + "\t" + val + "\tnull");
                        break;
                    } else if(val.contains("NEXT")){
                        System.out.print("\n" + keywords[4] + "\t" + val + "\tnull");
                        break;
                    }else if(val.contains("INPUT")){
                        System.out.print("\n" + keywords[5] + "\t" + val + "\tnull");
                        break;
                    }else if(val.contains("\"")){
                        System.out.print("\n" + keywords[6] + "\tPRINT"  + "\t" + val);
                        break;
                    }else if(val.contains("END")){
                        System.out.print("\n" + keywords[7] + "\t" + val + "\tnull");
                        break;
                    }else if(val.contains("+")){
                        System.out.print("\n" + keywords[8] + "\t+" + val + "\tnull");
                        break;
                    }else if(val.contains("-")){
                        System.out.print("\n" + keywords[9] + "\t" + val + "\tnull");
                        break;
                    }else if(val.contains("*")){
                        System.out.print("\n" + keywords[10] + "\t" + val + "\tnull");
                        break;
                    }else if(val.contains("/")){
                        System.out.print("\n" + keywords[11] + "\t" + val + "\tnull");
                        break;
                    }else if(val.contains("=")){
                        System.out.print("\n" + keywords[12] + "\t" + val + "\tnull");
                        break;
                    } else if(val.matches(".*\\d.*")) {
                        System.out.print("\n" + keywords[13] + "\t" + val + "\t" + val);
                        break;
                    } else if(val.matches("[a-zA-z]")){
                        System.out.print("\n" + keywords[14] + "\t" + val + "\t" + val);
                        break;
                    }
                }
            }
        }
    }
}
