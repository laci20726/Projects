public class Manager {
    private Namer namer;
    private Folder imagesFolder;
    private Folder etcFolder;

    public Manager(Namer namer, Folder alapMappa) {
        this.namer = namer;
        this.imagesFolder = new Folder(alapMappa, "images");
        this.etcFolder = new Folder(alapMappa, "etc");
    }

    public File upload(String nev, long size) {
        if(nev.endsWith(".gif") || nev.endsWith(".jpg") || nev.endsWith(".png")){
            File uj = new File(this.imagesFolder, nev, size);
            namer.rename(uj);
            System.out.println("Stored " + nev + " at "  + uj.fullPath() );
            System.out.println("Images size: " + size + " bytes");
            System.out.println("Etc size: 0 bytes");
            return uj;
        } else {
            File uj = new File(this.etcFolder, nev, size);
            namer.rename(uj);
            System.out.println("Stored " + nev + " at "  + uj.fullPath());
            System.out.println("Images size: 0 bytes");
            System.out.println("Etc size: " + size + " bytes");
            return uj;
        }
       
    }

}