package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    public static void registrar(String operacao) {
        try (FileWriter fw = new FileWriter("logs/operacoes.txt", true)) {
            fw.write(LocalDateTime.now() + " - " + operacao + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}
