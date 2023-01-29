package com.hss01248.java.fileapi;


public interface IDirOperation {

    boolean createDir( IFile target);
    boolean copyDir(IFile source,IFile target);

    boolean moveDir(IFile source,IFile target);

    boolean deleteFile(IFile source,IFile target);
}
