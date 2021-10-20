package apppesquisa;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.regex.Pattern;
import java.util.ArrayList;

/*
* Guilherme Alves Ventura - 21395419
* Guilherme Serafim dos Santos de Lira - 21205662
* Luã Nogueira Chaves - 21476472
* Kennedy Fabio Pianoski Lima - 21467953
*/

public class AppPesquisa {
    public static void main(String[] args) {
        ArrayList<String> nome = new ArrayList<String>();
        ArrayList<String> sexo = new ArrayList<String>();
        ArrayList<String> endereco = new ArrayList<String>();
        ArrayList<String> cidade = new ArrayList<String>();
        ArrayList<String> email = new ArrayList<String>();
        ArrayList<String> telefone = new ArrayList<String>();
        ArrayList<String> idade = new ArrayList<String>();

        try {
            BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Kennedy\\OneDrive\\Documents\\UAM\\Pesquisa, Ordenação e Tecnicas de Armazenamento\\appPesquisa\\appPesquisa\\arquivoDados.csv"));
            Scanner scan1 = new Scanner(arquivo);
            System.out.println(scan1.hasNextLine());

            // enquanto não chegar ao final do arquivo
            while (scan1.hasNextLine()) {
                // leia a próxima linha do arquivo
                String linha = scan1.nextLine();

                // quebrando a linha por ","
                String[] partes = linha.split(" , ");

                nome.add(semAcento(partes[0]));
                sexo.add(semAcento(partes[1]));
                endereco.add(semAcento(partes[2]));
                cidade.add(semAcento(partes[3]));
                email.add(semAcento(partes[4]));
                telefone.add(semAcento(partes[5]));
                idade.add(semAcento(partes[6]));
            }
            scan1.close();

            while(true){
                Scanner entrada = new Scanner(System.in);
                String encontra = entrada.nextLine();

                int encontraNome = nome.indexOf(semAcento(encontra));

                System.out.println("cheguei aqui");
                if (semAcento(encontra).equals(nome)) {
                    String element = nome.get(encontraNome);
                    System.out.println("Encontrado");
                    // pesquisa nome                
                } else if(semAcento(encontra).equals("exit")){
                System.out.println("nome não encontrado");
            }
                
                entrada.close();
            }
            
        }catch (IOException ex){    
            System.out.println(ex.getMessage());
        }
    }

    public static String semAcento(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}