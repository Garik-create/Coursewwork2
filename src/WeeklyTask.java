import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatable {

    public WeeklyTask(String name,
                      String description,
                      String type,
                      Integer repeatable,
                      LocalDateTime createDateTime) {
        super(name, description, type, repeatable, createDateTime);
    }

    @Override
    public LocalDateTime getNextDateTime(Task task) {
        return task.getCreateDateTime().plusWeeks(1);
    }

    @Override
    public boolean isAvailable(LocalDate query) {
        return query.isAfter(this.getCreateDateTime().toLocalDate())
                && query.getDayOfWeek() == this.getCreateDateTime().getDayOfWeek();
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
//
//    @Override
//    public LocalDateTime getCreateDateTime() {
//        return super.getCreateDateTime();
//    }
//
//    @Override
//    public Integer getTaskId() {
//        return super.getTaskId();
//    }
//
//    @Override
//    public String getName() {
//        return super.getName();
//    }
//
//    @Override
//    public String getDescription() {
//        return super.getDescription();
//    }
//
//    @Override
//    public Integer getType() {
//        return super.getType();
//    }
//
//    @Override
//    public Integer getRepeatable() {
//        return super.getRepeatable();
//    }
}
