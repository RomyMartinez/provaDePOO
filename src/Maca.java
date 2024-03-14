public class Maca implements Usar{
    private Jogador jog;
    private int usosDisponiveis = 1;

    public Maca(Jogador jog){
        this.jog = jog;
    }

    public void usar() {
        this.usosDisponiveis -= 1;
        jog.setDano(jog.getDano() + 2);
    }

    public int getUsosDisponiveis() {
        return this.usosDisponiveis;
    }

    public void setUsosDisponiveis(int usosDisponiveis) {
        this.usosDisponiveis = usosDisponiveis;
    }

}
