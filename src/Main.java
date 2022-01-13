import java.util.*;
import java.io.*;


public class Main {
    public static void main(String arg[]) throws FileNotFoundException {
        String input;
        String line, nota, file_output;

        //inserir o nome dos ficheiros de input
        System.out.println("Introduza o ficheiro  de leitura:");
        Scanner myObj1 = new Scanner(System.in);
        input = myObj1.nextLine();
        File file_input = new File(input);
        FileReader fr = new FileReader(file_input);
        BufferedReader entrada = new BufferedReader(fr);

        //inserir nome do ficheiro de output
        System.out.println("Introduza o ficheiro  de escrita:");
        Scanner myObj2 = new Scanner(System.in);
        file_output = myObj2.nextLine();

        try {
            do {
                line = entrada.readLine();
                if (line != null){

                    System.out.println(line); // apresentação da leitura a linha de aluno
                    //inserir a nota do aluno
                    System.out.println("Introduza a nota do aluno:");
                    Scanner myObj3 = new Scanner(System.in);
                    nota = myObj3.nextLine();

                    //invocação do metodo de escrita
                    Main escrita = new Main();
                    escrita.EscreverFicheiro(file_output,line,nota);

                }
            } while (line != null);

        } catch (IOException e) {
            System.out.println("Erro de I/O.");
            System.out.print(e);
        }

    }
    public Main(){}

    public void EscreverFicheiro(String file_output, String line, String nota){
        File f = new File(file_output);
        try {
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(line+" "+nota);
            pw.close();
        } catch(IOException ioe){
            System.out.println("IO Exception");}
    }
}
