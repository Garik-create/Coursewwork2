import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task implements Repeatable {

    public YearlyTask(String name,
                      String description,
                      String type,
                      Integer repeatable,
                      LocalDateTime createDateTime) {
        super(name, description, type, repeatable, createDateTime);
    }

    @Override
    public LocalDateTime getNextDateTime(Task task) {
        return task.getCreateDateTime().plusYears(1);
    }

    @Override
    public boolean isAvailable(LocalDate query) {
        return query.isAfter(this.getCreateDateTime().toLocalDate()) && query.getDayOfYear() ==
                this.getCreateDateTime().getDayOfYear();
    }
}
