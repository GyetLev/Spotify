package beadando;

class Zeneszamok {
    String eloado, cim, stilus, hossz;

    public Zeneszamok(String eloado, String cim, String stilus, String hossz) {
        this.eloado = eloado;
        this.cim = cim;
        this.stilus = stilus;
        this.hossz = hossz;
    }

    public String getEloado() {
        return eloado;
    }

    public void setEloado(String eloado) {
        this.eloado = eloado;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getStilus() {
        return stilus;
    }

    public void setStilus(String stilus) {
        this.stilus = stilus;
    }

    public String getHossz() {
        return hossz;
    }

    public void setHossz(String hossz) {
        this.hossz = hossz;
    }

    @Override
    public String toString() {
        return "Eloado = " + eloado + ", Cim = " + cim + ", Stilus = " + stilus + ", Hossz = " + hossz + " ~~ lejátszva" + "\n";
    }
    
    public void kiirat(){
        System.out.println("Eloado = " + eloado + ", Cim = " + cim + ", Stilus = " + stilus + ", Hossz = " + hossz + " ~~ lejátszva"+ "\n");
    }
}