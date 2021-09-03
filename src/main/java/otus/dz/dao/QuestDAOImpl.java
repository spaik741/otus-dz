package otus.dz.dao;

import org.springframework.stereotype.Service;
import otus.dz.entity.Quest;
import otus.dz.treatment.Survey;

import java.util.List;
import java.util.Optional;

@Service
public class QuestDAOImpl implements QuestDAO {

    private final Survey survey;

    public QuestDAOImpl(Survey survey) {
        this.survey = survey;
    }

    @Override
    public List<Quest> getAllQuests() {
        return survey.getQuestions();
    }

    @Override
    public Optional<Quest> getQuest(String id) {
        return survey.getQuestions().stream().filter(s -> s.getId().equals(id)).findFirst();
    }
}
