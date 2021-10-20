package apppesquisa;
    
import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
* Guilherme Alves Ventura - 21395419
* Guilherme Serafim dos Santos de Lira - 21205662
* Luã Nogueira Chaves - 21476472
* Kennedy Fabio Pianoski Lima - 21467953
*/

public class lerArquivo {

    ArrayList<String> nome = new ArrayList<String>();
    ArrayList<String> sexo = new ArrayList<String>();
    ArrayList<String> endereco = new ArrayList<String>();
    ArrayList<String> cidade = new ArrayList<String>();
    ArrayList<String> email = new ArrayList<String>();
    ArrayList<String> telefone = new ArrayList<String>();
    ArrayList<String> idade = new ArrayList<String>();

    public lerArquivo() {
        try {
            File csv = new File(
                    "C:\\Users\\Kennedy\\OneDrive\\Documents\\UAM\\Pesquisa, Ordenação e Tecnicas de Armazenamento\\appPesquisa\\appPesquisa\\arquivoDados.csv");
            Scanner scanner = new Scanner(csv);

            if (csv.exists()) {
                System.out.println("OK!");
            }

            // enquanto não chegar ao final do arquivo
            while (scanner.hasNextLine()) {
                // leia a próxima linha do arquivo
                String linha = scanner.nextLine();
                System.out.println(linha);

                // quebrando a linha por ","
                String[] partes = linha.split(", ");

                // exibindo cada palavra
                for (int i = 0; i < partes.length; i++) {
                    System.out.print(partes[i] + " - ");
                }
                System.out.println();

            }

            scanner.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String semAcento(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}