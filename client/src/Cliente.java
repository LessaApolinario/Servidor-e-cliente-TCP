import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

  public static void main(String[] args) throws Exception {
    try (Socket cliente = new Socket("localhost", 2007)) {
      InputStream entrada = cliente.getInputStream();
      BufferedReader ler = new BufferedReader(new InputStreamReader(entrada));

      String mensagem = ler.readLine();

      System.out.println(mensagem);
    } catch (UnknownHostException e) {
      System.err.println("O servidor não foi encontrado " + e.getMessage());
    }
  }
}
