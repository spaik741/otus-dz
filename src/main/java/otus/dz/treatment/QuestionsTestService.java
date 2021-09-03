package otus.dz.treatment;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import otus.dz.entity.Quest;
import otus.dz.service.QuestService;

import java.util.List;
import java.util.Scanner;

@Slf4j
@Service
public class QuestionsTestService {

    private final QuestService questService;

    public QuestionsTestService(QuestService questService) {
        this.questService = questService;
    }

    public void test() {
        List<Quest> quests = questService.getAllQuests();
        int result = 100;
        for (Quest quest : quests) {
            System.out.println(quest.getQuest());
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (StringUtils.isBlank(answer)) {
                result = result - 20;
            } else {
                quest.setAnswer(answer);
            }
        }
        System.out.println("\nAnswers!!!");
        for (Quest quest : quests) {
            if (StringUtils.isNotBlank(quest.getAnswer())) {
                System.out.println(quest.getId() + ": " + quest.getAnswer());
            } else {
                System.out.println(quest.getId() + ": " + "answer is empty");
            }
        }
        System.out.println("Result test: " + result + "%");
    }

}
