public class LetterPackage extends Package
{
    public LetterPackage(String defaultPackageName, PackageType defaultPackageType)
    {
        super(defaultPackageName, defaultPackageType);
    }

    public LetterPackage(String defaultPackageName, PackageType defaultPackageType, String defaultLetterText)
    {
        super(defaultPackageName, defaultPackageType);
        letterText = defaultLetterText;
    }

    public String letterText;

    @Override
    protected void onNewPostSet(Post newPost)
    {

    }
}
