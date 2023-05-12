public class BoxPackage extends Package
{
    public BoxPackage(String defaultPackageName, PackageType defaultPackageType)
    {
        super(defaultPackageName, defaultPackageType);
    }

    public BoxPackage(String defaultPackageName, PackageType defaultPackageType, float inWeight, Vector3D inSizes, String inAdditiveInformation)
    {
        super(defaultPackageName, defaultPackageType);
        weight = inWeight;
        sizes = inSizes;
        additiveInformation = inAdditiveInformation;
    }

    public float weight;
    public Vector3D sizes;
    public String additiveInformation;

    @Override
    protected void onNewPostSet(Post newPost)
    {

    }
}
