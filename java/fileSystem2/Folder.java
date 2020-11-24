public class Folder extends FileSystemEntry {
    FileSystemEntry[] children = null;

    public Folder(Folder parent, String name) {
        super(parent, name);
    }
    
    public FileSystemEntry[] getChildren() {
        return children;
    }

    public void setChildren(FileSystemEntry[] children) {
        this.children = children;
    }

    public void addChild(FileSystemEntry elem) {
        if(this.children == null) {
            FileSystemEntry[] newArray = new FileSystemEntry[1];
            newArray[0] = elem;
            this.children = newArray;
        } else {
            FileSystemEntry[] newArray = new FileSystemEntry[this.children.length + 1];
            System.arraycopy(this.children ,0, newArray ,0, this.children.length);
            newArray[this.children.length] = elem;
            this.children = newArray;
        }
    }
    
@Override
    public long size() {
        long osszeg = 0;
        if(this.children == null){ 
            return 0;
        } else {
            for (int i = 0; i < children.length; i++) {
                osszeg += this.children[i].size();
            }
            return osszeg;
        }
    }

}