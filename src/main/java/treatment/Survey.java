package treatment;

import entity.Quest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@AllArgsConstructor
public class Survey {

    private String pathToFile;

    public List<Quest> getQuestions() {
        List<Quest> questList = new ArrayList<>();
        try {
            ICsvBeanReader csvBeanReader = new CsvBeanReader(new FileReader(getClass().getClassLoader().getResource(pathToFile).getFile()), CsvPreference.STANDARD_PREFERENCE);
            String[] mapping = new String[]{"id", "quest", "answer"};
            CellProcessor[] procs = getProcessors();
            Quest quest;
            while ((quest = csvBeanReader.read(Quest.class, mapping, procs)) != null) {
                questList.add(quest);
            }

        } catch (Exception e) {
            log.info("Ошибка парсинга файла {}", pathToFile);
            e.printStackTrace();
        }
        if (CollectionUtils.isEmpty(questList)) {
            log.info("Список вопросов пуст.");
        }
        return questList;
    }

    private CellProcessor[] getProcessors() {
        return new CellProcessor[]{
                new UniqueHashCode(),
                new NotNull(),
                new NotNull()
        };
    }
}
