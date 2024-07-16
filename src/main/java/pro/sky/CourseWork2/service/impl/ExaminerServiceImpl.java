package pro.sky.CourseWork2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.exception.NumberQuestionOverException;
import pro.sky.CourseWork2.model.Question;
import pro.sky.CourseWork2.service.ExaminerService;
import pro.sky.CourseWork2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;

    }
    @Override
    public Collection<Question> getQuestion(int amount) {
        int size = questionService.getAll().size();
        if (amount > size) {
            throw new NumberQuestionOverException();
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
