import java.util.List;

public class CompositeFolder extends SimpleFolder implements MultiFolder {

    private List<Folder> subFolders;

    public CompositeFolder(String name, String size, List<Folder> subFolders) {
        super(name, size);
        this.subFolders = subFolders;
    }

    @Override
    public List<Folder> getFolders() {
        return subFolders;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
