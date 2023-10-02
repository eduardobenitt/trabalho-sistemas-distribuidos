
public class Pedido {
   String nome;
   int tempoPreparo;
   String categoria;

    public Pedido(String nome, int tempoPreparo, String categoria) {
        this.nome = nome;
        this.tempoPreparo = tempoPreparo;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
   
   
}
