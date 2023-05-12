import java.util.ArrayList;

public class Post
{
    public Post(String inAddress)
    {
        address = inAddress;
        postStorage = new Storage(400, 400);
    }

    private final String address;
    private final Storage postStorage;

    public String getAddress() { return address; }
    public Package[] getPackages(final PackageCredentials packageCredentials) { return postStorage.getPackages(packageCredentials); }
    public Package[] getPackagesByType(final PackageCredentials packageCredentials, final PackageType inPackageType)
    {
        return postStorage.getPackagesByType(packageCredentials, inPackageType);
    }

    public void addNewPackage(Package newPackage, PackageCredentials packageOwner, PackageCredentials packageReceiver)
    {
        postStorage.addPackage(newPackage, packageOwner, packageReceiver);
        newPackage.setPost(this);
    }
}
