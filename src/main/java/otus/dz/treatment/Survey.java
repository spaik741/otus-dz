package otus.dz.treatment;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import otus.dz.entity.Quest;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class Survey {

    private final String pathToFile;

    public Survey(@Value("${pathFile}") String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public List<Quest> getQuestions() {
        List<Quest> questList = new ArrayList<>();
        try {
            FileReader file = new FileReader(getClass().getClassLoader().getResource(pathToFile).getFile());
            ICsvBeanReader csvBeanReader = new CsvBeanReader(file, CsvPreference.STANDARD_PREFERENCE);
            String[] mapping = new String[]{"id", "quest"};
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
                new NotNull()
        };
    }
}
