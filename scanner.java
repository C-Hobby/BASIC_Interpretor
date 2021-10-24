import java.util.*; //General import statements
import java.io.*;

public class scanner { //implement main class scanner
    public static void main(String[] args) throws FileNotFoundException { //main method, throws filenotfoundexception
        File input = new File("C:\\Users\\chand\\IdeaProjects\\CPL_scanner\\src\\CPL_test"); //Input file designation, includes sample
        Scanner scan = new Scanner(input); //Scanner definition and implementation

        String[] key = new String[] {"LET", "IF_THEN", "FOR_TO", "NEXT", "GOTO", "INPUT", "PRINT", "END"}; //Array of keywords and identifiers
        ArrayList<String> tokens = new ArrayList<>();

        while(scan.hasNextLine()){ //While loop to parse through input file
            String line = scan.nextLine(); //String variable to gather strings from input file

            for(String val: line.split(" ")){ //For loop that parses through strings and breaks at whitespaces
                for(int i = 0 ; i < key.length ; i++){ //For loop that parses through keyword array to check for matching tokens
                    if (val.contains("LET")){
                        tokens.add("LET");
                        break;
                    } else if(val.contains("IF")){
                        tokens.add("IF_THEN");
                        break;
                    } else if(val.contains("FOR")){
                        tokens.add("FOR_TO");
                        break;
                    } else if(val.contains("NEXT")){
                        tokens.add("NEXT");
                        break;
                    } else if(val.contains("GO")){
                        tokens.add("GOTO");
                        break;
                    } else if(val.contains("INPUT")){
                        tokens.add("INPUT");
                        break;
                    } else if(val.contains("PRINT")){
                        tokens.add("PRINT");
                        break;
                    } else if(val.contains("END")){
                        tokens.add("END");
                        break;
                    }
                }
            }
        }

        System.out.print("Tokens scanned are: " + tokens);
    }
}

