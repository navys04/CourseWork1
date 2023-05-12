public class PackageOwner
{
    public PackageOwner(String inOwnerName, String inOwnerSurname, String inByFather)
    {
        ownerName = inOwnerName;
        ownerSurname = inOwnerSurname;
        byFather = inByFather;
    }

    public String ownerName;
    public String ownerSurname;
    public String byFather; // отчество, нету просто такого слова в англе

}
