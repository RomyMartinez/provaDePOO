import java.util.Random;

public class Inimigo extends Personagem{
    public Inimigo(String nome, int vida, int dano, int defesa) {
        super(nome, vida, dano, defesa);
    }

    public void acao(Personagem alvo, int acao){
        acao = new Random().nextInt(3) + 1;
        if(acao == 1){
            atacar(alvo);
            System.out.println("Inimigo atacou");
        }else if(acao == 2){
            defender();
            System.out.println("Inimigo defendeu");
        }else if(acao == 3){
            ataquesEspecial(alvo);
            System.out.println("Inimigo atacou com especial");
        }
    }

    public void atacar(Personagem alvo) {
        alvo.vida -= this.dano;
    }

    public void defender() {
        this.vida += this.defesa;
    }
    
    public void ataquesEspecial(Personagem alvo) {
        alvo.vida -= this.dano * 2;
    }
}
