import java.time.LocalDateTime;

public interface Repeatable {

    LocalDateTime getNextDateTime(Task task);

//    boolean isAvailable(LocalDateTime localDate);

}
