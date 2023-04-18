package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {

    @Test
    @DisplayName("Тест на проверку названия Issue - Чистый Selenide (с Listener)")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("MikhailLbdv/QAGuru_HW_10");
        $(".header-search-input").submit();

        $(linkText("MikhailLbdv/QAGuru_HW_10")).click();
        $("#issues-tab").click();
        $(withText("issues_test")).should(Condition.exist);

    }
}
