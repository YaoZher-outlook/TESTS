package Tests3;

import java.io.File;
import java.util.HashMap;

public class FilePractice6_countFilesTypes {
    public static void main(String[] args) {
        File file = new File("E:\\TestFiles");
        HashMap<String, Integer> result = countFilesTypes(file, new HashMap<>());
        for(String key : result.keySet()){
            System.out.println(key + " : " + result.get(key));
        }
    }

    public static HashMap<String, Integer> countFilesTypes(File file, HashMap<String, Integer> hm){
        File[] files = file.listFiles();
        if(files == null){
            return hm;
        }else{for(File f : files){
            if(f.isFile()){
                String[] arr = f.getName().split("\\.");
                String ext = arr[arr.length - 1];
                    if(hm.containsKey(ext)){
                        hm.put(ext, hm.get(ext) + 1);
                    }else{
                    hm.put(ext,1);
                    }
                }else if(f.isDirectory()){
                    HashMap<String, Integer> subDirMap = countFilesTypes(f, new HashMap<>());
                    for(String key : subDirMap.keySet()){
                        hm.put(key, hm.getOrDefault(key, 0) + subDirMap.get(key));
                    }
                }
            }
        return hm; 
        }
    }
}
