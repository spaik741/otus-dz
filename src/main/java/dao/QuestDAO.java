package dao;

import entity.Quest;

import java.util.List;

public interface QuestDAO {

    public List<Quest> getAllQuests();

    public Quest getQuest(String id);
}
