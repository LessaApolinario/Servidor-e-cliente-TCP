import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {

  public static void main(String args[]) {
    try {
      ServerSocket servidor = new ServerSocket(2007);

      System.out.println(
        "Servidor funcionando na porta " + servidor.getLocalPort()
      );

      while (true) {
        Socket socket = servidor.accept();

        System.out.println(
          "Cliente conectado com o IP " +
          socket.getInetAddress().getHostAddress()
        );

        OutputStream saida = socket.getOutputStream();
        PrintWriter escrever = new PrintWriter(saida, true);

        escrever.println(new Date().toString());
      }
    } catch (IOException e) {
      System.out.println("Problema no servidor!");
      e.printStackTrace();
    } finally {
      System.out.println("Conexão encerrada!");
    }
  }
}
