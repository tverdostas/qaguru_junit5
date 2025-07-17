import com.codeborne.selenide.Configuration;
import data.Applications;
import data.Language;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ParameterizedTests {

    @AfterEach
    public void OpenBrowser() {
        //Configuration.baseUrl = "https://www.sstu.ru/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(ints = {
            25, 16, 225
    })
    @ParameterizedTest
    public void mathTest(int number){
        open("https://calcset.ru/calculator.php?category=math&calculator=square_root_calculator#result");
        $("input#number").setValue(String.valueOf(number)).pressEnter();
        $("div#result").shouldHave(text(String.valueOf(Math.sqrt(number))));
    }

    @CsvSource(value = {
            "физика , ЭТИ продолжает серию просветительских семинаров по физике",
            "математика , История",
            "информатика , Образовательная программа «Прикладная математика и информатика»"
    })

    @ParameterizedTest(name="Для поискового запроса {0} первым результатом должен быть текст {1}")
    @DisplayName("ghfh")
    public void searchTest(String searchQuery, String expectedText) {
        open("https://www.sstu.ru/");
        $(".fa-search").click();
        $("#inline-search__input").setValue(searchQuery).pressEnter();
        $(".search-page > a").shouldHave(text(expectedText));
    }


    @ValueSource(strings = {
    "Университет", "Управление", "Образование", "Наука", "Сотрудничество", "Общественная жизнь"
    })
    @ParameterizedTest
    public void hoverTest(String nameOfMenuButton){
        open("https://www.sstu.ru/");
        $("li.root a").shouldHave(text(nameOfMenuButton));
    }
    @EnumSource(Applications.class)
    @ParameterizedTest
    void rzdSiteShouldDisplayTextInTwoLanguages(Applications apps){
    open("https://www.rzd.ru/");
        $$("[data-test-id='footer_contacts_container'] > li > a").shouldHave(size(5));
                $("[title='" + apps.applicationName + "']").shouldBe(visible);
    }


/*    static Stream<Arguments> rzdSiteShouldDisplayLinksOnAllMarkets(){
return Stream.of(
  Arguments.of(ApplicationsLinks.RUSTORE.nameOfStore, ApplicationsLinks.RUSTORE.linkOnApp));
    }

    @ParameterizedTest
    void rzdSiteShouldDisplayLinksOnAllMarkets(ApplicationsLinks applicationsLinks){
        $("[title='" + ApplicationsLinks.RUSTORE.nameOfStore + "']").shouldHave(attribute(String.valueOf(href(ApplicationsLinks.RUSTORE.linkOnApp))));
    }
}*/

/*

    static Stream<Arguments> rzdSiteShouldDisplayLinksOnAllMarkets(){
return Stream.of(
  Arguments.of(DropdownLists.TRAINSANDROUTES, List.of("Скоростные поезда", "Высокоскоростные поезда (новый проект)",
          "Фирменные поезда", "Дневные поезда")),
        Arguments.of(DropdownLists.TARIFFSANDPROMOTIONS, List.of("Акции", "Льготы"))
);
    }

    @ParameterizedTest
    void rzdSiteShouldDisplayLinksOnAllMarkets(DropdownLists dropdownLists, List<String> subMenuItems){
    $(byText("Поезда и маршруты")).parent()
    }
}
*/

    static Stream<Arguments> sheremetyevoSiteHaveCorrectMenuItemsOnEngAndRus() {
        return Stream.of(
                // хм, не знаю как это написать, если нужна переменная типа enum, то не нужно дергать его конкретный метод, достаточно обращения к конкретному элементу
                Arguments.of(Language.RU, List.of("Вылет", "Прилет", "Пересадка")),
                Arguments.of(Language.ENG, List.of("Departures", "Arrivals", "Connections"))
        );
    }

    @MethodSource
    @ParameterizedTest
    void sheremetyevoSiteHaveCorrectMenuItemsOnEngAndRus(Language language, List<String> menuItems) {
        // не знаю, должен ли браузер перезапускаться по заданию каждый раз, но только сайт загружается, если что
        open("https://www.svo.aero/en/main");
        $("#mat-select-0").click();
        $$(".mat-option-text").findBy(text(language.languageName)).click();
        $$("span.nav__name").shouldHave(texts(menuItems));
    }

    // Кажется, что на все вопросы ответил

}


