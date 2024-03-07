import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Player p1 = new Player(null, 50, 2, 5, 2);

        System.out.print("Jogo iniciado!\n-------------------\n");
        System.out.print("Digite o nome do personagem: ");
        String nome = scanner.nextLine();
        p1.setNome(nome);
        System.out.print("-------------------\n");
        p1.mostarDados();
        System.out.print("\n-------------------\n");
        System.out.print("Escolha sua arma: ");
        System.out.print("\n1 - Espada (dano base + dano base vezes 2) \n2 - Arco (dano base vezes 3 + dano base, mas com limite de flechas, depois somente seu dano base)\n");
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            p1.equiparArma(new Espada(p1.dano));
            System.out.print("Espada equipada");
        } else if (escolha == 2) {
            p1.equiparArma(new Arco(p1.dano*3, 5));
            System.out.print("Arco equipado com "+ p1.getFlecha() +" flechas");
        }
        System.out.print("\n-------------------\n");
        System.out.print("Escolha o seu caminho direita ou esquerda: ");
        System.out.print("\n1 - Direita\n2 - Esquerda\n");
        escolha = scanner.nextInt();
        if (escolha == 1) {
            System.out.print("Caminho da direita escolhido");
            System.out.print("\n-------------------\n");
            System.out.print("Inimigo encontrado!\n");
            Inimigo inimigo = new Inimigo("Monstrou verde", 20, 5, 5);
            inimigo.mostarDados();
            System.out.print("\n-------------------\n");
            while (p1.getVida() > 0 && inimigo.getVida() > 0) {
                System.out.print("Escolha sua ação: ");
                if(p1.getArma() instanceof Arco){
                    System.out.print("\n1 - Atacar (flechas: " + p1.getFlecha()  + ")\n2 - Defender\n3 - Ataque especial ("+ p1.getAtaqueEspecial()+")\n");
                    escolha = scanner.nextInt();
                    p1.acao(inimigo, escolha);
                    inimigo.acao(p1, escolha);
                } else {
                    System.out.print("\n1 - Atacar\n2 - Defender\n3 - Ataque especial\n");
                    escolha = scanner.nextInt();
                    p1.acao(inimigo, escolha);
                    inimigo.acao(p1, escolha);
                }
                System.out.print("-------------------\n");
                System.out.print("Status do jogador: " + p1.getVida());
                System.out.print("\nStatus do " + inimigo.getNome() + ": " + inimigo.getVida());
                System.out.print("\n-------------------\n");
            }
            if (p1.getVida() <= 0) {
                System.out.print("Você perdeu!\n");
            } else if (inimigo.getVida() <= 0) {
                System.out.print("Inimigo derrotado!\n");
                System.out.print("Você ganhou uma maçã!");
                p1.setItem(new Maca());
                System.out.print("\n-------------------\n");
                System.out.print("Agora você enfrentara o chefe!\n");
                Chefe chefe = new Chefe("Chefe", 50, 7, 7);
                chefe.mostarDados();
                System.out.print("\n-------------------\n");
                while (p1.getVida() > 0 && chefe.getVida() > 0) {
                    System.out.print("Escolha sua ação: ");
                    if(p1.getArma() instanceof Arco){
                        System.out.print("\n1 - Atacar (flechas: " + p1.getFlecha()  + ")\n2 - Defender\n3 - Ataque especial ("+ p1.getAtaqueEspecial()+")\n4- Usar item("+ p1.getUsosDisponiveis()+ ")\n");
                        escolha = scanner.nextInt();
                        p1.acao(chefe, escolha);
                        chefe.acao(p1, escolha);
                    } else {
                        System.out.print("\n1 - Atacar\n2 - Defender\n3 - Ataque especial("+ p1.getAtaqueEspecial()+")\n4- Usar item("+ p1.getUsosDisponiveis()+ ")\n");
                        escolha = scanner.nextInt();
                        p1.acao(chefe, escolha);
                        chefe.acao(p1, escolha);
                    }
                    System.out.print("-------------------\n");
                    System.out.print("Status do jogador: " + p1.getVida());
                    System.out.print("\nStatus do chefe: " + chefe.getVida());
                    System.out.print("\n-------------------\n");
                }
                if (p1.getVida() <= 0) {
                    System.out.print("Você perdeu!\n");
                } else if (chefe.getVida() <= 0) {
                    System.out.print("Você venceu o jogo!\n");
                }
            }

        } else if (escolha == 2) {
            System.out.print("Caminho da esquerda escolhido");
            System.out.print("\n-------------------\n");
            System.out.print("Chefe encontrado! (Ele tem mais probabilidade de usar Ataque Especial)\n");
            Chefe chefe = new Chefe("Chefe", 50, 7, 7);
            chefe.mostarDados();
            System.out.print("\n-------------------\n");
            while (p1.getVida() > 0 && chefe.getVida() > 0) {
                System.out.print("Escolha sua ação: ");
                if(p1.getArma() instanceof Arco){
                    System.out.print("\n1 - Atacar (flechas: " + p1.getFlecha()  + ")\n2 - Defender\n3 - Ataque especial ("+ p1.getAtaqueEspecial()+")\n");
                    escolha = scanner.nextInt();
                    p1.acao(chefe, escolha);
                    chefe.acao(p1, escolha);
                } else {
                    System.out.print("\n1 - Atacar\n2 - Defender\n3 - Ataque especial(\"+ p1.getAtaqueEspecial()+\")\n");
                    escolha = scanner.nextInt();
                    p1.acao(chefe, escolha);
                    chefe.acao(p1, escolha);
                }
                System.out.print("-------------------\n");
                System.out.print("Status do jogador: " + p1.getVida());
                System.out.print("\nStatus do chefe: " + chefe.getVida());
                System.out.print("\n-------------------\n");
            }
            if (p1.getVida() <= 0) {
                System.out.print("Você perdeu!\n");
            } else if (chefe.getVida() <= 0) {
                System.out.print("Você venceu o jogo!\n");
            }
        }
    }
}
