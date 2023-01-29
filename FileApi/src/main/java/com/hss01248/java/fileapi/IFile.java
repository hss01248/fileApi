package com.hss01248.java.fileapi;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * @Despciption todo
 * @Author hss
 * @Date 29/01/2023 10:08
 * @Version 1.0
 */
public interface IFile {
    String storageId();

    IFile[] listFiles();

    String getName();

    URI getUri();

    String getPath();

    boolean isDirectory();

    boolean isHidden();

    long length();

    long lastModified();

    long mediaTime();

    boolean exists();

    boolean delete();

    boolean canWrite();

    IFile getParentFile();

    String compress();

    //BaseBean syncToServer();

    default int getHasSynced(){
        return 0;
    }



    IFile createDirectory( String displayName);

    IFile createFile( String mimeType,  String displayName);

    default IFile findFile( String displayName){
        IFile[] iFiles = listFiles();
        for (IFile doc : iFiles) {
            if (displayName.equals(doc.getName())) {
                return doc;
            }
        }
        return null;
    }

    boolean renameTo( String displayNameOrPath);

    InputStream getInputStream();

    OutputStream getOutPutStream();

    public default boolean canSync() {
        return false;
    }

    default boolean isFile(){
        return !isDirectory();
    }

}
