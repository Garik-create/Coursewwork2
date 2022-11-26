public enum Type {
    PERSONAL("личная"),
    WORK("рабочая");

    private final String taskType;

    Type(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }
}
