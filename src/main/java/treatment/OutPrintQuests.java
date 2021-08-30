package treatment;

import entity.Quest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import service.QuestService;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class OutPrintQuests implements OutPrint{

    private QuestService questService;

    public void printMessage() {
        List<Quest> questList = questService.getAllQuests();
        if (CollectionUtils.isNotEmpty(questList)) {
            for (Quest quest : questList) {
                System.out.println(quest.getId() + " " + quest.getQuest() + " " + quest.getAnswer());
            }
        } else {
            log.info("Список вопросов пуст.");
        }

    }
}
