import javax.swing.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в информационно-поисковую систему почтовое отделение.");

        System.out.print("Пожалуйста, введите свое имя:\n");
        String name = scanner.next();

        System.out.print("Пожалуйста, введите свою фамилию:\n");
        String surname = scanner.next();

        System.out.print("Пожалуйста, введите свое отчество:\n");
        String byFather = scanner.next();

        PackageCredentials packageCredentials = new PackageCredentials(name, surname, byFather);

        Start(consoleHandler, scanner, packageCredentials);
    }

    private static void Start(ConsoleHandler consoleHandler, Scanner scanner, PackageCredentials packageCredentials)
    {
        System.out.println("Выберите пункт, что вы хотите сделать?");
        System.out.print("1. Найти почтовое отделение по адресу \n2. Выбрать почтовое отделение из списка \n3. Добавить почтовое отделение в список\n");

        int userInput = scanner.nextInt();
        switch (userInput)
        {
            case 1:
                System.out.print("Пожалуйста, введите точный адрес почтового отделения: ");
                String userInputStr = scanner.next();
                Post post = consoleHandler.FindPost(userInputStr);
                if (post == null)
                {
                    System.out.println("Не найдено почтовое отделение по данному адресу");
                    Start(consoleHandler, scanner, packageCredentials);
                    return;
                }

            case 2:
                System.out.print("В качестве ответа введите порядочную цифру отделения: ");
                for (int i = 0; i < consoleHandler.posts.size(); i++)
                {
                    System.out.println((i + 1) + ". " + consoleHandler.posts.get(i).getAddress());
                }
                userInput = scanner.nextInt();
                if ((userInput - 1) >= consoleHandler.posts.size() || (userInput - 1) < 0)
                {
                    System.out.println("Вы ввели неправильный индекс почтового отделения");
                    Start(consoleHandler, scanner, packageCredentials);
                    return;
                }

                HandlePostControl(consoleHandler, scanner, consoleHandler.posts.get(userInput - 1), packageCredentials);

            case 3:
                System.out.print("Введите адрес почтового отделения: ");
                String userInputStr2 = scanner.next();
                consoleHandler.AddPost(userInputStr2);
                System.out.println("Почтовое отделение успешно добавлено");
                Start(consoleHandler, scanner, packageCredentials);
                return;
        }
    }

    private static void HandlePostControl(ConsoleHandler consoleHandler, Scanner scanner, Post post, PackageCredentials packageCredentials)
    {
        System.out.println("Вы выбрали почтовое отделение по адресу: " + post.getAddress());
        System.out.println("Что вы хотите сделать?");
        System.out.print("1. Посмотреть все посылки в этом почтовом отделении. \n2. Добавить посылку в почтовое отделение \n3. Вернуться к разделу с почтовыми отделениями \n");

        int userInput = scanner.nextInt();
        switch (userInput)
        {
            case 1:
                System.out.println("Вот все посылки, введите индекс, если хотите узнать об них поподробнее: ");
                for (int i = 0; i < post.getPackages(packageCredentials).length; i++)
                {
                    System.out.println((i + 1) + ". " + post.getPackages(packageCredentials)[i].getPackageName());
                }

                userInput = scanner.nextInt();
                if ((userInput - 1) >= consoleHandler.posts.size() || (userInput - 1) < 0)
                {
                    System.out.println("Вы ввели неправильный индекс посылки");
                    HandlePostControl(consoleHandler, scanner, post, packageCredentials);
                    return;
                }

                Package userPackage = post.getPackages(packageCredentials)[userInput - 1];

                switch (userPackage.packageType)
                {
                    case Box:
                        BoxPackage box = (BoxPackage) userPackage;

                        System.out.println("Вес: " + box.weight);
                        System.out.println("Размеры: " + "X: " + box.sizes.x + "Y: " + box.sizes.y + "Z: " + box.sizes.z);
                        System.out.println("Название: " + box.packageName);
                        System.out.println("Добавочная информация: " + box.additiveInformation);
                        HandlePostControl(consoleHandler, scanner, post, packageCredentials);
                        return;

                    case Letter:
                        LetterPackage letter = (LetterPackage) userPackage;

                        System.out.println("Название: " + letter.packageName);
                        System.out.println("Текст письма: " + letter.letterText);
                        HandlePostControl(consoleHandler, scanner, post, packageCredentials);
                        return;
                }
            case 2:
                System.out.println("Введите тип посылки, которую хотите добавить");
                System.out.print("1. Тяжеловесная посылка \n2. Письмо");

                userInput = scanner.nextInt();

                switch (userInput)
                {
                    case 1:
                        System.out.println("Введите название посылки: ");
                        String packageName = scanner.next();

                        System.out.println("Введите вес посылки: ");
                        double packageWeight = scanner.nextDouble();

                        System.out.println("Введите размеры посылки: ");

                        System.out.println("X:");
                        double packageSizeX = scanner.nextDouble();

                        System.out.println("Y:");
                        double packageSizeY = scanner.nextDouble();

                        System.out.println("Z:");
                        double packageSizeZ = scanner.nextDouble();

                        System.out.println("Введите добавочную информацию об посылке: ");
                        String packageAdditiveInformation = scanner.next();

                        Vector3D packageSizes = new Vector3D((float)packageSizeX, (float)packageSizeY, (float)packageSizeZ);
                        BoxPackage boxPackage = new BoxPackage(packageName, PackageType.Box, (float)packageWeight, packageSizes, packageAdditiveInformation);
                        post.addNewPackage(boxPackage, packageCredentials, packageCredentials);

                        HandlePostControl(consoleHandler, scanner, post, packageCredentials);
                        return;

                    case 2:
                        System.out.println("Введите название посылки: ");
                        packageName = scanner.next();

                        System.out.println("Введите текст письма: ");
                        String letterText = scanner.next();

                        LetterPackage letterPackage = new LetterPackage(packageName, PackageType.Letter, letterText);
                        post.addNewPackage(letterPackage, packageCredentials, packageCredentials);

                        HandlePostControl(consoleHandler, scanner, post, packageCredentials);
                        return;

                }

            case 3:
                Start(consoleHandler, scanner, packageCredentials);
                return;

        }
    }

}

