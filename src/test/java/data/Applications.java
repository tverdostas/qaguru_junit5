package data;

public enum Applications {
    RUSTORE("RuStore"),
    GOOGLEPLAY("Google Play"),
    APPGALLERY("Huawei App gallery"),
    APPSTORE("App Store"),
    WEBAPPLICATION("Веб приложение");

    public final String applicationName;

    Applications(String applicationName) {
        this.applicationName = applicationName;
    }
}
