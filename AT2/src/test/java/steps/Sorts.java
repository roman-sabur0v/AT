package steps;

public enum Sorts {

    Дешевле("1"),
    Дороже("2"),
    По_дате("104"),
    По_умолчанию("101");

    private String value;

    public String getValue() {
        return value;
    }

    Sorts(String value) {
        this.value = value;
    }
}
