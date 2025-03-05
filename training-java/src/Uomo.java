public class Uomo {

    int numeroDiOcchi;
    String nome;
    String cognome;

    public Uomo() {}

    public int calcolaEta(){
        return 35;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getNumeroDiOcchi() {
        return numeroDiOcchi;
    }

    public void setNumeroDiOcchi(int numeroDiOcchi) {
        this.numeroDiOcchi = numeroDiOcchi;
    }
}
