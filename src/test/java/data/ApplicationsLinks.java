package data;

import java.util.List;

public enum ApplicationsLinks {
/*    RUSTORE("https://apps.rustore.ru/app/ru.rzd.pass"),
    GOOGLEPLAY("https://play.google.com/store/apps/details?id=ru.rzd.pass&hl=ru"),
    APPGALLERY("https://appgallery.huawei.com/#/app/C101979029"),
    APPSTORE("https://www.rzd.ru/ru/9848/page/103290?id=20322#main-header"),
    WEBAPPLICATION("https://www.rzd.ru/ru/9848/page/103290?id=20432#main-header"),*/

/*    NAMEOFSTORE("RuStore", "Google Play", "Huawei App gallery", "App Store", "Веб приложение"),
    
    LINKONSTORE("https://apps.rustore.ru/app/ru.rzd.pass", "https://play.google.com/store/apps/details?id=ru.rzd.pass&hl=ru"
            "https://appgallery.huawei.com/#/app/C101979029", "https://www.rzd.ru/ru/9848/page/103290?id=20322#main-header",
            "https://www.rzd.ru/ru/9848/page/103290?id=20432#main-header");*/

    // private final String nameOfStore;
/*    public final String linkOnApp;

    ApplicationsLinks(String linkOnApp) {
        // this.nameOfStore = nameOfStore;
        this.linkOnApp = linkOnApp;
    }*/

    RUSTORE("RuStore", "https://apps.rustore.ru/app/ru.rzd.pass"),
    GOOGLEPLAY("Google Play", "https://play.google.com/store/apps/details?id=ru.rzd.pass&hl=ru");

    public String nameOfStore;
    public String linkOnApp;

    ApplicationsLinks(String linkOnApp, String nameOfStore) {
        this.nameOfStore = nameOfStore;
        this.linkOnApp = linkOnApp;

    }
}
