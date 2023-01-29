package com.hss01248.java.fileapidemo;

import com.hss01248.java.fileapi.IFile;
import com.hss01248.java.fileapi.IFileOperation;

import java.io.InputStream;

/**
 * @Despciption todo
 * @Author hss
 * @Date 29/01/2023 10:20
 * @Version 1.0
 */
public class FileApiImpl implements IFileOperation {
    @Override
    public boolean createFile(InputStream source, IFile target, boolean overrideIfExist) {
        return false;
    }

    @Override
    public boolean copyFile(IFile source, IFile target) {
        return false;
    }

    @Override
    public boolean moveFile(IFile source, IFile target) {
        return false;
    }

    @Override
    public boolean deleteFile(IFile source, IFile target) {
        return false;
    }
}
