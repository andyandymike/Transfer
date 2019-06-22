import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransferApplication {

    private static Logger logger = LogManager.getLogger("TransferApplication");

    public static void main(String[] args) {
        ApplicationContext transferApplication = new ClassPathXmlApplicationContext("TransferApplication.xml");
        logger.debug("hello world");
    }
}
