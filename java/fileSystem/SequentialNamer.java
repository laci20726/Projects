public class SequentialNamer implements Namer {
    private int index = 1;

@Override
    public void rename(FileSystemEntry name) {
        FileSystemEntry newName = name;
        newName.setName(name.getName() + "_" + index) ;
        name = newName;
        index++;
    }

}