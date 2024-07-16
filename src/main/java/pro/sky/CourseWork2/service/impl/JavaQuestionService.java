package pro.sky.CourseWork2.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.model.Question;
import pro.sky.CourseWork2.service.QuestionService;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questionSet = new HashSet<>();
    private final Random random = new Random();
    @PostConstruct
    public void init(){
        add("Какие циклы вы знаете, в чем их отличия?","Цикл while, Цикл do..while, Цикл for" );
        add("Методы каких типов бывают?","Исполняемые (void) , Возвратные" );
        add("Что такое «цикл»?","Цикл — это блок команд, который выполняется снова и снова, пока соблюдается определённое условие." );

    }
    @Override
    public Question add(String question, String answer) {
        Question questionNew = new Question(question, answer);
        questionSet.add(questionNew);
        return questionNew;
    }

    @Override
    public Question add(Question question) {
        questionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questionSet.size());


        return new ArrayList<>(questionSet).get(randomIndex);
    }
}
