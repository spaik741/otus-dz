package service;

import dao.QuestDAO;
import entity.Quest;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QuestServiceImpl implements QuestService {

    private QuestDAO questDAO;

    @Override
    public List<Quest> getAllQuests() {
        return questDAO.getAllQuests();
    }

    @Override
    public Quest getQuest(String id) {
        return questDAO.getQuest(id);
    }
}
