public abstract class Personagem {
    protected String nome;
    protected int vida, dano, defesa;

    public Personagem(String nome, int vida, int dano, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.defesa = defesa;
    }

    abstract void atacar(Personagem alvo);
    abstract void ataquesEspecial(Personagem alvo);
    abstract public void acao(Personagem alvo, int acao);

    public void defender() {
        this.vida += this.defesa;
    }

    public void mostarDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Dano: " + this.dano);
        System.out.print("Defesa: " + this.defesa);
    }

    public int getDano() {
        return this.dano;
    }

    public int getDefesa() {
        return this.defesa;
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
        this.defesa = defesa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}