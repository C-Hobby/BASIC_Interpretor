import java.util.*;
import java.io.*;


public class Lexer {
    public static String[] Tokens = {"LET", "IF", "THEN", "FOR", "TO", "NEXT", "INPUT", "PRINT", "END",
                                        "+", "-", "*", "/","="};
    public static ArrayList<String> fileContent = new ArrayList<>();

    public static void main(String[] args){
        System.out.println("Please enter a valid filepath : ");
        Scanner pathScan = new Scanner(System.in);
        String filePath = pathScan.nextLine();

        String[] readTokens = readFile(filePath);

        if (readTokens[0] == "INVALID"){
            System.out.print("Cannot read filepath, terminating program...");
            System.exit(0);
        } else {
            System.out.println("Tokens scanned from input: ");
            for(int i = 0 ; i < readTokens.length ; i++){
                System.out.print(readTokens[i] + "|");
            }
            System.out.print("\n----Will Now Begin Parsing----");
            Parser.tokenize(fileContent, readTokens);
        }

    }

    public static String[] readFile(String path){
        try{
            Scanner fileScan = new Scanner(new File(path));
            List<String> fContent = new ArrayList<>();
            String line = "";

            while(fileScan.hasNextLine()){
                line = fileScan.nextLine();

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

