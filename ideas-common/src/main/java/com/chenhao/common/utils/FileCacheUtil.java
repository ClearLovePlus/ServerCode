package com.chenhao.common.utils;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:文件缓存工具类，主要用于实现冷热数据分离
 * @author: chenhao
 * @date: 2021-6-7 15:27
 */
public class FileCacheUtil {

    private static FileCacheUtil INSTANCE = null;
    /**
     * 由于上传的文件名字会因为系统原因进行变更，所以在此用于记录最新的一次文件名字
     * 这个最好持久化到数据库中，文件名格式需要根据不同的用户
     */
    private static final Map<String, String> fileNameCache = new ConcurrentHashMap<>();
    /**
     * 文件缓存，只存储热数据
     */
    private static final Map<String, File> fileCache = new ConcurrentHashMap<>();

    /**
     * 私有的构造方法不允许以new的方式实例
     */
    private FileCacheUtil() {

    }

    /**
     * 单例模式获取FileCacheUtil实例
     *
     * @return
     */
    public static FileCacheUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (FileCacheUtil.class) {
                INSTANCE = new FileCacheUtil();
            }
        }
        System.out.println("FileCacheUtil init succeed");
        return INSTANCE;
    }

    /**
     * 获取对应的属性，由于static属性的值在对象尚未构造的时候就已经初始化
     * 所以不能用this指针
     *
     * @return
     */
    public  Map<String, String> getFileNameCache() {
        return fileNameCache;
    }

    /**
     * 获取对应的属性，由于static属性的值在对象尚未构造的时候就已经初始化
     * 所以不能用this指针
     *
     * @return
     */
    public  Map<String, File> getFileCache() {
        return fileCache;
    }

    /**
     * 往本地缓存中存储数据
     *
     * @param sourceFileName
     * @param targetFileName
     */
    public  void putFileName(String sourceFileName, String targetFileName) {
        //永远更新成上传的最新的文件
        fileNameCache.put(sourceFileName, targetFileName);
    }

    /**
     * 获取上传的文件转换过后的文件名字
     *
     * @param fileName
     * @return
     */
    public  String getTargetFileName(String fileName) {
        return fileNameCache.get(fileName);
    }

    /**
     * 往本地缓存中添加文件数据
     * @param fileName
     * @param file
     */
    public void putFileSource(String fileName, File file) {
        fileCache.put(fileName, file);
    }

    /**
     * 获取在本地缓存中的文件字节流
     * @param fileName
     * @return
     */
    public File getFileCached(String fileName){
        return fileCache.get(fileName);
    }

}
