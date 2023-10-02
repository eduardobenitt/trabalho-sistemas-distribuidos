
public class Pedido {
   String nome;
   int tempoPreparo;
   String categoria;
   String item; // Novo atributo

    public Pedido(String nome, int tempoPreparo, String categoria, String item) {
        this.nome = nome;
        this.tempoPreparo = tempoPreparo;
        this.categoria = categoria;
        this.item = item;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    
}
