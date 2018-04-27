package com.VladIndustries;

//Школьный журнал(совет Кати использовать паттерны: контроллер и сервис (локатор вроде))
//        Один журнал один предмет.
//        Для каждого класса можно создать журналы по разным предметам (математика,физика, химия).
//        Кол-во учеников в классе не меняется и можно заполнить руками и читай уже готовый файл
//        Оценки можно создавать(на дату)\удалять\редактировать\просматривать
//        Обязательные требования
//        0) 2-3 класса с 2-3 журналами по разным предметам
//        1) Список учеников класса хранится в файле
//        2) Список оценок хранится в файле
//        3) Список классов хранится в файле
//        4) При старте программы набор студентов\классов\оценок читается из файла
//        5) При завершение программы все изменния сохраняются в файле
//        6) Применить один любой патрн в любой части программы
//        7) Применить знания полученные на лекциях
//        Было бы плюсом
//        1) логгировать ошибки в файл
//        2) логгировать действия пользователя в файл (когда создали\обновили\удалил
//        оценку)
import com.VladIndustries.MyExceptions.MarkOutOfBoundsException;
import com.VladIndustries.View.ViewConsole;

import java.io.File;

public class Main {

    public static void main(String[] args) throws MarkOutOfBoundsException {
        File fileSerial = new File("serialFile.txt");
        File fileInfo = new File("infoAboutChanges.txt");
        File fileResult = new File("serialResult.txt");
        ViewConsole viewConsole = new ViewConsole();
        viewConsole.initialize(fileResult,fileSerial,fileInfo,System.out,System.in);
        viewConsole.start();
        viewConsole.destroy();
    }
}
