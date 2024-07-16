package pro.sky.CourseWork2.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CourseWork2.model.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void shouldNumberCollectionRequestedNumber() {
        //given
        int amount=2;
        List<Question> questionList=List.of(
                new Question("question1","answer1"),
                new Question("question2","answer2"),
                new Question("question3","answer3")
        );

        Mockito.when(javaQuestionService.getAll()).thenReturn(questionList);
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(
                questionList.get(0),
                questionList.get(0),
                questionList.get(0),
                questionList.get(1));
        //when
        Collection<Question> actualQuestion = examinerService.getQuestion(amount);
        //then
        assertEquals(Set.of(questionList.get(0),questionList.get(1)),actualQuestion);
        Mockito.verify(javaQuestionService,times(4)).getRandomQuestion();
    }


}