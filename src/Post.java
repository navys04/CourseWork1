import java.util.HashMap;
import java.util.Map;

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
    public Package[] getPackages(final PackageOwner packageOwner) { return postStorage.getPackages(packageOwner); }

    public void addNewPackage(Package newPackage, PackageOwner packageOwner)
    {
        postStorage.addPackage(newPackage, packageOwner);
        newPackage.setPost(this);
    }
}
