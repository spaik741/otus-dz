package treatment;

import entity.Quest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SurveyTest {

    Survey survey;

    @BeforeEach
    public void init() {
        survey = new Survey("");
    }

    @Test
    public void cleanTest() {
        List<Quest> questList = survey.getQuestions();
        assertNotNull(questList);
    }

}