package otus.dz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import otus.dz.treatment.QuestionsTestService;


@Configuration
@ComponentScan
@PropertySource("classpath:myApp.properties")
public class StartApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StartApp.class);
        QuestionsTestService printerService = context.getBean("questionsTestService", QuestionsTestService.class);
        printerService.test();
//        QuestService questService = context.getBean("questServiceImpl", QuestServiceImpl.class);
//        List<Quest> quests = questService.getAllQuests();
//        for (Quest quest : quests) {
//            System.out.println(quest.getQuest());
//            Scanner scanner = new Scanner(System.in);
//            String answer = scanner.nextLine();
//            quest.setAnswer(answer);
//        }
//        System.out.println("Ответы!!!");
//        for (Quest quest:quests){
//            System.out.println(quest.getId() + " " + quest.getAnswer());
//        }
    }
}
