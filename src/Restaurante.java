import java.util.Random;
public class Restaurante {
    public static void main(String[] args) {
        FilaPedidos filaPedidos = new FilaPedidos();

        int numClientes = new Random().nextInt(31) + 20; // Entre 20 e 50 clientes
        int numCozinheiros = new Random().nextInt(6) + 5; // Entre 5 e 10 cozinheiros

        for (int i = 0; i < numCozinheiros; i++) {
            Thread cozinheiroThread = new Thread(new Cozinheiro(filaPedidos));
            cozinheiroThread.start();
        }

        for (int i = 0; i < numClientes; i++) {
            Thread clienteThread = new Thread(new Cliente(filaPedidos, "Cliente " + (i+1)));
            clienteThread.start();
        }
    }
}
