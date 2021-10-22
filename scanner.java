import java.util.*; //General import statements
import java.io.*;

public class scanner { //implement main class scanner
    public static void main(String[] args) throws FileNotFoundException { //main method, throws filenotfoundexception
        File input = new File("C:/Users/chand/OneDrive/Documents/CPL_test.txt"); //Input file designation, includes sample
        Scanner scan = new Scanner(input); //Scanner definition and implementation

        String[] key = new String[] {"LET", "IF", "THEN", "FOR", "TO", "NEXT", "GOTO", "INPUT"}; //Array of keywords and identifiers
        String[] ident = new String[] {"let", "var", "letter", "num", "if_then", "for_to", "go_to", "input_source", "output_source", "sentence", "word", "expr", "num_expr", "test_expr"};

        while(scan.hasNextLine()){ //While loop to parse through input file
            String line = scan.nextLine(); //String variable to gather strings from input file

            for(String val: line.split(" ")){ //For loop that parses through strings and breaks at whitespaces
                for(int i = 0 ; i < key.length ; i++){ //For loop that parses through keyword array to check for mathching tokens
                    if(val.contains(key[i])){ //if statement for validation of matching tokens
                        System.out.println("Token Scanned: " + val); //print tokens that match
                    }
                }
            }
        }
    }
}

