public class PackageCredentials
{
    public PackageCredentials(String inOwnerName, String inOwnerSurname, String inByFather)
    {
        Name = inOwnerName;
        Surname = inOwnerSurname;
        Father = inByFather;
    }

    public String Name;
    public String Surname;
    public String Father; // отчество, нету просто такого слова в англе

}
