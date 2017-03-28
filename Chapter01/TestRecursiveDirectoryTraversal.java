package chap1.java.science.data;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class TestRecursiveDirectoryTraversal {
	public static void main(String[] args){
		System.out.println(listFiles(new File("")).size());
	}
	
	public static Set<File> listFiles(File rootDir) {
	    Set<File> fileSet = new HashSet<File>();
	    if(rootDir == null || rootDir.listFiles()==null){
	        return fileSet;
	    }
	    for (File fileOrDir : rootDir.listFiles()) {
             if (fileOrDir.isFile()){
               fileSet.add(fileOrDir);
             }
             else{
               fileSet.addAll(listFiles(fileOrDir));
             }
     }

	    return fileSet;
	}
}
