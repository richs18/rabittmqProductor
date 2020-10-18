import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class productor implements Runnable{

    private final static String QUEUE_NAME = "MAIN_QUEUE";
    ArrayList<String> datos;

    //constructor
    productor(ArrayList<String> dato){
        this.datos = dato;
        run();
    }

    public void producirMenssage()throws IOException, TimeoutException{

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        for (int i = 0; i < datos.size(); i++) {
            String message = datos.get(i);
            System.out.println("datos del arreglo en el productor"+message);

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }
        System.out.println("hola mundo");

        //String message = "¡Hola!";



        // System.out.println(" [x] Enviar '" + message + "'");

    }

    public void run() {
        try {
            producirMenssage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
