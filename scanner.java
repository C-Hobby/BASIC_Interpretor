import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

/*Need to implement a system for recognizing numbers & letters*/

public class Lexer {
    public static String[] Keywords = {"LET", "IF", "THEN", "FOR", "TO", "NEXT", "INPUT", "PRINT", "END",
                                    "VAR", "STARTQUOTE", "ENDQUOTE", "NUM", "+", "-", "*", "/","=","$","%"};
    public static ArrayList<String> fileContent = new ArrayList<>();

    public static void main(String[] args){
        System.out.println("Please enter a valid filepath : ");
        Scanner pathScan = new Scanner(System.in);
        String filePath = pathScan.nextLine();

        String[] readTokens = readFile(filePath);

        if (readTokens[0] == "INVALID"){
            System.out.print("Cannot read filepath, terminating program...");
            System.exit(0);
        } else if(readTokens[0] == "SYNTAX ERROR") {
            System.out.print("Cannot define syntax input, terminating program...");
            System.exit(0);
        } else {
            System.out.println("Tokens scanned from input: ");
            for(int i = 0 ; i < readTokens.length ; i++){
                System.out.print(readTokens[i] + "|");
            }
            System.out.print("\nFile Content: " + fileContent);
        }

    }

    public static String[] readFile(String path){
        try{
            Scanner fileScan = new Scanner(new File(path));
            List<String> fContent = new ArrayList<>();
            String line = "";
            int counter = 0;

            while(fileScan.hasNextLine()){
                boolean vLine = true;
                line = fileScan.nextLine();
                counter++;

                for(String val : line.split(" ")){
                    for(int i = 0 ; i < Keywords.length ; i++){
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
                        }else if(val.contains("\"")){ //This is where I am getting stuck ; I don't need it to print a second STRING token in the final output, just the one
                            fContent.add("STRING");
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
                        }else if(val.contains("%")){
                            fContent.add("%");
                            break;
                        }else if(val.contains("$")){
                            fContent.add("$");
                            break;
                        } else if(val.matches(".*\\d.*")) {
                            fContent.add("NUM");
                            break;
                        } else if(val.matches("\\w+")){
                            fContent.add("VAR");
                            break;
                        }
                    }
                }
                if(vLine != true){
                    System.out.println("Syntactical Error Detected...");
                    String[] rArray = {"SYNTAX ERROR"};
                    return rArray;
                } else {
                    fileContent.add(line);
                }
            }

            fileScan.close();
            String[] rArray = fContent.toArray(new String[0]);
            return rArray;
        } catch(FileNotFoundException e){
            System.out.println("Declared filepath is not valid...");
            String[] rArray = {"INVALID"};
            return rArray;
        }

    }
}

