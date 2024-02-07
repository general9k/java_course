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

#### - FirstSecurityApp - учебная практика. Создание приложения со Spring MVC и Spring Security, БД - PostgreSQL. Есть 2 пользователя: обычный, админ. Обычный пользователь не может зайти на страницу /admin, то есть на страницу админа.

- Поле входа для пользователя. Человек сможет зайти на страницу /hello и остальные страницы, только когда он есть в БД. Незарегистрированные пользователи должны перейти на /auth/registation и зарегистрироваться, чтобы потом аутентифицироваться. 

<img src="img/first_security1.png" alt="first_security1" width="65%" height="65%" />

- Проба неправильного ввода имени / пароля.

<img src="img/first_security2.png" alt="first_security2" width="65%" height="65%" />

- Зашли на страницу /hello как аутентифицировались.

<img src="img/first_security3.png" alt="first_security3" width="65%" height="65%" />

- Страница регистрации пользователя.

<img src="img/first_security4.png" alt="first_security4" width="65%" height="65%" />

- Все поля валидированы.

<img src="img/first_security5.png" alt="first_security5" width="65%" height="65%" />

- Страница админа. Доступна только пользователям с ролью ADMIN. 

<img src="img/first_security6.png" alt="first_security6" width="65%" height="65%" />

- Пароль в БД зашифрован.

<img src="img/first_security7.png" alt="first_security7" width="65%" height="65%" />


