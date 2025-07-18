import com.codeborne.selenide.Configuration;
import data.Applications;
import data.Language;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
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
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(ints = {
            25, 16, 225
    })
    @ParameterizedTest(name = "Квадратный корень числа {0} получен корректно")
    @Tag("MATH")
    public void calcsetSiteCalculatesSquareRootCorrectly(int number){
        open("https://calcset.ru/calculator.php?category=math&calculator=square_root_calculator#result");
        $("input#number").setValue(String.valueOf(number)).pressEnter();
        $("div#result").shouldHave(text(String.valueOf(Math.sqrt(number))));
    }

    @CsvSource(value = {
            "физика , ЭТИ продолжает серию просветительских семинаров по физике",
            "математика , История",
            "информатика , Образовательная программа «Прикладная математика и информатика»"
    })

    @ParameterizedTest(name = "Для поискового запроса {0} первым результатом отображен текст {1}")
    @Tag("SMOKE")
    public void sstuSearchShowsArticlesCorrect(String searchQuery, String expectedText) {
        open("https://www.sstu.ru/");
        $(".fa-search").click();
        $("#inline-search__input").setValue(searchQuery).pressEnter();
        $(".search-page > a").shouldHave(text(expectedText));
    }

    @EnumSource(Applications.class)
    @ParameterizedTest(name = "Для скачивания приложения {0} кнопка отображена")
    @Tag("SMOKE")
    void rzdSiteShouldDisplayApplicationsSet(Applications apps){
    open("https://www.rzd.ru/");
        $$("[data-test-id='footer_contacts_container'] > li > a").shouldHave(size(5));
                $("[title='" + apps.applicationName + "']").shouldBe(visible);
    }

    static Stream<Arguments> sheremetyevoSiteHaveCorrectMenuItemsOnEngAndRus() {
        return Stream.of(
                Arguments.of(Language.RU, List.of("Вылет", "Прилет", "Пересадка")),
                Arguments.of(Language.ENG, List.of("Departures", "Arrivals", "Connections"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "На языке {0} отображены пункты меню {1}")
    @Tag("SMOKE")
    void sheremetyevoSiteHaveCorrectMenuItemsOnEngAndRus(Language language, List<String> menuItems) {
        open("https://www.svo.aero/en/main");
        $("#mat-select-0").click();
        $$(".mat-option-text").findBy(text(language.languageName)).click();
        $$("span.nav__name").shouldHave(texts(menuItems));
    }
}


