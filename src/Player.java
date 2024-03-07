public class Player extends Personagem{
    private Arma arma;
    private int AtaqueEspecial;
    private Item item;

    public Player(String nome, int vida, int dano, int defesa, int AtaqueEspecial) {
        super(nome, vida, dano, defesa);
        this.AtaqueEspecial = AtaqueEspecial;
    }

    public void atacar(Personagem alvo) {
        if (arma instanceof Arco) {
            Arco arco = (Arco) arma;
            if (arco.getFlecha() <= 0){
                alvo.vida -= this.dano;
                System.out.println("Sem flechas, atacou com dano base");
            } else {
                arco.setFlecha(arco.getFlecha() - 1);
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
            System.out.println("Jogador atacou");
        }else if(acao == 2){
            defender();
            System.out.println("Jogador defendeu");
        }else if(acao == 3){
            ataquesEspecial(alvo);
        } else if (acao == 4 && item != null && item instanceof Maca && item.getUsosDisponiveis() > 0){
            item.usar(this);
            item.setUsosDisponiveis(item.getUsosDisponiveis() - 1);
            System.out.println("Jogador comeu maçã, ganhou mais 2 de dano base");
        } else if ( item.getUsosDisponiveis() == 0){
            System.out.println("Sem maçãs disponíveis");
            System.out.println("Jogador perdeu o turno");
        }

    }

    public int getUsosDisponiveis() {
        return item.getUsosDisponiveis();
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
    
    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }

    
}
