import java.util.Random;

public class Inimigo extends Personagem{
    protected String raridade;
    public Inimigo(String nome, int vida, int dano, int cura, String raridade) {
        super(nome, vida, dano, cura);
        this.raridade = raridade;
    }

    public void acao(Personagem alvo, int acao){
        acao = new Random().nextInt(3) + 1;
        if(acao == 1){
            atacar(alvo);
            System.out.println(getNome() +" atacou");
        }else if(acao == 2){
            curar();
            System.out.println(getNome() +" se curou");
        }else if(acao == 3){
            ataquesEspecial(alvo);
            System.out.println(getNome() +" atacou com especial");
        }
    }

    public void atacar(Personagem alvo) {
        alvo.vida -= this.dano;
    }

    public void curar() {
        this.vida += this.cura;;
    }
    
    public void ataquesEspecial(Personagem alvo) {
        alvo.vida -= this.dano * 2;
    }

    public void mostarDados() {
        super.mostarDados();
        System.out.println("Raridade: " + this.raridade);
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public String getRaridade() {
        return raridade;
    }
}
