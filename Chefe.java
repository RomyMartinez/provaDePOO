import java.util.Random;

public class Chefe extends Inimigo{

    public Chefe(String nome, int vida, int dano, int cura) {
        super(nome, vida, dano, cura, "chefe");
    }

    public void acao(Personagem alvo, int acao) {
        acao = new Random().nextInt(4) + 1;
        if (acao == 1) {
            atacar(alvo);
            System.out.println("Chefe atacou");
        } else if (acao == 2) {
            curar();
            System.out.println("Chefe curou-se");
        } else if (acao == 3 || acao == 4) {
            ataquesEspecial(alvo);
            System.out.println("Chefe atacou com especial");
        }
    }
    
}
