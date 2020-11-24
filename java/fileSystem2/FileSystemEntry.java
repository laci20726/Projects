public abstract class FileSystemEntry {
    Folder parent;
    String name;

    public FileSystemEntry(Folder parent, String name) {
        this.parent = parent;
        this.name = name;
        if(this.parent != null) {
            parent.addChild(parent);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract long size();

    public String fullPath() {
        if(this.parent == null) {

            return this.name;
        } else {
            return this.parent.fullPath() + "/" + this.name ;
        }
    }
    
}