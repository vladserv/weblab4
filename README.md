# weblab4

1. Какие есть виды и типы баз данных с примерами?

Реляционные базы данных: MySQL, PostgreSQL, SQLite, Microsoft SQL Server.
Нереляционные (NoSQL) базы данных:
    Документоориентированные: MongoDB, CouchDB.
    Ключ-значение: Redis, Amazon DynamoDB.
    Семейство столбцов: Apache Cassandra, HBase.
    Графовые: Neo4j, Amazon Neptune.

2. В чём различие между Web-сервером и оболочкой, как
например NodeJS?

Web-сервер: Это программное обеспечение, которое принимает запросы от клиентов (чаще всего браузеров) через протокол HTTP, обрабатывает их и отправляет обратно ответы, содержащие запрошенные данные. Примеры: Apache, Nginx, Microsoft IIS.

Node.js представляет собой среду выполнения для JavaScript на стороне сервера. Он позволяет JavaScript выполняться не только в браузере, но и на сервере, обеспечивая возможность создания серверных приложений. Node.js не является веб-сервером в том смысле, что Apache или Nginx, но он может обрабатывать HTTP-запросы и выполнять функции веб-сервера.

3. По какому API соединяются фреймворк и база данных в
данном задании?

В контексте использования Spring и MongoDB, обычно используется Spring Data MongoDB, которое предоставляет абстракции для взаимодействия с MongoDB через API. Spring Data MongoDB интегрирует MongoDB в приложения, написанные на базе Spring Framework.

Добавление зависимости в файл pom.xml (для Maven):
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
Конфигурация MongoDB в файле application.properties:
    spring.data.mongodb.uri=mongodb://localhost:27017/mydatabase