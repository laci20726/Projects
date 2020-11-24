public class Folder extends FileSystemEntry{
    private FileSystemEntry[] children = null;

    public FileSystemEntry[] getChildren() {
        return children;
    }

    public void setChildren(FileSystemEntry[] children) {
        this.children = children;
    }
    
    
    public Folder(Folder parent, String name) {
        super(parent, name);
    }

    public void addChild(FileSystemEntry elem) {
        if( this.children == null) {
            FileSystemEntry[] childrenExtended = new FileSystemEntry[1];
            childrenExtended[0] =  elem ;
            this.children = childrenExtended;
        } else {
            FileSystemEntry[] childrenExtended = new FileSystemEntry[this.children.length + 1];
            System.arraycopy(this.children, 0, childrenExtended, 0, this.children.length);
            childrenExtended[this.children.length] = elem;
            this.children = childrenExtended;
        }
    }
    
@Override
public long size() {
    long osszeg = 0;
    if(this.children == null) {
        return 0;
    } else {
        for (int i = 0; i < this.children.length; i++) {
            osszeg += this.children[i].size();
        }
    }
    return osszeg;
}


}