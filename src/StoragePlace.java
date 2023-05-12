import java.util.Map;

public class StoragePlace
{
    public StoragePlace(int newHorizontalPos, int newVerticalPos)
    {
        horizontalPosition = newHorizontalPos;
        verticalPosition = newVerticalPos;
    }

    public int horizontalPosition;
    public int verticalPosition;
    public boolean isBusy = false;
    private Package storagePackage;

    private PackageOwner packageOwner;

    public void setStoragePackage(Package newStoragePackage)
    {
        storagePackage = newStoragePackage;
        isBusy = true;
    }

    public Package getStoragePackage() { return storagePackage; }
    public PackageOwner getPackageOwner() { return packageOwner; }
    public void setPackageOwner(PackageOwner inPackageOwner) { packageOwner = inPackageOwner; }
}
