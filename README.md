# RickAndMortyAPI_2.0
This app was created to handle response from https://rickandmortyapi.com/ using REST API.\
Project contains three base modules: app, domain, data. The app is using single Activity method. MVVM was taken as a basis. During designing app's archtecture the author was inspired by the SOLID and Clean Archetecture principles.
##
Приложение создано для того, чтобы обрабатывать ответы с https://rickandmortyapi.com/ с использованием REST API. \
Проект состоит из трёх основных модулей: app, domain, data. При разработке использовался single Activity подход. За основу взят шаблон MVVM, при проектировании архитектуры автор водохновлялся принципами SOLID и Clean Archetecture. 

## app
App's part that takes care about views and viewmodels. Has folder for dependency injection (di). Between views and viewmodels data trasports by LiveData.\
Depends on domain and data.
##
Содержит в себе все view и viewmodel. Папка di содержит класси необходимые для внедрения зависимости. Обмен данными между view и viewmodel осуществляется при помощи LiveData
Зависит от domain и data модулей.

## domain
There is describing the main program's logic. Has base usecases controlled by viewmodels. To interract with a repository has interface (repositopry).\
Depends on no one
##
В этом модуле описана вся бизнес логика приложения. Содержит основные usecase для каждой viewmodel. Для взаимодействия с репозиторием имеется интерфейс (repository).\
Модуль не зависит от остальных модулей приложения.

## data
Has repository class implementing domain's repository's interface. Package web handles response from server. \
Depends on domain.
## 
Основным является класс репозитория имлементирующий интерфейс из domain модуля. Папка web обрабатывает ответы с сервера.\
Зависит от domain модуля.     

##
For pagination using Paging 3 \
For loading picture using Picasso 2.8 \
For interract with web using Retrofit 2.9 \ 
For dependency injection using Hilt 2 \
Also this app using RxJava 3 \
Min sdk: 21 \
Target sdk: 32 \
This app was tested on Samsung Galaxy A520-F \
##



Для пагинации используется Paging 3 \
Для загрузки изображений используется Picasso 2.8 \
Для взаимодействия с сетью используется Retrofit 2.9 \
Для внедрения зависимостей используется Hilt 2 \
Также приложение использует RxJava 3 \
Мин sdk: 21 \
Основное sdk: 32 \
Приложение тестировалось на Samsung Galaxy A520-F \

&#169;  made by Biruckoff special for red_mad_robot \
&#169;  сделал Biruckoff специально для red_mad_robot
