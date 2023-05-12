import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        Post post = new Post("Россия, г. Владикавказ, ГМИ");

        BoxPackage boxPackage = new BoxPackage("Коробка", PackageType.Box, 12.0f,
                new Vector3D(30, 30, 30), "В нем ствол");

        LetterPackage letterPackage = new LetterPackage("Монструм, или Ведьмака описание", PackageType.Letter, "нету монстра более страшнейшего, чем я в 6 утра");

        PackageCredentials packageOwner = new PackageCredentials("Сармат", "Вашаев", "Андреевич");
        PackageCredentials packageReceiver = new PackageCredentials("Оксана", "Соколова", "Александровна");

        post.addNewPackage(boxPackage, packageOwner, packageReceiver);
        post.addNewPackage(letterPackage, packageOwner, packageReceiver);

        LetterPackage outLetterPackage = (LetterPackage) post.getPackagesByType(packageOwner, PackageType.Letter)[0];

        System.out.println(outLetterPackage.letterText);
    }
}