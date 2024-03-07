public abstract class Personagem {
    protected String nome;
    protected int vida, dano, cura;

    public Personagem(String nome, int vida, int dano, int cura) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.cura = cura;
    }

    abstract void atacar(Personagem alvo);
    abstract void ataquesEspecial(Personagem alvo);
    abstract public void acao(Personagem alvo, int acao);

    public void curar() {
        this.vida += this.cura;
    }

    public void mostarDados() {
        System.out.println("-------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Dano: " + this.dano);
        System.out.println("Cura: " + this.cura);
    }

    public void setcura(int cura) {
        this.cura = cura;
    }

    public int getCura() {
        return this.cura;
    }

    public String getNome() {
        return this.nome;
    }

    public int getVida() {
        return this.vida;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setDefesa(int defesa) {
        this.cura = defesa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}