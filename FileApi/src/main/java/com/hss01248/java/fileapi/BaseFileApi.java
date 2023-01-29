package com.hss01248.java.fileapi;

public abstract class BaseFileApi<T> implements IFile {

   protected T file;

    public BaseFileApi(T file) {
        this.file = file;
    }
}
