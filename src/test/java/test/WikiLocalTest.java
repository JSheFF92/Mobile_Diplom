package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

public class WikiLocalTest extends TestBase {

    SearchPage search = new SearchPage();
    MainPage mainPage = new MainPage();
    SearchResultsPage resultSearch = new SearchResultsPage();
    StartOnePage pageOne = new StartOnePage();
    StartTwoPage pageTwo = new StartTwoPage();
    StartThreePage pageThree = new StartThreePage();
    StartFourPage pageFour = new StartFourPage();
    EditsPage edits = new EditsPage();
    LoginPage login = new LoginPage();
    ArticlePage page = new ArticlePage();
    LanguagePanelPage languagePanel = new LanguagePanelPage();

    @Test
    @Tag("local")
    void successfulSearchTest() {
        back();
        step("Переходим в строку поиска и вводим название необходимой статьи", () -> {
            mainPage.goSearchLine();
            search.addValueSearchLine("Appium");
        });

        step("Проверяем что появились результаты поиска", () ->
                resultSearch.checkResultList()
        );
    }

    @Test
    @Tag("local")
    @DisplayName("Тест 4 стартовых страниц wiki")
    void fourPages() {
        step("Проверка текста на первой странице", () -> {
            pageOne.textOnePage("The Free Encyclopedia\n" +
                            "…in over 300 languages");
            pageOne.nextPage();
        });

        step("Проверка текста на второй странице", () -> {
            pageTwo.textTwoPage("New ways to explore");
            pageTwo.nextPage();

        });

        step("Проверка текста на третьей странице", () -> {
            pageThree.textThreePage("Reading lists with sync");
            pageThree.nextPage();
        });

        step("Проверка текста на четвертой странице и нажатие на кнопку принятия условий", () -> {
            pageFour.textFourPage("Send anonymous data");
            pageFour.acceptButton();
        });
    }

    @Test
    @Tag("local")
    @DisplayName("Проверка присутствия кнопки логина через edits")
    void logInButtonTest() {
        back();
        step("Переход в меню edits", () ->{
            mainPage.goEdits();
        });

        step("Переход в меню логина", () ->
            edits.goLoginPage()
        );

        step("Проверяем текст кнопки Log in", () ->
            login.checkTextLoginButton("Log in")
        );
    }

    @Test
    @Tag("local")
    void qualitySearchTest() {
        back();
        step("Переходим в строку поиска и вводим название необходимой статьи", () -> {
            mainPage.goSearchLine();
            search.addValueSearchLine("Quality engineering");
        });

        step("Проверяем что поиск не пустой", () ->
                        resultSearch.checkResultList()
        );

        step("Выбираем первую найденную статью", () -> {
            resultSearch.clickFirstElementResultList();
        });

        step("Находим название статьи", () ->
                page.localVisibleTextInPage("Quality engineering")
        );
    }

    @Test
    @Tag("local")
    @DisplayName("Добавление и удаление языка")
    void addAndDeleteLanguageTest() {
        back();
        step("Переходим в строку поиска", () ->
                        mainPage.goSearchLine()
        );

        step("Добавление языка", () -> {
            search.goLanguagePage();
            languagePanel.addLanguageButton("Add language");
            languagePanel.localChoiceLanguage("Русский");
        });

        step("Проверяем, что язык добавил на страницу", () ->
                languagePanel.checkChangeLanguage("Русский")
        );

        step("Переходим в меню удаления языка", () ->
            languagePanel.deletedMenu()
        );

        step("Нажимаем кнопку удаления", () ->
            languagePanel.deletedButton()
        );

        step("Выбираем язык который собираемся удалить", () ->
                languagePanel.choiceLanguageDeleted("Русский")
        );

        step("Нажимаем кнопку удаления", () ->
                languagePanel.clickDeletedButton()
        );

        step("Подтверждаем удаление", () ->
                languagePanel.confirmDeletedButton()
        );
    }
}
