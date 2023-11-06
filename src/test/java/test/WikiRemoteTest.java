package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.*;


@Owner("Евгений Шевчук")
@Epic(value = "Тестирование мобильного приложения Wikipedia")
@Feature(value = "Новая функциональность")
@Story("Поиск")

public class WikiRemoteTest extends TestBase {

    SearchPage search = new SearchPage();
    SearchResultsPage resultSearch = new SearchResultsPage();
    ErrorResultPage errors = new ErrorResultPage();
    ArticlePage page = new ArticlePage();
    MainPage mainPage = new MainPage();
    SettingsPage settings = new SettingsPage();
    LanguagePanelPage language = new LanguagePanelPage();

    @Test
    @Severity(BLOCKER)
    @Tag("remote")
    @DisplayName("Проверка появления результатов поиска при выдаче")
    void successfulSearchTest() {
        step("Переходим в строку поиска и вводим название необходимой статьи", () -> {
            mainPage.goSearchLine();
            search.addValueSearchLine("Appium");
        });

        step("Проверяем что появились результаты поиска", () ->
                resultSearch.checkResultList()
        );
    }

    @Test
    @Severity(MINOR)
    @Tag("remote")
    @DisplayName("Проверка поиска")
    void checkErrorMessage() {
        step("Переходим в строку поиска и вводим название необходимой статьи", () -> {
            mainPage.goSearchLine();
            search.addValueSearchLine("Appium");
        });

        step("Проверяем что появились результаты поиска", () ->
                resultSearch.checkResultList()
        );

        step("Выбираем первую найденную статью", () ->
                resultSearch.clickFirstElementResultList()
        );

        step("Проверяем ошибку поиска", () ->
                errors.checkErrorResult()
        );
    }

    @Test
    @Severity(NORMAL)
    @Tag("remote")
    @DisplayName("Проверка выдачи валидной статьи при поиске")
    void qualitySearchTest() {
        step("Переходим в строку поиска и вводим название необходимой статьи", () -> {
            mainPage.goSearchLine();
            search.addValueSearchLine("Quality engineering");
        });

        step("Проверяем что появились результаты поиска", () ->
                resultSearch.checkResultList()

        );

        step("Выбираем первую найденную статью", () ->
                resultSearch.clickFirstElementResultList()
        );

        step("Проверяем валидность найденной статьи по тексту внутри", () -> {
            page.visibleTextInPage();
            page.findTextInPage("Quality engineering");
        });
    }

    @Test
    @Severity(NORMAL)
    @Tag("remote")
    @DisplayName("Добавление языка")
    void choiceLanguageTest() {
        step("Нажатие кнопки навигации", () ->
                mainPage.goNavigation()
        );

        step("Открываем меню настройки", () ->
                settings.settingsMenu()
        );

        step("Открываем панель выбора языка", () ->
                settings.languagePanel()
        );

        step("Выбираем язык", () ->
                language.choiceLanguage("Svenska")
        );

        step("Проверяем смену языка", () ->
                language.checkChangeLanguage("Svenska")
        );
    }
}