package data;

public enum ApplicationsLinks {
    RUSTORE("https://apps.rustore.ru/app/ru.rzd.pass"),
    GOOGLEPLAY("https://play.google.com/store/apps/details?id=ru.rzd.pass&hl=ru"),
    APPGALLERY("https://appgallery.huawei.com/#/app/C101979029"),
    APPSTORE("https://www.rzd.ru/ru/9848/page/103290?id=20322#main-header"),
    WEBAPPLICATION("https://www.rzd.ru/ru/9848/page/103290?id=20432#main-header");

    public final String linkOnApp;

    ApplicationsLinks(String linkOnApp) {
        this.linkOnApp = linkOnApp;
    }
}
