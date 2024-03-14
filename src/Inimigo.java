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

    public Inimigo gerarInimigo() {
        Random aleatorio = new Random();
        int raridade = aleatorio.nextInt(11) + 1; // 1 a 11
        //Gerar inimigo com base na raridade
        if (raridade <= 5){ // 1, 2, 3, 4, 5
            return new Inimigo("Goblin", 10, 2, 2, "Comun");
        } else if (raridade > 5 && raridade <= 8){ // 6, 7, 8
            return new Inimigo("Cobra", 15, 3, 3, "Incomun");
        } else if (raridade > 6 && raridade <= 8){ // 9 e 10
            return new Inimigo("Aranha", 20, 4, 4, "Incomun");
        } else { // 11
            return new Chefe("Chefe", 25, 5, 5);
        }
    }
}
