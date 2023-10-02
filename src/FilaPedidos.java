import java.util.Queue;
import java.util.LinkedList;

public class FilaPedidos {
    private Queue<Pedido> fila = new LinkedList<>();
    private boolean notificar = false;

    public synchronized void adicionarPedido(Pedido pedido) {
        fila.add(pedido);
        notificar = true;
        notifyAll();
    }

    public synchronized Pedido retirarPedido() throws InterruptedException {
        while (fila.isEmpty()) {
            if (!notificar) wait();
        }
        notificar = false;
        return fila.poll();
    }
}
