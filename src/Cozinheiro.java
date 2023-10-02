import java.util.Random;

public class Cozinheiro implements Runnable {
    private FilaPedidos filaPedidos;

    public Cozinheiro(FilaPedidos filaPedidos) {
        this.filaPedidos = filaPedidos;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            try {
                Pedido pedido = filaPedidos.retirarPedido();
                System.out.println("Cozinheiro está preparando: " + pedido.getNome());
                Thread.sleep(pedido.getTempoPreparo());
                System.out.println("Pedido de " + pedido.getNome() + " está pronto.");

                synchronized (pedido) {
                    pedido.notify(); // Notifica o cliente que o pedido está pronto
                }

                int tempoConsumo = random.nextInt(4901) + 100; // Entre 100 e 5000 ms
                Thread.sleep(tempoConsumo);
                System.out.println("Pedido de " + pedido.getNome() + " foi consumido.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
