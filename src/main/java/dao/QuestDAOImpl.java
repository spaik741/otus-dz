package dao;

import entity.Quest;
import lombok.AllArgsConstructor;
import treatment.Survey;

import java.util.List;

@AllArgsConstructor
public class QuestDAOImpl implements QuestDAO {

    private Survey survey;

    @Override
    public List<Quest> getAllQuests() {
        return survey.getQuestions();
    }

    @Override
    public Quest getQuest(String id) {
        return survey.getQuestions().stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
}
