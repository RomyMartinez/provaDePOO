import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Jogador p1 = new Jogador(null, 50, 2, 10, 2);
        int escolha;

        System.out.print("Jogo iniciado!\n-------------------\n");

        //Escolha do nome do personagem
        System.out.print("Digite o nome do personagem: ");
        String nome = scanner.nextLine();
        p1.setNome(nome);
        p1.mostarDados();
        System.out.println("-------------------");
        
        //Escolha da arma
        escolhaArma(p1, scanner);
        continuar(scanner);

        //Escolha do caminho
        System.out.print("Escolha o seu caminho direita ou esquerda: ");
        System.out.print("\n1 - Direita\n2 - Esquerda\n");
        escolha = scanner.nextInt();
        limparTerminal();
        
        if (escolha == 1) {
            //Direita
            System.out.print("Caminho da direita escolhido");
            System.out.print("\n-------------------\n");
            
            //Gerar inimigo e combate
            Inimigo inimigo = Inimigo.gerarInimigo(false);
            gerarCombate(inimigo, p1, scanner);

            //Verificar se o jogador perdeu ou ganhou
            if (p1.getVida() <= 0) {
                System.out.print("Você perdeu!\n");
            } else if (inimigo.getVida() <= 0) {
                //Se o jogador ganhar, ele ganha uma maçã e enfrenta o chefe
                System.out.print(inimigo.getNome() + " derrotado!\n");
                System.out.print("Você ganhou uma maçã!");
                p1.setMaca(new Maca(p1));
                System.out.print("\n-------------------\n");
                continuar(scanner);
                
                //Combate com o chefe
                Chefe chefe = (Chefe) Inimigo.gerarInimigo(true);
                gerarCombate(chefe, p1, scanner);

                //Verificar se o jogador perdeu ou ganhou
                if (p1.getVida() <= 0) {
                    System.out.print("Você perdeu!\n");
                } else if (chefe.getVida() <= 0) {
                    System.out.print("Você venceu o jogo!\n");
                }
            }     
        } else if (escolha == 2) {
            //Esquerda
            System.out.print("Caminho da esquerda escolhido");
            System.out.print("\n-------------------\n");
            
            //Gerar chefe e combate
            Inimigo inimigo = Inimigo.gerarInimigo(false);
            gerarCombate(inimigo, p1, scanner);
            
            //Verificar se o jogador perdeu ou ganhou
            if (p1.getVida() <= 0) {
                System.out.print("Você perdeu!\n");
            } else if (inimigo.getVida() <= 0) {
                System.out.print(inimigo.getNome() + " derrotado!\n");
                inimigo = Inimigo.gerarInimigo(false);
                System.out.print("1- Enfrentar o chefe\n2- " + inimigo.getNome() + " para ganhar um objeto\n");
                escolha = scanner.nextInt();
                if (escolha == 1) {
                    //Combate com o chefe
                    Chefe chefe = (Chefe) Inimigo.gerarInimigo(true);
                    gerarCombate(chefe, p1, scanner);
                    //Verificar se o jogador perdeu ou ganhou
                    if (p1.getVida() <= 0) {
                        System.out.print("Você perdeu!\n");
                    } else if (chefe.getVida() <= 0) {
                        System.out.print("Você venceu o jogo!\n");
                    }
                } else if (escolha == 2) {
                    //Combate com inimigo para ganhar um objeto
                    gerarCombate(inimigo, p1, scanner);
                    //Verificar se o jogador perdeu ou ganhou
                    if (p1.getVida() <= 0) {
                        System.out.print("Você perdeu!\n");
                    } else if (inimigo.getVida() <= 0) {
                        System.out.print(inimigo.getNome() + " derrotado!\n");
                        System.out.print("Você ganhou uma maçã!");
                        p1.setMaca(new Maca(p1));
                        System.out.print("\n-------------------\n");
                        continuar(scanner);
                        //Combate com o chefe
                        Chefe chefe = (Chefe) Inimigo.gerarInimigo(true);
                        gerarCombate(chefe, p1, scanner);
                        //Verificar se o jogador perdeu ou ganhou
                        if (p1.getVida() <= 0) {
                            System.out.print("Você perdeu!\n");
                        } else if (chefe.getVida() <= 0) {
                            System.out.print("Você venceu o jogo!\n");
                        }
                    }
                }
            }
        }
    }

    //Função para limpar o terminal e continuar
    
    private static void continuar(Scanner scanner) {
        @SuppressWarnings("unused")
        String continuar = "";
        scanner.nextLine();
        System.out.print("Enter para continuar ");
        continuar = scanner.nextLine();
        limparTerminal();
    }

    //Função para gerar inimigo
    

    //Função para gerar combate
    public static void gerarCombate(Inimigo inimigo, Jogador p1, Scanner scanner){
        //Informar sobre o inimigo
        int escolha;
        System.out.print(inimigo.getNome() +" encontrado!\n");
        inimigo.mostarDados();
        System.out.print("-------------------\n");
        continuar(scanner);

        //Combate
        while (p1.getVida() > 0 && inimigo.getVida() > 0) {
                System.out.print("Escolha sua ação: ");
                //Verificar se o jogador tem Arco ou Maca, ou ambos
                if(p1.getArma() instanceof Arco && p1.getMaca() == null){
                    System.out.print("\n1 - Atacar (flechas: " + p1.getFlecha()  + ")\n2 - Curar\n3 - Ataque especial ("+ p1.getQntEspecial()+")\n");
                    escolha = scanner.nextInt();
                    p1.acao(inimigo, escolha);
                    inimigo.acao(p1, escolha);
                } else if (p1.getMaca() == null){
                    System.out.print("\n1 - Atacar\n2 - Curar\n3 - Ataque especial("+ p1.getQntEspecial()+")\n");
                    escolha = scanner.nextInt();
                    p1.acao(inimigo, escolha);
                    inimigo.acao(p1, escolha);
                } else if (p1.getUsosDisponiveis() > 0 && p1.getArma() instanceof Arco){
                    System.out.print("\n1 - Atacar (flechas: " + p1.getFlecha()  + ")\n2 - Curar\n3 - Ataque especial("+ p1.getQntEspecial()+")\n4 - Usar Maca (" + p1.getUsosDisponiveis() + ")\n");
                    escolha = scanner.nextInt();
                    p1.acao(inimigo, escolha);
                    inimigo.acao(p1, escolha);
                } else {
                    System.out.print("\n1 - Atacar\n2 - Curar\n3 - Ataque especial("+ p1.getQntEspecial()+")\n4 - Usar Maca (" + p1.getUsosDisponiveis() + ")\n");
                    escolha = scanner.nextInt();
                    p1.acao(inimigo, escolha);
                    inimigo.acao(p1, escolha);
                }

                //Status do jogador e inimigo
                continuar(scanner);
                System.out.print("Status de " + p1.getNome() + ": " + p1.getVida());
                System.out.print("\nStatus do " + inimigo.getNome() + ": " + inimigo.getVida());
                System.out.print("\n-------------------\n");
            }
    }

    //Função para escolher a arma
    public static void escolhaArma(Jogador p1, Scanner scanner){
        System.out.print("Escolha sua arma: ");
        System.out.print("\n1 - Espada (dano base + dano base vezes 2) \n2 - Arco (dano base vezes 3 + dano base, mas com limite de flechas, depois somente seu dano base)\n");
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            p1.setArma(new Espada(p1.dano));
            System.out.println("Espada equipada");
        } else if (escolha == 2) {
            p1.setArma(new Arco(p1.dano, 5));
            System.out.println("Arco equipado com "+ p1.getFlecha() +" flechas");
        }
    }

    //Função para limpar o terminal
    public static void limparTerminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
