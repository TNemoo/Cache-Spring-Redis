# Применение кэширования используя технологию Spring + Redis.

### Запросы:

POST http://localhost:8080/person/new
{
"firstname": "John",
"surname": "Honor",
"phoneNumber": "+08-999-999-99-94"
}

GET http://localhost:8080/person/1
* с кэшированием, загрузка первый раз из БД, потом всегда из Redis

GET http://localhost:8080/person/update/1
* с обновлением кэша, загрузка всегда из БД и отправка кэш в Redis