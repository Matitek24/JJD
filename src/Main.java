public static void main(String[] args) {
    List<Folder> folders = new ArrayList<>();
    List<String> sizes = List.of("20M", "30M", "40M", "50M", "20M");
    List<String> names = List.of("FolderA", "FolderB", "FolderC", "FolderD", "FolderE");

    List<Folder> folderList = IntStream.range(0, sizes.size())
            .mapToObj(i -> new SFolder(names.get(i), sizes.get(i)))
            .collect(Collectors.toList());

    Folder ExtraFolder = new MultiSFolder("FolderExtra", "160M", folderList);

    folders.add(ExtraFolder);
    folders.addAll(folderList);

    FileCabinet MainFileCabinet = new FileCabinet(folders);

    System.out.println("Count of folders " + MainFileCabinet.count() + "\n" + MainFileCabinet.findFolderByName("FolderA") + "\n" +
            MainFileCabinet.findFoldersBySize("20M"));

}
