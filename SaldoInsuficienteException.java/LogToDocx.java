import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class LogToDocx {

    private static final Logger logger = Logger.getLogger(LogToDocx.class.getName());

    public static void main(String[] args) {
        try {
            // Configurar o logger para usar um FileHandler
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            // Gerar um erro para teste
            try {
                int result = 10 / 0;
            } catch (Exception e) {
                logger.severe("Erro capturado: " + e.getMessage());
                writeLogToDocx("app.log", "error_log.docx");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLogToDocx(String logFilePath, String docxFilePath) {
        try (XWPFDocument document = new XWPFDocument();
             FileOutputStream out = new FileOutputStream(docxFilePath)) {

            // Ler o arquivo de log
            List<String> logLines = Files.readAllLines(Paths.get(logFilePath));

            // Escrever cada linha do log no documento .docx
            for (String line : logLines) {
                XWPFParagraph paragraph = document.createParagraph();
                paragraph.createRun().setText(line);
            }

            // Salvar o documento
            document.write(out);

            System.out.println("Log foi salvo em " + docxFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
