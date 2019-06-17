package Code;

class Comando {

    private char comando;
    private char ultimoComando;

    Comando() {
        comando = Character.UNASSIGNED;
        ultimoComando = Character.UNASSIGNED;
    }

    char getComando() {
        return comando;
    }

    int getComandoDigito() {
        return comando - '0';
    }

    void setComando(char comando) {
        this.ultimoComando = this.comando;
        this.comando = comando;
    }

    char getUltimoComando(){ return ultimoComando; }

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

    private boolean isVogal() {
        char c = Character.toUpperCase(this.comando);
        return (c == 'A'  || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    boolean isOUI(){
        char c = Character.toUpperCase(this.comando);
        return (c == 'O'  || c == 'U' || c == 'I');
    }

    boolean isConsoante() {
        return !isVogal();
    }

}
