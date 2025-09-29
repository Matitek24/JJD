import java.util.List;

public class MultiSFolder extends SFolder implements MultiFolder {

    private List<Folder> subFolders;

    public MultiSFolder(String name, String size, List<Folder> subFolders) {
        super(name, size);
        this.subFolders = subFolders;
    }

    @Override
    public List<Folder> getFolders() {
        return subFolders;
    }
}
