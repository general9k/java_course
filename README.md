# Здесь хранится вся практика по Java

## Проекты учебные / личные по ссылке ниже
- <a href="https://github.com/general9k/java_projects"> *ТЫК* </a>

## Учебная практика:

#### - SpringMVC_calculator - калькулятор, который выводит результат выражения. Просит на вход a, b в get запросе. Поддерживает только команды +, -, *, /. Также можно ввести имя и фамилию в http выражении при /first/hello и выдаст на странице имя и фамилию, которую ввели.

- Ввели имя и фамилию, получили результат.

<img src="img/MVC1.png" alt="MVC1" width="65%" height="65%" />

- Ввели a и b, получили результат.

<img src="img/MVC2.png" alt="MVC2" width="65%" height="65%" />

#### - Hibernate_practice_PostgreSQL - практика с Hibernate и PostgreSQL, изучение связей один-ко-многим, один-к-одному, многие-ко-многим.

#### - CRUD_without_hibernate - CRUD приложение написанное на JDBC Template с использованием синтаксиса SQL. Создан человек с полями id, name, age, email, addres - все поля валидированы с помощью анатаций. Используются GET, POST, PATCH, DELETE запросы к базе данных PostrgeSQL. 

- На основной странице /people высвечиваются все люди, которые присутствуют в БД. Также имеется кнопка "create new person" которая создает пользователя и загружает в БД.

<img src="img/not_hiber_crud1.png" alt="not_hiber_crud1" width="65%" height="65%" />

- Страница отображения одного человека. Высвечивается имя, возраст, почта, адресс и айди в БД - все данные берутся из БД с помощью SQL запросов. Присутствует кнопка EDIT и DELETE. Кнопка DELETE передает DELETE запрос к БД на удаление человека.

<img src="img/not_hiber_crud2.png" alt="not_hiber_crud2" width="65%" height="65%" />

- Страница редактирования пользователя. Все поля изначально подгрузились из БД. Кнопка Update отправляет PATCH запрос к БД для изменения полей человека.

<img src="img/not_hiber_crud3.png" alt="not_hiber_crud3" width="65%" height="65%" />

- Запрос к БД на наличие людей. Все верно, там был один человек.

<img src="img/not_hiber_crud4.png" alt="not_hiber_crud4" width="65%" height="65%" />


