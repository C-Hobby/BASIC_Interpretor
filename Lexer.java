//Import statements
import java.util.*;
import java.io.*;
//Defining of class lexer
public class Lexer {
    //array that defines types of valid tokens
    public static String[] Tokens = {"LET", "IF", "THEN", "FOR", "TO", "NEXT", "INPUT", "PRINT", "END",
                                        "+", "-", "*", "/","="};
    //array list that will hold tokens read from the scanner
    public static ArrayList<String> fileContent = new ArrayList<>();
    //main method
    public static void main(String[] args){
        //prompt user input, reads the file path
        System.out.println("Please enter a valid filepath : ");
        Scanner pathScan = new Scanner(System.in);
        String filePath = pathScan.nextLine();
        //call method readFile to read the document and pull tokens from said document
        String[] readTokens = readFile(filePath);
        //if statement that reacts on a valid file path. If file path is not valid, program terminates, else it progresses
        if (readTokens[0] == "INVALID"){
            System.out.print("Cannot read filepath, terminating program...");
            System.exit(0);
        } else {
            //prints each of the tokens found by the scanner, and then makes a call to the parser to build the parse tree
            System.out.println("Tokens scanned from input: ");
            for(int i = 0 ; i < readTokens.length ; i++){
                System.out.print(readTokens[i] + "|");
            }
            System.out.print("\n----Will Now Begin Parsing----");
            Parser.tokenize(fileContent, readTokens);
        }

    }
    //method readFile that extracts a valid file path and scans through the document to pull all valid tokens
    public static String[] readFile(String path){
        try{
            //declaration of file scanner and new array list to hold the found tokens
            Scanner fileScan = new Scanner(new File(path));
            List<String> fContent = new ArrayList<>();
            String line = "";

            while(fileScan.hasNextLine()){
                line = fileScan.nextLine();
                //for loop that checks for each token case and stores them in the fContent array
                for(String val : line.split(" ")){
                    for(int i = 0 ; i < Tokens.length ; i++){
                        if(val.contains("LET")){
                            fContent.add("LET");
                            break;
                        } else if(val.contains("IF")){
                            fContent.add("LET");
                            break;
                        } else if(val.contains("THEN")){
                            fContent.add("THEN");
                            break;
                        } else if(val.contains("FOR")){
                            fContent.add("FOR");
                            break;
                        } else if(val.contains("TO")){
                            fContent.add("TO");
                            break;
                        } else if(val.contains("NEXT")){
                            fContent.add("NEXT");
                            break;
                        }else if(val.contains("INPUT")){
                            fContent.add("INPUT");
                            break;
                        }else if(val.contains("PRINT")){
                            fContent.add("PRINT");
                            break;
                        }else if(val.contains("END")){
                            fContent.add("END");
                            break;
                        }else if(val.contains("+")){
                            fContent.add("+");
                            break;
                        }else if(val.contains("-")){
                            fContent.add("-");
                            break;
                        }else if(val.contains("*")){
                            fContent.add("*");
                            break;
                        }else if(val.contains("/")){
                            fContent.add("/");
                            break;
                        }else if(val.contains("=")){
                            fContent.add("=");
                            break;
                        } else if(val.matches(".*\\d.*")) {
                            fContent.add(val);
                            break;
                        } else if(val.matches("\\w+")){
                            fContent.add(val);
                            break;
                        }
                    }
                }
                    fileContent.add(line);
            }
            //returns rArray that contains all tokens now in a string array
            fileScan.close();
            String[] rArray = fContent.toArray(new String[0]);
            return rArray;
            //catch for FileNotFoundException
        } catch(FileNotFoundException e){
            System.out.println("Declared filepath is not valid...");
            String[] rArray = {"INVALID"};
            return rArray;
        }

    }
}

