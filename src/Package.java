public abstract class Package
{
    Package(String defaultPackageName, PackageType defaultPackageType)
    {
        packageName = defaultPackageName;
        packageType = defaultPackageType;
    }

    protected String packageName;
    protected PackageType packageType;
    protected Post post;

    public final String getPackageName() { return packageName; }
    public final PackageType getPackageType() { return packageType; }
    public final Post getPost() { return post; }
    public void setPost(Post newPost) { post = newPost; }


    abstract protected void onNewPostSet(Post newPost);
}
