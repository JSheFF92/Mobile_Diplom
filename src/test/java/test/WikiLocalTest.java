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
    @DisplayName("Проверка появления результатов поиска при выдаче")
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
    @DisplayName("Проверка 4 стартовых страниц wiki")
    void fourPages() {
        step("Проверяем текст на первой странице", () -> {
            pageOne.textOnePage("The Free Encyclopedia\n" +
                            "…in over 300 languages");
            pageOne.nextPage();
        });

        step("Проверяем текст на второй странице", () -> {
            pageTwo.textTwoPage("New ways to explore");
            pageTwo.nextPage();

        });

        step("Проверяем текст на третьей странице", () -> {
            pageThree.textThreePage("Reading lists with sync");
            pageThree.nextPage();
        });

        step("Проверяем текст на четвертой странице и нажимаем на кнопку принятия условий", () -> {
            pageFour.textFourPage("Send anonymous data");
            pageFour.acceptButton();
        });
    }

    @Test
    @Tag("local")
    @DisplayName("Проверка присутствия кнопки логина на странице при переходе через edits")
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
    @DisplayName("Проверка поиска конкретной статьи")
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

        step("Проверяем валидность найденной статьи по тексту внутри", () ->
                page.localVisibleTextInPage("Quality engineering")
        );
    }

    @Test
    @Tag("local")
    @DisplayName("Проверка добавления и удаления языка")
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
        step("Проверяем отсутствие языка в выборе", () ->
                languagePanel.checkNotChangeLanguage("Русский")
        );
    }
}
