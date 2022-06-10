package edu.zjgu.serviceanswer.Service;

import edu.zjgu.serviceanswer.dao.QuestionAskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionAskDao questionAskDao;

    public void save(String question,String answer) {
        questionAskDao.saveQuestion(question,answer);
    }

    public String findAnwser(String question) {
        return questionAskDao.findQuestion(question);
    }
}
