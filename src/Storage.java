import java.util.ArrayList;

public class Storage
{
    public Storage(int newHorizontalSize, int newVerticalSize)
    {
        horizontalSize = newHorizontalSize;
        verticalSize = newVerticalSize;
    }

    ArrayList<StoragePlace> storagePlaces = new ArrayList<StoragePlace>();

    public StoragePlace getStoragePlaceByCoordinates(final int x, final int y)
    {
        for (var storagePlace : storagePlaces)
        {
            if (storagePlace.horizontalPosition == x && storagePlace.verticalPosition == y) return storagePlace;
        }

        return null;
    }

    private StoragePlace getFreeStoragePlace()
    {
        int i = 0;
        int j = 0;

        for (int z = 0; z < horizontalSize; z++)
        {
            i++;
            StoragePlace storagePlaceZ = getStoragePlaceByCoordinates(i, j);
            if (storagePlaceZ == null) return new StoragePlace(i, j);
            for (int v = 0; v < verticalSize; v++)
            {
                j++;
                StoragePlace storagePlaceV = getStoragePlaceByCoordinates(i, j);
                if (storagePlaceV == null) return new StoragePlace(i, j);
            }
        }

        return null;
    }

    public final int horizontalSize;
    public final int verticalSize;

    public Package[] getPackages(final PackageCredentials packageCredentials)
    {
        ArrayList<Package> packages = new ArrayList<Package>();

        for (var storagePlace : storagePlaces)
        {
            if (storagePlace.getPackageOwner() == packageCredentials)
            {
                packages.add(storagePlace.getStoragePackage());
            }
        }

        Package[] packagesArr = new Package[packages.size()];
        packagesArr = packages.toArray(packagesArr); // ненавижу джаву

        return packagesArr;
    }

    public Package[] getPackagesByType(final PackageCredentials packageCredentials, final PackageType inPackageType)
    {
        Package[] packages = getPackages(packageCredentials);
        ArrayList<Package> outPackages = new ArrayList<Package>();

        for (var arrPackage : packages)
        {
            if (arrPackage.getPackageType() == inPackageType)
            {
                outPackages.add(arrPackage);
            }
        }

        Package[] outPackagesArr = new Package[outPackages.size()];
        outPackagesArr = outPackages.toArray(outPackagesArr);

        return outPackagesArr;
    }

    public void addPackage(Package newPackage, PackageCredentials packageOwner, PackageCredentials packageReceiver)
    {
        StoragePlace storagePlace = getFreeStoragePlace();
        if (storagePlace == null) return;

        storagePlace.setStoragePackage(newPackage);
        storagePlace.setPackageOwner(packageOwner);
        storagePlace.setPackageReceiver(packageReceiver);
        storagePlaces.add(storagePlace);
    }
}
