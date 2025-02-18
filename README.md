# Dira
[![CodeFactor](https://www.codefactor.io/repository/github/albatovk/dira/badge)](https://www.codefactor.io/repository/github/albatovk/dira) [![codebeat badge](https://codebeat.co/badges/62a80729-e763-4c24-b243-59d9138c0f75)](https://codebeat.co/projects/github-com-albatovk-dira-master)
[![CI Build and Test](https://github.com/AlbatovK/Dira/actions/workflows/main.yml/badge.svg)](https://github.com/AlbatovK/Dira/actions/workflows/main.yml)
# Что из себя представляет Dira?
Android-приложение Directa (сокр. Dira) - это планер, который
способен улучшить жизнь пользователей. Он позволяет структурировать их ежедневные задачи и поддерживать уровень их мотивации за счёт соревновательного духа. Именно наличие соревновательной системы выделяет наш проект на фоне других.
# Как же это выглядит?
Каждый день пользователь может выбрать в свой список ежедневных дел определённые таски из списка предложенных. Затем, когда он выполняет одно из своих заданий, он отмечает его выполненным, после чего ему начисляются очки.
Приложение позволяет как составить свой собственный план на день, так и импортировать его у ваших друзей, которых вы можете добавить в приложении.
# Для чего нужны очки?
Очки пользователя позволяют ему участвовать в системе рейтингов и лиг, которые позволяют соревноваться с другими пользователями, улучшать свои результаты и повышать заинтересованность в достижении целей.
# Что в итоге?
Таким образом, важнейшей задачей Dir-ы является мотивирование пользователей на выполнение ежедневных дел, благодаря чему они развивают свои soft-skills. Мы верим, что наше приложение поможет людям, которые не могут самостоятельно планировать свой распорядок дня и не обладают самодисциплиной, стать лучшей версией себя, а те, кто уже обладает достаточно развитыми soft-skills, получат дополнительную мотивацию и дополнительный интерес развиваться дальше.

# Техническая характеристика проекта
Проект состоит из Android-приложения, серверной части [(ссылка на репозиторий)](https://github.com/AlbatovK/DiraServer) и сторонних сервисов, добавляющих функционал в приложение.
* Стэк технологий
    * Kotlin Coroutines - выполнение асинхронных операций для работы с сетью
    * Retrofit - быстрый и удобный доступ к API со стороны клиента
    * Spring Boot Framework - web-приложение развёрнутое на хостинге [(ссылка на сервер)](https://secret-escarpment-88160.herokuapp.com) Heroku
    * Swagger2 - автоматическое создание документации API [(ссылка на документацию)](https://secret-escarpment-88160.herokuapp.com/swagger-ui.html)
    * Google Firebase Firestore - серверная документоориентированная NoSql база данных
    * Firebase Auth - аутенфикация пользователей
    * SharedPreferences - хранение временных данных пользователя на устройстве
    * Android Jetpack
        * Fragment - использование нескольких экранов в рамках одной активности
        * Navigation - навигация между фрагментами в рамках одной активности
        * Navigation SafeArgs Plugin - безопасная передача данных между фрагментами
        * Lifecycle - обработка событий на основе жизненного цикла приложения
        * ViewModel - хранение и использование данных относящихся к UI в привязке к жизненному циклу представления
        * RecyclerView - представление данных в виде интерактивного списка
        * ViewBinding - современный способ доступа к элементам разметки
* Современная архитектура
    * Многоуровневая архитектура
    * Паттерн проектирования MVVM на стороне клиента
    * Spring MVС на стороне сервера
    * Koin - Инъекция зависимостей
    * JUnit4 и Espresso - тестирование
* Continious Integration
    * GitHub Actions - сборка и анализ артефакта приложения с помощью Gradle
    * Автоматический анализ кода с помощью сторонних сервисов (Codebeat, Codefactor)
* UI
    * Material design
    * TapTargetView library - интерактивные подсказки 

# Базовая структура
![](https://github.com/AlbatovK/KQuiz/blob/master/assets/circles.drawio.svg?raw=true)

# Слои приложения
![](https://github.com/AlbatovK/KQuiz/blob/master/assets/layers.drawio.svg?raw=true)

# Структура интерфейса
![](https://github.com/AlbatovK/Dira/blob/master/assets/dirascheme.drawio.svg?raw=true)

# Скриншоты работы приложения
![](https://github.com/AlbatovK/Dira/blob/master/assets/enter.jpg?raw=true)       | ![](https://github.com/AlbatovK/Dira/blob/master/assets/register.jpg?raw=true)       |
| -------------- | -------------- |
| ![](https://github.com/AlbatovK/Dira/blob/master/assets/welcome.jpg?raw=true)   | ![](https://github.com/AlbatovK/Dira/blob/master/assets/main.jpg?raw=true)    |
| ![](https://github.com/AlbatovK/Dira/blob/master/assets/note_list.jpg?raw=true) | ![](https://github.com/AlbatovK/Dira/blob/master/assets/note_choose.jpg?raw=true) |
![](https://github.com/AlbatovK/Dira/blob/master/assets/user_list.jpg?raw=true) | ![](https://github.com/AlbatovK/Dira/blob/master/assets/search.jpg?raw=true)
![](https://github.com/AlbatovK/Dira/blob/master/assets/other_profile.jpg?raw=true) | ![](https://github.com/AlbatovK/Dira/blob/master/assets/league.jpg?raw=true)
