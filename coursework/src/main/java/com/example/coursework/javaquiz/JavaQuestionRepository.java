package com.example.coursework.javaquiz;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.example.coursework.question.Question;
import com.example.coursework.question.QuestionRepository;
import com.example.coursework.question.QuestionServiceException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
@Scope
public class JavaQuestionRepository implements QuestionRepository {

    private Set<Question> questionCollection = new HashSet<>();

    public JavaQuestionRepository() {
    }

    public JavaQuestionRepository(Collection<Question> questionCollection) {
        this.questionCollection = (Set<Question>) questionCollection;
    }

    @Override
    public Question add(Question question) {
        checkQuestion(question);
        questionCollection.add(question);
        return question;
    }

    private void checkQuestion(Question question) {
        if (question == null || questionCollection.contains(question)) {
            throw new QuestionServiceException("question is null or already added");
        }
    }


    @Override
    public Question add(String problem, String answer) {
        Question question = new Question(problem, answer);
        return add(question);
    }

    @Override
    public Question remove(Question question) {
        if (!questionCollection.contains(question)) {
            throw new QuestionServiceException("question is missing");
        }
        questionCollection.remove(question);
        return question;
    }

    @Override
    public Question remove(String problem, String answer) {
        Question question = new Question(problem, answer);
        return remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        Collection<Question> questions = new HashSet<>();
        questions = questionCollection;
        return questions;
    }

    @PostConstruct
    public void init() {
        add("What is Autoboxing and Unboxing?",
                "Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an int to an Integer, a double to a Double, and so on. If the conversion goes the other way, this is called unboxing");
        add("What class in Java is parent of Object class?",
                "Object class is topmost class in Java, so it has no parent class");
        add("What are the supported platforms by Java Programming Language?",
                "Java runs on a variety of platforms, such as Windows, Mac OS, and the various versions of UNIX/Linux like HP-Unix, Sun Solaris, Redhat Linux, Ubuntu, CentOS, etc. This Particular section is dedicated to Question & Answer only. If you want learn more about Java Programming Language");
        add("What are the differences between Heap and Stack Memory in Java?",
                "Stack memory in data structures is the amount of memory allocated to each individual programme. It is a fixed memory space. Heap memory, in contrast, is the portion that was not assigned to the Java code but will be available for use by the Java code when it is required, which is generally during the program's runtime.");
        add("How does Java enable high performance?",
                "Java uses Just In Time compiler to enable high performance. It is used to convert the instructions into bytecodes");
        add("What do you mean by Constructor?",
                "Constructors can be explained in detail with enlisted points: " +
                        "When a new object is created in a program a constructor gets invoked corresponding to the class. " +
                        "The constructor is a method which has the same name as the class name. " +
                        "If a user doesn’t create a constructor implicitly a default constructor will be created. " +
                        "The constructor can be overloaded. " +
                        "If the user created a constructor with a parameter then he should create another constructor explicitly without a parameter"
        );

        add("What is a Class?",
                "All Java codes are defined in a Class. It has variables and methods. " +
                        "Variables are attributes which define the state of a class. " +
                        "Methods is a place where the exact business logic has to be done. It contains a set of statements (or) instructions to satisfy the particular requirement.");
        add("What is meant by the Local variable and the Instance variable?",
                "Local variables are defined in the method and scope of the variables that exist inside the method itself. Instance variable is defined inside the class and outside the method and the scope of the variables exists throughout the class.");
        add("What is an Object?",
                "An instance of a class is called an object. The object has state and behavior. Whenever the JVM reads the “new()” keyword then it will create an instance of that class");
        add("What is Inheritance?", "Inheritance means one class can extend to another class. So that the codes can be reused from one class to another class. The existing class is known as the Super class whereas the derived class is known as a sub class");
        add("What is Encapsulation?",
                "Purpose of Encapsulation: " + "Protects the code from others. " + "Code maintainability");
        add("What is meant by Method Overriding?",
                "Method overriding happens if the sub-class method satisfies the below conditions with the Super-class method: " +
                        "Method name should be the same " +
                        "The argument should be the same " +
                        "Return type should also be the same " +
                        "The key benefit of overriding is that the Sub-class can provide some specific information about that sub-class type than the super-class");
        add("What is meant by Overloading?", "Method overloading happens for different classes or within the same class. " +
                "For method overloading, sub-class method should satisfy the below conditions with the Super-class method (or) methods in the same class itself: " +
                "Same method name " +
                "Different argument types " +
                "There may be different return types");
    }

    @Override
    public String toString() {
        return "JavaQuestionRepository{" +
                "questionCollection=" + questionCollection +
                '}';
    }
}
