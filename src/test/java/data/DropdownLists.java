package data;

public enum DropdownLists {

    TRAINSANDROUTES("Поезда и маршруты"),
    TARIFFSANDPROMOTIONS("Услуги и сервисы"),
    RZHDBONUS("РЖД Бонус"),
    RULES("Правила"),
    INFO("Информация"),
    SITEMAP("Карта сайта");

    public final String menuItems;

    DropdownLists(String menuItems){
        this.menuItems = menuItems;
    }
}
