<h1 >Проект по автоматизации тестирования мобильного приложения <a href="https://github.com/wikimedia/apps-android-wikipedia/">Wikipedia</a></h1>

<p align="center">  
<img src="media/logo/WikiLogo.png" alt="MainLogo" width="950"/></a>  
</p>

# 🧾 Содержание:

- <a href="#tools">Технологии и инструменты</a>
- <a href="#checking">Список проверок, реализованных в автоматизированных тест-кейсах</a>
- <a href="#jenkins">Сборка в Jenkins</a>
- <a href="#console">Запуск тестов (Из терминала)</a>
- <a href="#allureReport">Allure-отчет</a>
- <a href="#allure">Интеграция с Allure TestOps</a>
- <a href="#jira">Интеграция с Jira</a>
- <a href="#tg"> Уведомление в Telegram о результатах выполнения автоматизированных тестов</a>
- <a href="#movie">Видеопример прохождения тестов Browserstack</a>

<a id="tools"></a>

## 🔨 Технологии и инструменты:

| Java                                                                                                    | IntelliJ  <br>  Idea                                                                                               | GitHub                                                                                                     | JUnit 5                                                                                                          | Gradle                                                                                                    | Allure <br> Report                                                                                                        | Appium                                                                                                   | Browserstack                                                                                                                   | Jenkins                                                                                                         | Jira                                                                                                                                  | Telegram                                                                                                         |                                                                                            Allure <br> TestOps |
|:--------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------:|
| <a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  | <a href="https://github.com/allure-framework"><img src="media/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> | <a href="https://appium.io//"><img src="media/logo/Appium.svg" width="50" height="50" alt="Appium"/></a> | <a href="https://www.browserstack.com/"><img src="media/logo/Browserstack.svg" width="50" height="50" alt="Browserstack"/></a> | <a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://www.atlassian.com/software/jira/"><img src="media/logo/Jira.svg" width="50" height="50" alt="Jira" title="Jira"/></a> | <a href="https://web.telegram.org/"><img src="media/logo/Telegram.svg" width="50" height="50" alt="Telegram"/></a> | <a href="https://qameta.io/"><img src="media/logo/Allure_TO.svg" width="50" height="50" alt="Allure_TO"/></a> |

<a id="checking"></a>

## 🏁 Реализованные проверки:

### При запуске локально (local):

- Проверка появления результатов поиска при выдаче
- Проверка 4 стартовых страниц wiki
- Проверка присутствия кнопки логина на странице при переходе через edits
- Проверка поиска конкретной статьи
- Проверка добавления и удаления языка

### При запуске удаленно (remote):

- Проверка появления результатов поиска при выдаче
- Проверка поиска
- Проверка выдачи валидной статьи при поиске
- Добавление языка

<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="media/logo/Jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/Wiki_Mobile_EVShev/)

<p align="center">  
<img src="media/screen/JenkinsDashboard.png" alt="Jenkins" width="950"/></a>  
</p>

## 🚀 Команда для запуска автотестов из терминала

Запуск локально (local) на эмуляторе:

```bash  
gradle clean local_test -DdeviceHost=local
```

> Внимание! Для запуска локальных тестов на компьютере должны быть установлены Android Studio, Appium Server и Appium

Запуск удаленно (remote) на Browserstack:

```bash  
gradle clean remote_test -DdeviceHost=remote
```

> Для запуска необходимо нажать "Build now"

<a id="allureReport"></a>
## <img alt="Allure" height="25" src="media/logo/Allure.svg" width="25"/> </a>Интеграция с <a target="_blank" href="https://jenkins.autotests.cloud/job/Wiki_Mobile_EVShev/4/allure/">Allure Report</a>

## 🖨️ Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/screen/Overview.png" width="850">  
</p>  

## 📄 Тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screen/Suites.png" width="850">   
</p>

## 📊 Графики

<p align="center">   
<img title="Allure Graphics1" src="media/screen/Graf1.png" width="850">  
<img title="Allure Graphics2" src="media/screen/Graf2.png" width="850">  
</p>

<a id="allure"></a>
## <img alt="Allure_TO" height="25" src="media/logo/Allure_TO.svg" width="25"/> </a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/3734/dashboards">Allure TestOps</a>

## 🖨️ Основная страница отчёта

<p align="center">  
<img title="Allure TestOps Dashboard" src="media/screen/OpsDashView.png" width="850">  
</p>  

## 📄 Авто и Ручные тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screen/OpsCasesView.png" width="850">  
</p>

<a id="jira"></a>
## <img alt="Allure" height="25" src="media/logo/Jira.svg" width="25"/></a> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-923">Jira</a>

<p align="center">  
<img title="Jira" src="media/screen/JiraView.png" width="">  
</p>

____
<a id="tg"></a>
## <img alt="Allure" height="25" src="media/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота

____
<p align="center">  
<img title="Telegram notifications" src="media/screen/Tg.png" width="550">  
</p>

____
<a id="movie"></a>
## <img alt="Browserstack" height="25" src="media/logo/Browserstack.svg" width="25"/></a> Видеопример выполнения теста Browserstack

____
<p align="center">
<img title="Browserstack Video" src="media/screen/ErrorMovie.gif" width="350" height="350"  alt="video">   
</p>

