public class Jogador extends Personagem{
    private Arma arma;
    private int AtaqueEspecial;
    private Maca maca;

    public Jogador(String nome, int vida, int dano, int cura, int AtaqueEspecial) {
        super(nome, vida, dano, cura);
        this.AtaqueEspecial = AtaqueEspecial;
    }

    public void atacar(Personagem alvo) {
        if (arma instanceof Arco) {
            Arco arco = (Arco) arma;
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
        if (AtaqueEspecial == 0) {
            System.out.println("Ataque especial indisponível");
            System.out.println("Ataque normal realizado");
            atacar(alvo);
        } else if ( AtaqueEspecial  > 0){
        alvo.vida -= (this.dano * 2 + arma.getDano());
        this.AtaqueEspecial -= 1;
        System.out.println("Jogador atacou com especial");
        }
    }

    public void equiparArma(Arma arma) {
        this.arma = arma;
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
        } else if (acao == 4 && maca != null && maca instanceof Maca && maca.getUsosDisponiveis() > 0){
         maca.usar();
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

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.AtaqueEspecial = ataqueEspecial;
    }

    public int getAtaqueEspecial() {
        return this.AtaqueEspecial;
    }
    
    public void setMaca(Maca maca) {
        this.maca = maca;
    }

    public Maca getMaca() {
        return this.maca;
    }

}
