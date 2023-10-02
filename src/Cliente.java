import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cliente implements Runnable {
    private FilaPedidos filaPedidos;
    private String nome;
    private List<String> cardapio;

    public Cliente(FilaPedidos filaPedidos, String nome) {
        this.filaPedidos = filaPedidos;
        this.nome = nome;

        cardapio = new ArrayList<>();
        cardapio.add("Hamburguer");
        cardapio.add("Pizza");
        cardapio.add("Salada Caesar");
        cardapio.add("Sopa de Tomate");
        cardapio.add("Massa Carbonara");
        cardapio.add("Sushi");
        cardapio.add("Bife à Milanesa");
        cardapio.add("Sorvete de Chocolate");
        cardapio.add("Bolo de Morango");
        cardapio.add("Torta de Limão");
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            String nomePedido;
            String categoria;

            switch (i) {
                case 0:
                    nomePedido = "Entrada do " + nome;
                    categoria = "entrada";
                    break;
                case 1:
                    nomePedido = "Prato Principal do " + nome;
                    categoria = "prato principal";
                    break;
                case 2:
                    nomePedido = "Sobremesa do " + nome;
                    categoria = "sobremesa";
                    break;
                default:
                    nomePedido = "Desconhecido";
                    categoria = "desconhecida";
            }

            int tempoPreparo = random.nextInt(3901) + 100; // Entre 100 e 4000 ms

            String itemSelecionado = cardapio.get(random.nextInt(cardapio.size()));

            Pedido pedido = new Pedido(nomePedido, tempoPreparo, itemSelecionado, categoria);
            filaPedidos.adicionarPedido(pedido);

            System.out.println(nome + " fez o pedido: " + nomePedido + " (" + categoria + ")");

            synchronized (pedido) {
                try {
                    pedido.wait(); // Espera a notificação de que o pedido está pronto
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
