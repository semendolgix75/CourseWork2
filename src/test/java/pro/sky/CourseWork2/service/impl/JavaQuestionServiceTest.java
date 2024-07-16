package pro.sky.CourseWork2.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.CourseWork2.model.Question;
import pro.sky.CourseWork2.service.QuestionService;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private  QuestionService questionService;

    @BeforeEach
    public void clear() {

    questionService = new JavaQuestionService();
    }
    @Test
    void shouldAddQuestion() {
//  given
        Question expectedQuestion = new Question("questionNew", "answerNew");
//  when
        Question actualQuestion1 = questionService.add(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());
        Question actualQuestion2 = questionService.add(expectedQuestion);
//  then
        assertEquals(expectedQuestion.getQuestion(), actualQuestion1.getQuestion());
        assertEquals(expectedQuestion.getAnswer(), actualQuestion1.getAnswer());
        assertEquals(expectedQuestion, actualQuestion2);

    }

    @Test
    void shouldRemoveQuestion() {
        //given
        Question expectedQuestion = new Question("questionNew", "answerNew");
        questionService.add(expectedQuestion);
        //when
        Question actualQuestion = questionService.remove(expectedQuestion);
        //then
        assertEquals(expectedQuestion,actualQuestion);
    }



    @Test
    void shouldGetAllQuestion() {
        //given
        Question question1 = new Question("question", "answer");
        Question question2 = new Question("question2", "answer2");
        questionService.add(question1);
        questionService.add(question2);
        //when
        Collection<Question> actualQuestions=questionService.getAll();
        //then
        assertEquals(Set.of(question1,question2),actualQuestions);
    }

    @Test
    void getRandomQuestion() {
        //given
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        questionService.add(question1);
        questionService.add(question2);
        //when
        Question randomQuestion = questionService.getRandomQuestion();
        //then
        assertTrue(Set.of(question1,question2).contains(randomQuestion));
    }
}