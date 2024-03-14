public class Jogador extends Personagem{
    private Arma arma;
    private int qntEspecial;
    private Maca maca;

    public Jogador(String nome, int vida, int dano, int cura, int qntEspecial) {
        super(nome, vida, dano, cura);
        this.qntEspecial = qntEspecial;
    }

    public void atacar(Personagem alvo) {
        if (arma instanceof Arco) {
            Arco arco = (Arco) arma;  //casting de arma para arco.
            if (arco.getFlecha() <= 0){
                alvo.vida -= this.dano;
                System.out.println("Sem flechas, atacou com dano base");
            } else {
                arco.usar();
                alvo.vida -= (this.dano + arma.getDano());
            }
            return;
        }
        alvo.vida -= (this.dano + arma.getDano());
    }

    public void ataquesEspecial(Personagem alvo) {
        if (qntEspecial == 0) {
            System.out.println("Ataque especial indisponível");
            System.out.println("Ataque normal realizado");
            atacar(alvo);
        } else if ( qntEspecial  > 0){
        alvo.vida -= (this.dano * 2 + arma.getDano());
        this.qntEspecial -= 1;
        System.out.println("Jogador atacou com especial");
        }
    }

    public void acao(Personagem alvo, int acao) {
        if(acao == 1){
            atacar(alvo);
            System.out.println(this.getNome() + " atacou");
        }else if(acao == 2){
            curar();
            System.out.println(this.getNome() + " curou-se");
        }else if(acao == 3){
            ataquesEspecial(alvo);
        } else if (acao == 4 && maca != null && maca.getUsosDisponiveis() > 0){
            maca.usar();
            maca.setUsosDisponiveis(maca.getUsosDisponiveis() - 1);
            System.out.println(this.getNome() + " comeu maçã, ganhou mais 2 de dano base");
        } else if ( maca.getUsosDisponiveis() == 0){
            System.out.println("Sem maçãs disponíveis");
            System.out.println(this.getNome() + " perdeu o turno");
        }

    }

    public int getUsosDisponiveis() {
        return maca.getUsosDisponiveis();
    }

    public int getFlecha() {
        if (arma instanceof Arco) {
            Arco arco = (Arco) arma;
            return arco.getFlecha();
        }
        return 0;
    }

    public Arma getArma() {
        return this.arma;
    }

    public void setQntEspecial(int qntEspecial) {
        this.qntEspecial = qntEspecial;
    }

    public int getQntEspecial() {
        return this.qntEspecial;
    }
    
    public void setMaca(Maca maca) {
        this.maca = maca;
    }

    public Maca getMaca() {
        return this.maca;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
    
}
