package steps;

public enum Categories {

    Автомобили("9"),
    Мотоциклы_и_мототехника("14"),
    Грузовики_и_спецтехника("81"),
    Водный_транспорт("11"),
    Запчасти_и_аксессуары("10"),
    Квартиры("24"),
    Комнаты("23"),
    Дома_дачи_коттетжи("25"),
    Земельные_участки("26"),
    Гаражи_и_машиноместа("85"),
    Коммерческая_недвижимость("42"),
    Недвижимость_за_рубежом("86"),
    Вакансии("111"),
    Резюме("112"),
    Услуги("114"),
    Одежда_обувь_аксессуары("27"),
    Детская_одежда_и_обувь("29"),
    Товары_для_детей_и_игрушки("30"),
    Часы_и_украшения("28"),
    Красота_и_здоровье("88"),
    Бытовая_техника("21"),
    Мебель_и_интерьер("20"),
    Посуда_и_товары_для_кухни("87"),
    Продукты_питания("82"),
    Ремонт_и_строительство("19"),
    Растения("106"),
    Аудио_и_видео("32"),
    Игры_приставки_и_программы("97"),
    Настольные_компьютеры("31"),
    Ноутбуки("98"),
    Оргтехника_и_расходники("оргтехника", "99"),
    Планшеты_и_электронные_книги("96"),
    Телефоны("84"),
    Товары_для_компьютера("101"),
    Фототехника("105"),
    Билеты_и_путешествия("33"),
    Велосипеды("34"),
    Книги_и_журналы("83"),
    Коллекционирование("36"),
    Музыкальные_инструменты("38"),
    Охота_и_рыбалка("102"),
    Спорт_и_отдых("39"),
    Собаки("89"),
    Кошки("90"),
    Птицы("91"),
    Аквариум("92"),
    Другие_животные("93"),
    Товары_для_животых("94"),
    Готовый_бизнес("116"),
    Оборудование_для_бизнеса("40");

    private String id;
    public String getId() {
        return id;
    }

    private String name;
    public String getName() { return name; }

    Categories(String id) {
        this.id = id;
        this.name=this.toString();
    }

    Categories(String name, String id) {
        this.name=name;
        this.id=id;
    }

    public static Categories returnCategoryByName(String name) {
        for (Categories category: values()) {
            if (category.getName().equalsIgnoreCase(name))
                return category;
        }
        throw new IllegalArgumentException();
    }
}