package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.SearchEngine;

import java.util.ArrayList;

public class App {

    static void printTitle(String title) {
        int lineLength = 100;
        int headerLength = title.length();
        int numberOfCharacters = (lineLength - headerLength) / 2;
        String completion = "-";
        System.out.println("\n" + completion.repeat(numberOfCharacters) + title + completion.repeat(numberOfCharacters));
    }

    static <ProductInformation> void completeTask1(ProductInformation productInformation) {
        String product1 = "Хлеб ржаной";
        String product2 = "Кетчуп";
        String product3 = "Стиральный порошок";
        String product4 = "Туалетная бумага";
        String product5 = "Пена для бритья";
        String product6 = "Молоко";
        printTitle("ДОМАШНЕЕ ЗАДАНИЕ");
        printTitle("Демонстрация классов");
        printTitle("Создали некоторый массив продуктов имеющихся в магазине вывели его на экран");
        productInformation.printProductsInStore();
        printTitle("1. Добавление продукта в корзину");
        System.out.println("Добавили 1 продукт: " + product1);
        productInformation.searchProductAddBasket(product1);
        System.out.println("Добавили 2 продукт: " + product2);
        productInformation.searchProductAddBasket(product2);
        System.out.println("Добавили 3 продукт: " + product3);
        productInformation.searchProductAddBasket(product3);
        System.out.println("Добавили 4 продукт: " + product4);
        productInformation.searchProductAddBasket(product4);
        System.out.println("Добавили 5 продукт: " + product5);
        productInformation.searchProductAddBasket(product5);
        //  printTitle("2. Добавление продукта в заполненную корзину, в которой нет свободного места");
        System.out.println("Добавили 6 продукт: " + product6);
        productInformation.searchProductAddBasket(product6);
        printTitle("3. Печать содержимого корзины с несколькими товарами");
        productInformation.basket.printContentBasket();
        printTitle("4. Получение стоимости корзины с несколькими товарами");
        System.out.println("Стоимость корзины с отложенными товарами равна: " + productInformation.basket.calculateCostBasket() + " рублей");
        printTitle("5. Поиск товара, который есть в корзине (" + product2 + ")");
        productInformation.searchProductBasket(product2);
        printTitle("6. Поиск товара, которого нет в корзине (" + product6 + ")");
        productInformation.searchProductBasket(product6);
        printTitle("7. Очистка корзины");
        productInformation.basket.clearingBasket();
        printTitle("8. Печать содержимого пустой корзины");
        productInformation.basket.printContentBasket();
        printTitle("9. Получение стоимости пустой корзины");
        System.out.println("Стоимость пустой корзины равна: " + productInformation.basket.calculateCostBasket() + " рублей");
        printTitle("10. Поиск товара по имени в пустой корзине");
        productInformation.searchProductBasket(product3);
    }

    static void completeTask2(ProductInformation productInformation, SearchEngine searchEngeni) {
        printTitle("ДОМАШНЕЕ ЗАДАНИЕ Полиморфизм. Интерфейсы");
        System.out.println("1. Создали один объект типа SearchEngine c пустым списком ");
        System.out.println("Итого: мы имеем список размерностью изначально равной " + searchEngeni.getSearchable().size());
        System.out.println("2. Привели тип объекта products к типу Searhable  и занесли элементы в объект searchEngeni  ");
        searchEngeni.add(productInformation.products);

        System.out.println("3. Занесли объекты article в объект searchEngeni  ");
        searchEngeni.add(productInformation.articles);
        printTitle("4. Проводим проверку заполнения объекта searchEngeni");
        for (Searchable x : searchEngeni.getSearchable()) {
            System.out.println(x);
        }
        String searchOption1 = "хлеб";
        String searchOption2 = "майонез";
        String searchOption3 = "ма";
        printTitle("5. Продемонстрировали функциональность поиска при вводе строки - " + searchOption1 + " ");
        demonstrateTheMethod(searchEngeni, searchOption1);
        printTitle("6. Продемонстрировали функциональность поиска при вводе строки - " + searchOption2 + " ");
        demonstrateTheMethod(searchEngeni, searchOption2);
        System.out.println("7. Продемонстрировали функциональность поиска при вводе строки - " + searchOption3 + ", на предмет полного заполнения массива поиска \n");
        demonstrateTheMethod(searchEngeni, searchOption3);
    }

    static void completeTask3(ProductInformation productInformation, SearchEngine searchEngeni) {
        String searchOption4 = "майонез";
        String searchOption5 = "apple";
        printTitle("ДОМАШНЕЕ ЗАДАНИЕ Исключение в JAVA");
        System.out.println("1. В классы Product и его наследники ввели проверку корректности ввода данных в объекты.");
        System.out.println("2. Провели демонстрацию корректности ввода данных без ошибки для удобства проверки данных при вводе ошибки в программу.");
        productInformation.printProductsInStore();
        System.out.println("3. 4. Реализовали метод getSearchTerm(String search) в классе Searchable и создали исключение BestResultNotFound. ");
        printTitle("5.1 Продемонстрируем метод getSearchTerm(String search) когда строка имеет значение - " + searchOption4);
        System.out.println();
        demonstrateTheMethod2(searchEngeni, searchOption4);
        printTitle("5.2 Продемонстрируем метод getSearchTerm(String search) когда строка имеет значение - " + searchOption5);
        System.out.println();
        demonstrateTheMethod2(searchEngeni, searchOption5);

    }

    static void demonstrateTheMethod(SearchEngine object, String line) {
        int sequenceNumber = 0;
        for (Searchable x : object.search(line)) {
            System.out.println((++sequenceNumber) + "." + x.getStringRepresentation());




        }
    }

    static void demonstrateTheMethod2(SearchEngine object, String line) {
        try {
            System.out.println(object.getSearchTerm(line).getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    static void printDeleteProductBasket(ProductInformation object, String line) {
        int index = 0;
        for (Product element : object.basket.deleteProduct(line)) {
            index++;
            System.out.println(element);
        }
        if (index == 0) {
            System.out.println("Список пуст, проверьте правильность ввода строки удаления");
        }
    }


    public static void main(String[] args) {
        try {
            ProductInformation productInformation = new ProductInformation();
            SearchEngine searchEngeni = new SearchEngine();

            completeTask1(productInformation);
            completeTask2(productInformation, searchEngeni);
            completeTask3(productInformation, searchEngeni);
            printTitle("ДОМАШНЕЕ ЗАДАНИЕ Java Collections Framework: List");
            System.out.println("1.1 Поменяли внутреннюю структуру класса ProductBasket заменили массив на список типа  LinkedList");
            System.out.println("1.2 Убедились что теперь мы можем в корзину добавлять условно бесконечное количество продуктов");
            ArrayList<String> productBasket = new ArrayList<>();
            productBasket.add("Хлеб ржаной");
            productBasket.add("Кетчуп");
            productBasket.add("Стиральный порошок");
            productBasket.add("Туалетная бумага");
            productBasket.add("Пена для бритья");
            productBasket.add("Молоко");
            printTitle("1. Добавление продукта в корзину");
            for (int element = 0; element < productBasket.size(); element++) {
                System.out.println("Добавили " + (element + 1) + " продукт: " + productBasket.get(element));
                productInformation.searchProductAddBasket(productBasket.get(element));
            }
            System.out.println("2. Добавили метод public deleteProduct(String line), который по переданному имени продукта удаляет все" +
                    " продукты с таким именем из корзины");
            printTitle("2.1 Продемонстрируем работу метода. Для этого распечатаем содержимое корзины.");
            productInformation.basket.printContentBasket();
            System.out.println();
            String productDelete = "молоко";
            System.out.println("\n 2.1 Удалим из корзины один продукт \" " + productDelete + "\" и выведем в консоль удаленные продукты с корзины.");
            printDeleteProductBasket(productInformation, productDelete);
            printTitle("2.2. Распечатаем содержимое корзины и убедимся в отсутствии в ней продукта \"" + productDelete + "\"");
            productInformation.basket.printContentBasket();
            productDelete = "пенt для бритья";
            System.out.println("\n 2.3 Удалим из корзины продукт введенный с ошибкой \" " + productDelete + "\" и выведем в консоль удаленные продукты с корзины.\n");
            printDeleteProductBasket(productInformation, productDelete);
            printTitle("2.4. Вывели содержимое корзины на экран.");
            productInformation.basket.printContentBasket();
            searchEngeni.clearSearchEngine();
            System.out.println("\n3. Продемонстрируем использование измененного метода search для чего повторим вывод домашнего задания \"Полиморфизм. Интерфейсы.\" на печать");
            System.out.println("Для повторного корректного выполнения домашнего задания \"Полиморфизм. Интерфейсы.\" " +
                    "произвел предварительно очистку списка объекта searchEngine дополнительным методом clearSearchEngine()  ");
            searchEngeni.clearSearchEngine();
            completeTask2(productInformation, searchEngeni);
            System.out.println("\nУбедились что программа отрабатывает согласно условия задания.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage() + "  проведите корректировку вводимых данных");

        }
    }
}