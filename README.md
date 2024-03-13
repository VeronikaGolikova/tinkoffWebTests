# Проект по автоматизации тестовых сценариев для Tinkoff
<p align="center">
<a href="https://www.tinkoff.ru/"><img title="Логотип Tinkoff" src="media/logos/tinkoffLogo.png"></a>
</p>

## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-тестов-в-selenoid)

## :computer: Используемый стек


| Java                                                                                                      | IntelliJ  <br>  Idea                                                                                               | GitHub                                                                                                     | JUnit 5                                                                                                           | Gradle                                                                                                     | Selenide                                                                                                         | Selenoid                                                                                                                  | Allure <br> Report                                                                                                         |  Jenkins                                                                                                        |   Jira                                                                                                              | Telegram                                                                                                            |                                                                                            Allure <br> TestOps 
|:----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------:|
| <a href="https://www.java.com/"><img src="media/logos/java-original-wordmark.svg" width="50" height="50"  alt="Java"/></a>  | <a href="https://www.jetbrains.com/idea/"><img src="media/logos/intellij-original.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="media/logos/github-original-wordmark.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/logos/junit-original-wordmark.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/logos/gradle-original.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://selenide.org/"><img src="media/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> | <a href="https://aerokube.com/selenoid/"><img src="media/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> | <a href="https://github.com/allure-framework"><img src="media/logos/Allure.svg" width="50" height="50"  alt="Allure"/></a> |<a href="https://www.jenkins.io/"><img src="media/logos/jenkins-original.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://www.atlassian.com/software/jira/"><img src="media/logos/jira-original-wordmark.svg" width="50" height="50" alt="Java" title="Java"/></a> | <a href="https://web.telegram.org/"><img src="media/logos/Telegram.svg" width="50" height="50" alt="Telegram"/></a> | <a href="https://qameta.io/"><img src="media\logos\Allure_TO.svg" width="50" height="50" alt="Allure_TO"/></a> |

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования <code>Selenide</code>. 
- В качестве сборщика был использован - <code>Gradle</code>.  
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. 
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :scroll: Реализованные проверки:

- Проверка наличия заголовка на главой странице
- Проверка перехода в раздел 'дебетовые карты' с главной страницы сайта
- Проверка перехода к категории карты по прямой ссылке
- Проверка фильтрации карт для геймеров
- Проверка фильтрации карт для покупок
- Проверка фильтрации карт для путешественников
- Проверка фильтрации карт для автомобилиста
- Проверка фильтрации карт для покупок
- Проверка фильтрации карт для преимальных клиентов
- Проверка заголовков для каждой категории карт

## :arrow_forward: Запуск автотестов

### Локальный запуск тестов из терминала (с параметрами по умолчанию)
```
gradle clean regress_with_owner
```
### Запуск тестов из Jenkins (с указанием параметров)
```
gradle clean regress_with_owner -Denvironment=remote
```
При необходимости также можно переопределить параметры запуска

```
clean
regress_with_owner
-Denvironment=${ENVIRONMENT}
-Dbrowser=${BROWSER}
-Dbrowser_version=${BROWSER_VERSION}
-Dbrowser_size=${BROWSER_SIZE}
-DremoteUrl=${REMOTE_URL}
```

<p align="center">
<img title="Запуск с параметрами" src="media/screenshots/JenkinsStart-new.png">
</p>

### Параметры сборки

* <code>ENVIRONMENT</code> – параметр, который определяет локальный или удаленный запуск. По умолчанию – <code>удаленно</code>.
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По умолчанию – <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По умолчанию – <code>100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию – <code>1920x1080</code>.
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты. По умолчанию – <code>https://user1:1234@selenoid.autotests.cloud/wd/hub</code>

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logos/jenkins-original.svg"> [Сборка](https://jenkins.autotests.cloud/job/024_Kwlad1ck_DromRu/) в Jenkins

Для запуска сборки необходимо перейти в раздел <code>Build with parameters</code> и нажать кнопку <code>Build</code>.
<p align="center">
<img title="Сборка в Jenkins" src="media/screenshots/Jenkins.png">
</p>


После выполнения сборки, в блоке <code>Build History</code> напротив номера сборки появятся значок <code>Allure Report</code>, при клике на который откроется страница с сформированным html-отчетом и тестовыми артефактами.

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logos/Allure.svg"> [Пример](https://jenkins.autotests.cloud/job/024_Kwlad1ck_DromRu/10/allure/) Allure-отчета
### Основаня страница отчета


<p align="center">
<img title="Общий вид отчёта Allure" src="media/screenshots/AllureOverview.png">
</p>

### Результат выполнения автотестов

<p align="center">
<img title="Список тест-кейсов в отчёте Allure" src="media/screenshots/AllureSuites.png">
</p>

### Графики

<p align="center">
<img title="Графики прохождения сборки в отчёте Allure" src="media/screenshots/AllureCharts.png">
</p>

<p align="center">
<img width="70%" title="Уведомление в Telegram" src="media/screenshots/TelegramAlerts.png">
</p>

После завершения сборки и прохождения всех тестовых сценариев в [Telegram канал](https://t.me/publicDromAlerts) приходит оповещение с отчетом о результатах прохождения автотестов.


## <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logos/Selenoid.svg"> Видео пример запуска автотестов в Selenoid

В отчетах Allure для каждого теста прикреплён не только скриншот, но и видео прохождения теста, записанное Selenoid.
<p align="center">
  <img title="Видео записанное Selenoid" src="media/video/video.gif">
</p>
