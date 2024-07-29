import java.util.Scanner;

public class TesteData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            Data data = new Data(); // Solicita a entrada da data pelo usuário
            
            System.out.println("Data no formato dd/mm/aaaa: " + data.mostra1());
            System.out.println("Data no formato dd/mesPorExtenso/aaaa: " + data.mostra2());
            System.out.println("Ano bissexto: " + data.bissexto());
            System.out.println("Dias transcorridos no ano: " + data.diasTranscorridos());
            data.apresentaDataAtual();
            
            System.out.print("Deseja inserir outra data? (s/n): ");
            String resposta = sc.next();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }
    }
}
