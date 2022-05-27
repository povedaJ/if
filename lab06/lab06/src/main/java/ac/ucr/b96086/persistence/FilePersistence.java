/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ucr.b96086.persistence;

import java.io.*;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author viviana
 */
public abstract class FilePersistence<E extends PersistenceEntity> implements Persistence<E> {

    private String root;
    //String-Classs -> nombre de la entidad
    private String extension;
    protected Class<E> clazz;

    public FilePersistence(String root, String extension, Class<E> clazz) {
        this.root = root;
        this.extension = extension;
        this.clazz = clazz;
    }

    /**
     * Guarda archivos de acuerdo a su extensión(XML o JSON) y los convierte
     *
     * @return
     */
    public void storeFile(E value) throws IOException {
        File file = new File(root, clazz.getCanonicalName() + "-" + value.getId() + "." + extension);
        String valueConverted = convert(value);
        // Java 8
//        BufferedWriter writer2=null;
//        try {
//            writer2= new BufferedWriter(new FileWriter(file));
//        }finally {
//
//            writer2.close();
//        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)); writer) {
            writer.write(valueConverted);
        }
    }

    protected abstract String convert(E value);

    public boolean deleteFile(E value) {
        File fileName = new File(root, clazz.getCanonicalName() + "-" + value.getId() + "." + extension);
        if (fileName.exists()) {
            return fileName.delete();
        } else {
            return false;
        }
    }

    public List<E> findAll() {
        //Va a buscar todos los tipos de un archivo
        File rootFolder = new File(root);

        List<E> entities = Arrays.stream(rootFolder.listFiles())
                .filter(file -> file.getName().startsWith(clazz.getCanonicalName() + "-") &&
                        file.getName().endsWith(extension))
                .map(file -> convertToEntity(file))
                .collect(Collectors.toList());//Una manera de recorrer arreglos o colecciones
        return entities;
    }

    private E convertToEntity(File file) {
//Leer archivo y convertirlo usando la clase especializada
        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(file.toPath());
            String content = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            return toEntity(content);//abstracto
        } catch (IOException e) {
            e.printStackTrace();
            //lanzar la exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    //Este close se debe de hacer porque hay recursos externos
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

    public abstract E toEntity(String content);


}
