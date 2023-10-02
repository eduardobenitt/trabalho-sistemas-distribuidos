import java.util.Random;

public class Cliente implements Runnable {
    private FilaPedidos filaPedidos;
    private String nome;

    public Cliente(FilaPedidos filaPedidos, String nome) {
        this.filaPedidos = filaPedidos;
        this.nome = nome;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            String nomePedido = "Pedido " + (i + 1) + " do " + nome;
            int tempoPreparo = random.nextInt(3901) + 100; // Entre 100 e 4000 ms
            String categoria;
            switch (i) {
                case 0:
                    categoria = "entrada";
                    break;
                case 1:
                    categoria = "prato principal";
                    break;
                case 2:
                    categoria = "sobremesa";
                    break;
                default:
                    categoria = "desconhecida";
            }

            Pedido pedido = new Pedido(nomePedido, tempoPreparo, categoria);
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
