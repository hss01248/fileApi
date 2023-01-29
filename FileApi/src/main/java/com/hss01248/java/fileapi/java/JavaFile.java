package com.hss01248.java.fileapi.java;




import com.hss01248.java.fileapi.BaseFileApi;
import com.hss01248.java.fileapi.IFile;


import java.io.*;
import java.net.URI;

public class JavaFile extends BaseFileApi<File> {
    public JavaFile(File file) {
        super(file);
    }

    @Override
    public String storageId() {
        return null;
    }

    @Override
    public IFile[] listFiles() {
        if(isDirectory()){
            File[] files = file.listFiles();
            if(files == null){
                return null;
            }
            IFile[] iFiles = new IFile[files.length];
            if(files != null){
                for (int i = 0; i < files.length; i++) {
                    iFiles[i] = new JavaFile(files[i]);
                }
            }
            return iFiles;
        }
        return null;
    }

    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    public URI getUri() {
        return URI.create("file://"+getPath());
    }

    @Override
    public String getPath() {
        return file.getAbsolutePath();
    }

    @Override
    public boolean isDirectory() {
        return file.isDirectory();
    }

    @Override
    public boolean isHidden() {
        if(isDirectory()){
            return new File(file,".nomedia").exists();
        }
        return new File(file.getParentFile(),".nomedia").exists();
    }

    @Override
    public long length() {
        return file.length();
    }

    @Override
    public long lastModified() {
        return file.lastModified();
    }

    @Override
    public long mediaTime() {
        return 0;
    }

    @Override
    public boolean exists() {
        return file.exists();
    }

    @Override
    public boolean delete() {
        return  file.delete();
    }

    @Override
    public boolean canWrite() {
        return file.canWrite();
    }

    @Override
    public IFile getParentFile() {
        if(file.getParentFile() ==  null){
            return null;
        }
        return new JavaFile(file.getParentFile());
    }

    @Override
    public String compress() {
        return "";
    }
    


    @Override
    public IFile createDirectory( String displayName) {
        File file1 = null;
        if(isDirectory()){
             file1 = new File(file,displayName);
            file1.mkdirs();
        }else {
            file1 = new File(file.getParentFile(),displayName);
            file1.mkdirs();
        }
        return new JavaFile(file1);
    }

    @Override
    public IFile createFile( String mimeType,  String displayName) {
        File file1 = null;
        if(isDirectory()){
            file1 = new File(file,displayName);
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            file1 = new File(file.getParentFile(),displayName);
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new JavaFile(file1);
    }

    @Override
    public boolean renameTo( String displayNameOrPath) {
        //todo java api: 同后缀名才能rename
        return file.renameTo(new File(file.getParentFile(),displayNameOrPath));
    }

    @Override
    public boolean isFile() {
        return file.isFile();
    }

    @Override
    public InputStream getInputStream() {
        try {
            return new FileInputStream(getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public OutputStream getOutPutStream() {
        try {
            return new FileOutputStream(getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
