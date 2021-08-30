package service;

import entity.Quest;

import java.util.List;

public interface QuestService {

    public List<Quest> getAllQuests();

    public Quest getQuest(String id);
}
