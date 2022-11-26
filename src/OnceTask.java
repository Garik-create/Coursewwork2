import java.time.LocalDate;
import java.time.LocalDateTime;

public class OnceTask extends Task implements Repeatable {

    public OnceTask(String name,
                    String description,
                    String type,
                    Integer repeatable,
                    LocalDateTime createDateTime) {
        super(name, description, type, repeatable, createDateTime);
    }

    public boolean isAvailable(LocalDate query) {
        return this.getCreateDateTime().toLocalDate() == query;

    }

    @Override
    public LocalDateTime getCreateDateTime() {
        return super.getCreateDateTime();
    }

    @Override
    public Integer getTaskId() {
        return super.getTaskId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public Integer getRepeatable() {
        return super.getRepeatable();
    }

    @Override
    public LocalDateTime getNextDateTime(Task task) {
        return task.getCreateDateTime();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


