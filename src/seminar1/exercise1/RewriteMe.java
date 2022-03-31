package seminar1.exercise1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

// Philip Tonaczew 2022-01-18 

public class RewriteMe {

    public Database database = new Database();
    public List<Question> questions = database.getQuestions();

    public int getAmountOfQuestionsInDatabase(){
        return (int) questions.stream()
                .count();
    }

    public int getAmountOfQuestionsForACertainCategory(Category category){
        return (int) questions.stream()
                .filter(q -> q.getCategory().equals(category))
                .count();
    }

    public List<String> getListOfAllQuestions(){
        return questions.stream()
                .map(q -> q.getQuestionString())
                .toList();
    }

    public List<String> getAllQuestionStringsBelongingACategory(Category category){
        return questions.stream()
                .filter(q -> q.getCategory().equals(category))
                .map(Question::getQuestionString)
                .toList();
    }
    
    public List<String> getAllAnswerOptionsDistinct(){
        return questions.stream()
                .map(Question::getAllAnswers)
                .flatMap(q -> q.stream())
                .distinct()
                .toList();
    }

    public boolean isThisAnAnswerOption(String answerCandidate){
        return getAllAnswerOptionsDistinct().stream()
                .anyMatch(s -> s.equals(answerCandidate));
    }

    public int getAnswerCandidateFrequncy(String answerCandidate){
        return (int) questions.stream()
                .map(Question::getAllAnswers)
                .flatMap(q -> q.stream())
                .filter(s -> s.equals(answerCandidate))
                .count();
    }

    public static void main(String[] args){
        RewriteMe uppg4 = new RewriteMe();
    }
}
