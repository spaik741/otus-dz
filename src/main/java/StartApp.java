import org.springframework.context.support.ClassPathXmlApplicationContext;
import treatment.OutPrint;

public class StartApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        OutPrint message = context.getBean("outPrint", OutPrint.class);
        message.printMessage();
    }
}
