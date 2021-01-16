package steps;

public enum Days {
    понедельник("Понедельник"),
    вторник("Вторник"),
    среда("Среда"),
    четверг("Четверг"),
    пятница("Пятница"),
    суббота("Суббота"),
    воскресенье("Воскресенье");

    public String value;

    public String getValue() {
        return value;
    }

    Days(String value) {
        this.value = value;
    }
}
