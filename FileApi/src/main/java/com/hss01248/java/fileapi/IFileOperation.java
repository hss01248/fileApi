package com.hss01248.java.fileapi;

import java.io.InputStream;

public interface IFileOperation {


    boolean createFile(InputStream source, IFile target,boolean overrideIfExist);

    boolean copyFile(IFile source,IFile target);

    boolean moveFile(IFile source,IFile target);

    boolean deleteFile(IFile source,IFile target);
}
