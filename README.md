# User Management System (Console Application)

Проста консольна система управління користувачами на Java, побудована з дотриманням архітектурних шарів (Data, Business, Presentation) та принципів чистішого коду.

## 🚀 Особливості проекту
- **Динамічне керування даними**: Використання `ConcurrentHashMap` для потокобезпечного збереження об'єктів в оперативній пам'яті (In-Memory).
- **Автоматична генерація ID**: Застосування `AtomicLong` для гарантії унікальності ідентифікаторів у багатопотоковому середовищі.
- **Розділення обов'язків (Layered Architecture)**:
    - `DataRepository` відповідає суто за збереження та повернення сирих даних (`null` якщо об'єкт відсутній).
    - `DataHandler` бере на себе бізнес-логіку, валідацію та форматування рядків.
    - `Main` виступає точкою входу та централізовано обробляє помилки.
- **Обробка виключень**: Реалізовано власну неперевіряєму помилку (Unchecked Exception) `UserNotFoundException` з інформативним повідомленням.
- **Сучасне форматування**: Замість класичного `String.format()` використано лаконічний метод `"".formatted()`.

## 🛠️ Технологічний стек
- **Java 15+** (через використання методу `String.formatted()`)
- **Java Collections Framework** (`Map`, `List`, `HashMap`)
- **Java Concurrency** (`ConcurrentHashMap`, `AtomicLong`)

## 📂 Структура пакету `app`
- `User` — модель (сутність) користувача з полями `id` та `name`.
- `DataRepository` — шар доступу до даних (Data Access Layer).
- `DataHandler` — шар бізнес-логіки (Business Logic Layer / Service).
- `UIOperator` — компонент для виведення інформації в консоль.
- `UserNotFoundException` — кастомний клас помилки.
- `Main` — запуск програми та демонстрація функціоналу.

## 💻 Приклад роботи програми

При запуску класу `Main` система автоматично реєструє 4 користувачів, виводить повний список, робить успішний пошук та демонструє обробку помилки для неіснуючого ID:

```text
User created successfully: ID 1, Name: Lucy
User created successfully: ID 2, Name: Alice
User created successfully: ID 3, Name: Bob
User created successfully: ID 4, Name: Tom

ALL NAMES:
1) 1, Lucy
2) 2, Alice
3) 3, Bob
4) 4, Tom

NAME: id 4, Tom

Error: User with ID 99 not found!
```

## 📈 Напрямки для покращення (Roadmap)
1. **DIP (SOLID)**: Виділення інтерфейсу `UserRepository` для легкої заміни сховища даних (наприклад, на SQL БД) без зміни логіки в `DataHandler`.
2. **Валідація**: Додати перевірку імені користувача на порожній рядок або заборонені символи перед збереженням.
3. **REST API**: Перенесення логіки на фреймворк Spring Boot для створення повноцінного веб-додатку.