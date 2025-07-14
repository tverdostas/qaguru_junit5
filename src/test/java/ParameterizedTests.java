import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
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

/*    @ValueSource(strings = {
    "Университет", "Управление", "Образование", "Наука", "Сотрудничество", "Общественная жизнь"
    })
    @ParameterizedTest
    public void hoverTest(String nameOfMenuButton){
        open("https://www.sstu.ru/");
        $("li.root a").shouldHave(text(nameOfMenuButton));
    }*/

    @CsvSource(value = {
            "физика , ЭТИ продолжает серию просветительских семинаров по физике",
            "математика , История",
            "информатика , Образовательная программа «Прикладная математика и информатика»"
    })

    @ParameterizedTest(name="Для поискового запроса {0} первым результатом должен быть текст {1}")
    @DisplayName("")
    public void searchTest(String searchQuery, String expectedText) {
        open("https://www.sstu.ru/");
        $(".fa-search").click();
        $("#inline-search__input").setValue(searchQuery).pressEnter();
        $(".search-page > a").shouldHave(text(expectedText));
    }
}
