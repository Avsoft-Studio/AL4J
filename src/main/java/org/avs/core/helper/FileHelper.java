package org.avs.core.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.avs.core.annotations.NotNull;
import org.avs.core.ConstHelper;

public final class FileHelper {
	public static final transient String rootPath = new File("").getAbsolutePath();
	
	public static String fileToString(@NotNull String path) throws IOException {
		return fileToString(path, new StringBuffer());
	}
	
	public static String fileToString(@NotNull String path, boolean useFileCapacity) throws IOException {
		if(!useFileCapacity) return fileToString(path);
		File file = new File(path);
		return !file.exists() ? null : fileToString(path, new StringBuffer((int) file.length()));
	}
	
	private static String fileToString(@NotNull String path, @NotNull StringBuffer builder) throws IOException {
		String line;
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
			while((line = buffer.readLine()) != null) builder.append(line+"\n");
			return builder.toString();
		}
	}

	public static boolean createFolder(@NotNull String path, @NotNull String name) {
		return createFolder(path + File.separatorChar + name);
	}
	
	public static boolean createFolder(@NotNull String path) throws SecurityException {
		File dir = new File(path);
		return (dir.exists() && dir.isDirectory()) ? true : dir.mkdirs();
	}
	
	public static boolean createFile(@NotNull String filePath, @NotNull String fileName) throws IOException, SecurityException {
		return createFile(filePath + File.separatorChar + fileName);
	}
	
	public static boolean createFile(@NotNull String path) throws IOException, SecurityException {
		File file = new File(path);
		return !file.exists() ? file.createNewFile() : true;
	}
	
	public static List<File> GetSubFile(final String path, final boolean recursive) throws Exception{
		return GetSubFile(new File(path), recursive);
	}
	
	public static List<File> GetSubFile(final File directory, final boolean recursive) throws Exception{
		if(!directory.exists() || !directory.isDirectory()) {
			throw new Exception("The file given doesn't exist or isn't a directory");
		}
		List<File> directories = new ArrayList<File>();
		for(final File file : directory.listFiles()) {
			if(file.isDirectory()) {
				directories.add(file);
				if(recursive) {
					directories.addAll(GetSubFile(file, recursive));
				}
			}
		}
		return directories;
	}
	
	public static String ClassNameByPath(File fileClass) {
		String path = StringHelper.substringAfter(fileClass.getAbsolutePath(), "bin\\");
		return path.substring(0, path.length()-6);
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> GetClasses(final String packname, final boolean includeSubDir) throws Exception{
		String path = packname.replace('.', '/');
		URL resource = Thread.currentThread().getContextClassLoader().getResource(path);
		if (resource == null) {
			throw new ClassNotFoundException("No resource for " + path);
		}
		return GetClasses(new File(resource.getFile()), includeSubDir);
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> GetClasses(final File directory, final boolean includeSubDir) throws Exception{
		if(!directory.exists() || !directory.isDirectory()) {
			throw new Exception("The file given doesn't exist or isn't a directory");
		}
		List<Class> classes = new ArrayList<Class>();
		for(final File file: directory.listFiles()) {
			if(file.isDirectory() && includeSubDir) {
				classes.addAll(GetClasses(file, includeSubDir));
			}
			else if(file.getAbsolutePath().endsWith(ConstHelper.ClassExtension)) {
				String className = ClassNameByPath(file).replace('\\', '.');
				classes.add(Class.forName(className));
			}
		}
		return classes;
	}
}
