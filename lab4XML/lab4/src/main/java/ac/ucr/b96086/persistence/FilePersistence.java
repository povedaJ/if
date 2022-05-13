package ac.ucr.b96086.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class FilePersistence<E extends PersistenceEntity> {
    private String root;
    private String extension;


//public FilePersistence(String root, String extension){
//    this.root= root;
//}
    public FilePersistence(String root, String extension){
      this.root= root;
      this.extension= extension;
}
public void storeFile(E value ) throws IOException {

    File file= new File(root,value.getId()+ "."+ extension) ;
    String valueConverted= convert(value);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)); ) {
        writer.write(valueConverted);
    }
// por ser java 1.8 se debe escribir de otra forma , por eso no corre en el lab de la U
}// TODO

protected abstract String convert(E value);

    public boolean deleteFile(E value){
        File fileName= new File(root,value.getId()+ "."+ extension) ;
        if ( fileName.exists()){
            return fileName.delete();
        }else return true;
    }

    public List findAll(){
    return null;

    }


}// class
