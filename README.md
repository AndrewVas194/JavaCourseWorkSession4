Web-приложение
Интернет-магазин «Fissport»

Описание приложения
Интернет-магазин с возможностью добавлять/выбирать товарные единицы. Покупатель, зайдя на сайт и ознакомившись с условиями продажи, начинает просматривать предлагаемый перечень товаров. Понравившийся по цене или техническим характеристикам  продукт он заносит в корзину покупок.
За один раз предоставляется возможность выбрать любое количество товаров, после чего можно приступать к оформлению заказа. Для этого покупатель должен указать свой почтовый адрес, куда будет отправлена посылка, и телефон, по которому с ним сможет связаться консультант магазина для подтверждения заказа. Продажа различных изделий через интернет обладает огромным количеством преимуществ. Низкие затраты на открытие бизнеса и существенное снижение издержек позволяет предпринимателю устанавливать невысокие цены на товары, что не может не нравиться клиентам.

Главная страница включает в себя новости спорта и меню выбора функций каждая из которых переправляет на другую страницу:
Главная страница 
Товары - переход на страничку товаров
Добавить - добавление товара
Обо мне - информация об администраторе сайта 

При переходе на страничку Товары предоставляется информация об имеющихся товаров на странице. Товар представляет собой небольшую табличку с изображением товара и его описания в виде имени, категории, описания, цены и кнопки «в корзину». При нажатии на кнопку «в корзину» идёт переход на другую страницу для заполнения контактных данных пользователя которые сохраняются в бд и отображаются на отдельной странице доступной по ссылке /clients

Следующее что может пользователь это добавление товара.
При нажатии на вкладку «добавить» идёт переход на форму заполнения для отображения товара.
Добавление товара проходит как обязательное заполнение всех полей
Отображается товар на предыдущей страничке и добавлен в БД
Последняя страница представляет собой информацию об администраторе



Для реализации серверной части приложения был выбран язык Java и для разработки клиентской части -Spring Boot. Будущее приложение подразумевает в себе наличие классов, отвечающих за те или иные аспекты реализации. Язык Java поддерживает ООП, что позволяет выбрать его в качестве языка написания данного ПО. Для реализации веб-приложения было решено использовать Spring boot для реализации на сервере и работе с клиентом. В качестве инструмента для хранения данных приложения была выбрана БД, для управления которой была выбрана наиболее быстрая и лёгкая в использовании СУБД MySQl.

Основные сущности приложения представлены классами Post и Client. Также реализованы следующие перечисления:

Post - представляет собой товар
Client-представляет собой информацию о клиенте.

Сущность в выше перечисленных описанные как:

Class Post - представляет информацию о товаре. Поля:

id- id товара
name-название товара
anons-раздел/категория
full_text-описанние товара
price-цена товара

Class Client -представляет информацию о клиенете. Поля:
idClient- id клиента
clietnName - имя клиента
email - Email клиента
number -  номер клиента

Реализация базы данных:
Для осуществления возможности хранения данных в БД необходимо определить ее модель. Для этого представим основные сущности в виде таблиц:
• сущности Post и Client представляют таблицами post и clients. Таблица post хранит основную информацию о товаре(name, full_text и др.).
• сущность Post представляется таблицей posts; 
• таблица client представляет Client; 

Для доступа на сервер использовался локальный веб-сервер для Windows OpenServer.