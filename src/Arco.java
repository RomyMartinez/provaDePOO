public class Arco extends Arma {
    private int flecha;

    public Arco(int dano, int flecha) {
        super(dano);
        this.flecha = flecha;
    }

    public int getFlecha() {
        return this.flecha;
    }

    public void setFlecha(int flecha) {
        this.flecha = flecha;
    }
}
