package pro.sky.CourseWork2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class NumberQuestionOverException extends RuntimeException{
    public NumberQuestionOverException() {
    }

    public NumberQuestionOverException(String message) {
        super(message);
    }
}
