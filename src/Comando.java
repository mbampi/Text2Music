public class Comando {

    private char comando;
    private char ultimoComando;

    public Comando() {
    }

    boolean isDigito(){
        return Character.isDigit(this.comando);
    }

    boolean ultimoComandoIsNota() {
        return isNota(this.ultimoComando);
    }

    boolean comandoIsNota() {
        return isNota(this.comando);
    }

    private boolean isNota(char c){
        return (c == 'A'  || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'G');
    }

    boolean isVogal() {
        char c = Character.toUpperCase(this.comando);
        return (c == 'A'  || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    boolean isOUI(){
        char c = Character.toUpperCase(this.comando);
        return (c == 'O'  || c == 'U' || c == 'I');
    }

    public boolean isConsoante() {
        return !isVogal();
    }


    public char getComando() {
        return comando;
    }

    public void setComando(char comando) {
        this.ultimoComando = this.comando;
        this.comando = comando;
    }

    public char getUltimoComando() {
        return ultimoComando;
    }
}
