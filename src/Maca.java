public class Maca implements Item{
    private int usosDisponiveis = 1;

    public void usar(Player player) {
        player.setDano(player.getCura() + 2);
    }

    public int getUsosDisponiveis() {
        return this.usosDisponiveis;
    }

    public void setUsosDisponiveis(int usosDisponiveis) {
        this.usosDisponiveis = usosDisponiveis;
    }
}
