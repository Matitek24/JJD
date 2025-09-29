import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//Poniżej przekazujemy zadanie z prośbą o analizę poniższego kodu
// i samodzielne zaimplementowanie metod findFolderByName,
// findFolderBySize, count w klasie FileCabinet- najchętniej
// unikając powielania kodu i umieszczając całą logikę w klasie FileCabinet.
// Z uwzględnieniem w analizie i implementacji interfejsu MultiFolder!

public class FileCabinet implements Cabinet {
    private List<Folder> folders = new ArrayList<>();

    public FileCabinet(Folder folder) {
        folders.add(folder);
    }
    public FileCabinet(List<Folder> fold) {
        folders.addAll(fold);
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return folders.stream()
                .filter(folder -> folder.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return folders.stream()
                .filter(folder_size -> folder_size.getSize().equals(size))
                .toList();
    }

    @Override
    public int count() {
        return folders.size();
    }
}
