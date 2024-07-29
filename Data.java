import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Digite o dia: ");
                this.dia = sc.nextInt();
                System.out.print("Digite o mês: ");
                this.mes = sc.nextInt();
                System.out.print("Digite o ano: ");
                this.ano = sc.nextInt();
                if (validaData(this.dia, this.mes, this.ano)) {
                    valid = true;
                } else {
                    System.out.println("Data inválida, por favor, redigite.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida, por favor, redigite.");
                sc.next();
            }
        }
    }

    public Data(int d, int m, int a) {
        if (validaData(d, m, a)) {
            this.dia = d;
            this.mes = m;
            this.ano = a;
        } else {
            throw new IllegalArgumentException("Data inválida.");
        }
    }

    public void entraDia(int d) {
        if (validaData(d, this.mes, this.ano)) {
            this.dia = d;
        } else {
            throw new IllegalArgumentException("Dia inválido.");
        }
    }

    public void entraMes(int m) {
        if (validaData(this.dia, m, this.ano)) {
            this.mes = m;
        } else {
            throw new IllegalArgumentException("Mês inválido.");
        }
    }

    public void entraAno(int a) {
        if (validaData(this.dia, this.mes, a)) {
            this.ano = a;
        } else {
            throw new IllegalArgumentException("Ano inválido.");
        }
    }

    public void entraDia() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Digite o dia: ");
                int d = sc.nextInt();
                if (validaData(d, this.mes, this.ano)) {
                    this.dia = d;
                    valid = true;
                } else {
                    System.out.println("Dia inválido, por favor, redigite.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida, por favor, redigite.");
                sc.next();
            }
        }
    }

    public void entraMes() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Digite o mês: ");
                int m = sc.nextInt();
                if (validaData(this.dia, m, this.ano)) {
                    this.mes = m;
                    valid = true;
                } else {
                    System.out.println("Mês inválido, por favor, redigite.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida, por favor, redigite.");
                sc.next();
            }
        }
    }

    public void entraAno() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Digite o ano: ");
                int a = sc.nextInt();
                if (validaData(this.dia, this.mes, a)) {
                    this.ano = a;
                    valid = true;
                } else {
                    System.out.println("Ano inválido, por favor, redigite.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida, por favor, redigite.");
                sc.next();
            }
        }
    }

    public int retDia() {
        return this.dia;
    }

    public int retMes() {
        return this.mes;
    }

    public int retAno() {
        return this.ano;
    }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    public String mostra2() {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return String.format("%02d/%s/%04d", this.dia, meses[this.mes - 1], this.ano);
    }

    public boolean bissexto() {
        if ((this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0)) {
            return true;
        }
        return false;
    }

    public int diasTranscorridos() {
        int[] diasMes = {31, bissexto() ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dias = 0;
        for (int i = 0; i < this.mes - 1; i++) {
            dias += diasMes[i];
        }
        dias += this.dia;
        return dias;
    }

    public void apresentaDataAtual() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }

    private boolean validaData(int d, int m, int a) {
        if (m < 1 || m > 12) {
            return false;
        }
        int[] diasMes = {31, bissexto() ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return d > 0 && d <= diasMes[m - 1];
    }

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
