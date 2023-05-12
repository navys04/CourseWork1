
public class Main
{
    public static void main(String[] args)
    {
        Post post = new Post("Россия, г. Владикавказ, ГМИ");
        BoxPackage boxPackage = new BoxPackage("Коробка", PackageType.Box, 12.0f,
                new Vector3D(30, 30, 30), "В нем ствол");
        PackageOwner packageOwner = new PackageOwner("Сармат", "Вашаев", "Андреевич");
        post.addNewPackage(boxPackage, packageOwner);

        System.out.println(post.getPackages(packageOwner)[0].getPackageName());
    }
}