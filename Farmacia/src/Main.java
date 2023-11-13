import java.util.ArrayList;
import java.util.Scanner;
import entities.Medicamento;
public class Main {
    static ArrayList<Medicamento> rep = new ArrayList<>();
    public static void main(String[] args) {
        int opcao = 0;
        Scanner sc =  new Scanner(System.in);
        while (opcao !=9 ) {
            System.out.println("\nSistema Farmacêutico ALL\n");
            System.out.println("Digite sua opção.");
            System.out.println("1 - Cadastrar Medicamento");
            System.out.println("2 - Consultar Medicamento");
            System.out.println("3 - Alterar Medicamento");
            System.out.println("4 - Remover Medicamento");
            System.out.println("5 - Mostrar medicamentos");

            System.out.println("9 - Sair do Sistema");
            System.out.println("Sua opção: ");
            opcao = sc.nextInt();

            switch (opcao)  {
                case 1:
                    inserirMedicamento();
                    break;
                case 2:
                    consultarMedicamento();
                    break;
                case 3:
                    alterarMedicamento();
                    break;
                case 4:
                    removerMedicamento();
                    break;
                case 5:
                    mostrarMedicamentos();
                    break;
            }
            try {     Thread.sleep(5000);  }



            catch(Exception e)  {   e.printStackTrace(); }
        }
        // encerramento do programa...
        System.out.println("Tchau...");
    }
    public static void consultarMedicamento()  {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o id do Medicamento:");
        int id = s.nextInt();
        boolean encontrado = false;
        for (Medicamento c : rep) {
            if (c.getId() == (id)) {
                System.out.println("Dados do Medicamento: ");
                System.out.println("Id do Medicamento: " + c.getId());
                System.out.println("Nome do Medicamento: " + c.getNome());
                System.out.println("Valor do Medicamento: " + c.getValor() + "R$");
                System.out.println("Quantidade em estoque:" + c.getQtd());
                System.out.println("Descrição: " + c.getDescricao());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Medicamento não localizado");
        }
    }
    public static void inserirMedicamento() {
        int id, qtd;
        String nome, descricao;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o id do Medicamento:");
        id = s.nextInt();
        System.out.println("Digite o nome do Medicamento:");
        nome = s.next();
        System.out.println("Digite o valor do Medicamento:");
        double valor = s.nextDouble();
        System.out.println("Digite a quantidade de Medicamento em estoque:");
        qtd = s.nextInt();
        System.out.println("Digite a descrição do Medicamento:");
        descricao = s.next();
        Medicamento c = new Medicamento (id, nome, valor, qtd, descricao);
        if (rep.add(c))
            System.out.println("Medicamento inserido com sucesso.");
        else
            System.out.println("O medicamento não pôde ser inserido, o repositório pode estar cheio ou esse medicamento já existe no sistema");
    }
    public static void alterarMedicamento()  {
        int id, qtd;
        String nome, descricao ;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o id do Medicamento:");
        id = s.nextInt();
        System.out.println("Digite o nome do Medicamento:");
        nome = s.next();
        System.out.println("Digite o valor do Medicamento:");
        double valor = s.nextDouble();
        System.out.println("Digite a quantidade de Medicamento em estoque:");
        qtd = s.nextInt();
        System.out.println("Digite a descrição do Medicamento:");
        descricao = s.next();
        Medicamento c = new Medicamento(id, nome, valor, qtd, descricao);
        boolean encontrado = false;
        for (int i = 0; i < rep.size(); i++) {
            Medicamento c2 = rep.get(i);
            if (c2.getId() == (id)) {
                rep.remove(i);
                rep.add(c);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Medicamento não localizado");
        }
        else
            System.out.println(" Medicamento alterado.");
    }
    public static void removerMedicamento()  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id do Medicamento:");
        int id = sc.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < rep.size(); i++) {
            Medicamento c = rep.get(i);
            if (c.getId() == (id)) {
                rep.remove(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Medicamento não localizado");
        }
        else {
            System.out.println("Medicamento removido.");
        }
    }

    public static void mostrarMedicamentos(){
        if (rep.isEmpty()) {
            System.out.println("Não há nenhum medicamento cadastrado");
        } else {
            System.out.println("Lista de médicamentos\n");
            for (Medicamento medicamento: rep){
                System.out.println("Id do Medicamento: " + medicamento.getId());
                System.out.println("Nome do Medicamento: " + medicamento.getNome());
                System.out.println("Valor do Medicamento: " + medicamento.getValor() + "R$");
                System.out.println("Quantidade em estoque: " + medicamento.getQtd());
                System.out.println("Descrição: " + medicamento.getDescricao());
                System.out.println("------------------------");
            }
        }
    }

}