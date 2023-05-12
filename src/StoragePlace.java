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

    private PackageCredentials packageOwner;
    private PackageCredentials packageReceiver;

    public void setStoragePackage(Package newStoragePackage)
    {
        storagePackage = newStoragePackage;
        isBusy = true;
    }

    public Package getStoragePackage() { return storagePackage; }

    public PackageCredentials getPackageOwner() { return packageOwner; }
    public void setPackageOwner(PackageCredentials inPackageCredentials) { packageOwner = inPackageCredentials; }

    public PackageCredentials getPackageReceiver() { return packageReceiver; }
    public void setPackageReceiver(PackageCredentials inPackageCredentials) { packageReceiver = inPackageCredentials; }
}
