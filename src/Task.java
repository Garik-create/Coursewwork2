import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {
    private String name;
    private String description;
    private String type;
    private Integer repeatable;
    private final LocalDateTime createDateTime;
    private final Integer taskId;
    private static int count;

    public Task(String name,
                String description,
                String type,
                Integer repeatable,
                LocalDateTime createDateTime) {
        setName(name);
        setDescription(description);
        setType((type));
        setRepeatable(repeatable);
        this.taskId = count++;
        this.createDateTime = createDateTime;
    }

    public abstract boolean isAvailable(LocalDate query);

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new RuntimeException("Введено некорректное имя задачи!");
        }
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        if (description != null && !description.isBlank()) {
            this.description = description;
        } else {
            throw new RuntimeException("ВВедите описание задачи!");
        }
        return description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRepeatable() {
        return repeatable;
    }

    public Integer setRepeatable(Integer repeatable) {
        if (repeatable > 0 && repeatable <= 5) {
            this.repeatable = repeatable;
        } else {
            throw new RuntimeException("Введите '1' для 'однократной' задачи, '2' для 'ежедневной'\n" +
                    " задачи, '3' для 'еженедельной' задачи, '4' для 'ежемесячной' задачи,\n" +
                    "'5' для 'ежегодной' задачи.");
        }
        return repeatable;
    }

    @Override
    public String toString() {
        return "Задача: "+name+", описание: "+description
                +", создана: "+createDateTime+", тип: "+type+", повторяемость: "
                +repeatable;
    }
}
