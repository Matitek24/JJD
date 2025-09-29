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

    public Optional<Folder> getFolderRecursive(String name, List<Folder> listOfFolders) {
        for (Folder folder : listOfFolders) {
          if(folder.getName().equals(name)) {return Optional.of(folder);}
          if(folder instanceof MultiFolder mf){
              Optional<Folder> fol = getFolderRecursive(name, mf.getFolders());
              if(fol.isPresent()){
                  return fol;
              }
          }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return getFolderRecursive(name, folders);
    }

    public List<Folder> findFolderBySizeRecursive(String size, List<Folder> listOfFolders) {
        List<Folder> foldersFind = new ArrayList<>();
        for(Folder folder : listOfFolders) {
            if(folder.getSize().equals(size)) {
                foldersFind.add(folder);
            }
            if(folder instanceof MultiFolder mf){
                foldersFind.addAll(findFolderBySizeRecursive(mf.getSize(), mf.getFolders()));
            }
        }
        return foldersFind;
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
       return findFolderBySizeRecursive(size, folders);
    }

    public int countRecursive(List <Folder> listOfFolders) {
        int wynik = 0;
        for(Folder folder : listOfFolders) {
            wynik ++;
            if(folder instanceof MultiFolder mf){
                wynik += countRecursive(mf.getFolders());
            }
        }
        return wynik;
    }
    @Override
    public int count() {
        return countRecursive(folders);
    }
}
