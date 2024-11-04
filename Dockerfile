# Используем официальный образ Maven для сборки приложения
FROM maven:3.8-openjdk-17 AS builder

# Устанавливаем рабочую директорию в контейнере
WORKDIR /app

# Копируем файлы проекта в контейнер
COPY . .

# Выполняем сборку приложения с помощью Maven
RUN mvn package -DskipTests

# Используем более легкий образ OpenJDK для запуска приложения
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию для конечного образа
WORKDIR /app

# Копируем jar файл из этапа сборки
COPY --from=builder /app/target/newsApi-0.0.1.jar /app/app.jar

# Открываем порт, который использует приложение (например, 8080 для Spring Boot)
EXPOSE 8080

# Устанавливаем команду запуска приложения
CMD ["java", "-jar", "/app/app.jar"]