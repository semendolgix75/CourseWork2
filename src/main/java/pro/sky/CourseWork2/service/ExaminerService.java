package pro.sky.CourseWork2.service;

import pro.sky.CourseWork2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
