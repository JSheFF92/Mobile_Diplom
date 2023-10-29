package test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import static io.qameta.allure.Allure.step;


public class WikiRemoteTest extends TestBase {

    SearchPage search = new SearchPage();
    SearchResultsPage resultSearch = new SearchResultsPage();
    ErrorResultPage errors = new ErrorResultPage();
    ArticlePage page = new ArticlePage();
    MainPage mainPage = new MainPage();
    SettingsPage settings = new SettingsPage();
    LanguagePanelPage language = new LanguagePanelPage();

    @Test
    @Owner("Евгений Шевчук")
    @Epic(value = "Тестирование мобильного приложения Wikipedia")
    @Feature(value = "Поиск мобильного приложения Wikipedia")
    @Story("Поиск")
    @Tag("remote")
    @DisplayName("Выдача результатов поиска Wiki")
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
    @Owner("Евгений Шевчук")
    @Epic(value = "Тестирование мобильного приложения Wikipedia")
    @Feature(value = "Ошибки мобильного приложения Wikipedia")
    @Story("Статьи")
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
    @Owner("Евгений Шевчук")
    @Epic(value = "Тестирование мобильного приложения Wikipedia")
    @Feature(value = "Статьи мобильного приложения Wikipedia")
    @Story("Поиск")
    @Tag("remote")
    @DisplayName("Поиск статьи")
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

        step("Находим название статьи", () -> {
                page.visibleTextInPage();
                page.findTextInPage("Quality engineering");
        });
    }

    @Test
    @Owner("Евгений Шевчук")
    @Epic(value = "Тестирование мобильного приложения Wikipedia")
    @Feature(value = "Языки мобильного приложения Wikipedia")
    @Story("Выбор языка")
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