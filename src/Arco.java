public class Arco extends Arma implements Usar {
    private int flecha;

    public Arco(int dano, int flecha) {
        super(dano);
        this.flecha = flecha;
    }

    public void usar(){
        this.flecha -= 1;
    }

    public int getFlecha() {
        return this.flecha;
    }

    public void setFlecha(int flecha) {
        this.flecha = flecha;
    }
}