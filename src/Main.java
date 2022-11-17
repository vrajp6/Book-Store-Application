import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    private static ArrayList<Customer> C = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
