.PHONY: all clear-screen clean tests

# Определяем переменные
GRADLE=./gradlew

# Цель по умолчанию
all: tests

# Очистка экрана
clear-screen:
	@clear

# Очистка проекта
clean: clear-screen
	$(GRADLE) clean

# Запуск тестов
tests: clean
	$(GRADLE) test
