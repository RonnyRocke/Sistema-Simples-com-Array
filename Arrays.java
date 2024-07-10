import java.util.Scanner;

public class Arrays {
    int opcao;
    int[] notas = new int[4];
    int soma;
    double media; // A média deve ser um double para valores decimais

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays a = new Arrays();

        boolean menu = true;
        while (menu) { // Menu principal
            System.out.println("****************************");
            System.out.println("Bem-Vindo Ao Sistema De Login!");
            System.out.println("Autor: Ronny Rocke");
            System.out.println("Date: 09/07/24");
            System.out.println("****************************");
            System.out.println("1: INICIAR");
            System.out.println("2: SAIR");
            System.out.print("Digite Uma Opção: ");
            a.opcao = sc.nextInt();
            System.out.println("****************************");

            switch (a.opcao) { // Seleção de opção do menu principal
                case 1:
                    System.out.print("Digite Seu Login: ");
                    String login = sc.next();
                    System.out.print("Digite Sua Senha: ");
                    int senha = sc.nextInt();
                    boolean logado = login.equals("admin") && senha == 123456;

                    if (logado) { // Verificação de login
                        System.out.println("VOCÊ LOGOU NO SISTEMA!");
                        System.out.println("**********************");
                        boolean menu2 = true;

                        while (menu2) { // Menu de opções após login
                            System.out.println("  ");
                            System.out.println("1: Adicionar Notas");
                            System.out.println("2: Ver Notas");
                            System.out.println("3: Ver Média");
                            System.out.println("4: Voltar");

                            System.out.print("Digite Uma Opção: ");
                            int selecionar = sc.nextInt();

                            switch (selecionar) { // Seleção de opção do menu de notas
                                case 1:
                                    a.soma = 0; // Resetar soma para evitar soma acumulada
                                    for (int i = 0; i < a.notas.length; i++) { // Corrigido índice do for
                                        System.out.println(" ");
                                        System.out.print("Digite a Nota do " + (i + 1) + "° Bimestre: ");
                                        a.notas[i] = sc.nextInt();
                                        a.soma += a.notas[i]; // Acumular soma das notas
                                    }
                                    a.media = (double) a.soma / a.notas.length; // Calcular média corretamente
                                    System.out.println(" ");
                                    System.out.println("Sua Média foi de: " + a.media);

                                    if (a.media >= 6 && a.media <= 10) { // Verificação da média
                                        System.out.println("Você Foi Aprovado!");
                                    } else {
                                        System.out.println("Você Foi Reprovado!");
                                    }
                                    break;

                                case 2:
                                    System.out.println("************************");
                                    for (int i = 0; i < a.notas.length; i++) { // Imprimir notas
                                        System.out.println("Sua Nota No " + (i + 1) + "° Bimestre foi: " + a.notas[i]);
                                    }
                                    System.out.println("************************");
                                    break;

                                case 3:
                                   
                                    System.out.println("SUA MÉDIA TOTAL É DE: " + a.media);
                                    if (a.media >= 6 && a.media <= 10) { // Verificação da média
                                        System.out.println("Você Foi Aprovado!");
                                    } else {
                                        System.out.println("Você Foi Reprovado!!");
                                    }
                                    break;

                                case 4:
                                    menu2 = false; // Sair do menu de notas
                                    break;

                                default:
                                    System.out.println("Opção Inválida!");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Login Ou Senha Inválido!");
                    }
                    break;

                case 2:
                    System.out.println("Você Saiu!");
                    menu = false; // Sair do menu principal
                    break;

                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
        sc.close();
    }
}
