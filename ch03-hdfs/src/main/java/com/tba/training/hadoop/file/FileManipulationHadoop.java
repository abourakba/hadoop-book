package com.tba.training.hadoop.file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import  org.apache.hadoop.fs.Path;


/**
 * Created by ab186131 on 06/06/2017.
 *
 * hadoop ListStatus hdfs://localhost/ hdfs://localhost/user/tom
 *
 */
public class FileManipulationHadoop {

    public static void main(String[] args){
        System.out.println("FileManipulationHadoop : Salut ! ");
        FileManipulationHadoop exec =  new FileManipulationHadoop();
        System.out.println("FileManipulationHadoop : Creation ! ");
        exec.createFile();
        System.out.println("FileManipulationHadoop : Fin ! ");
    }

    /**
     * Dans ce cas on va ecricre un fichier dans HDFS
     * */
    public void createFile(){
        String content = "Content";
        Configuration conf  = new Configuration();
        String uri = "hdfs://control:8020/vagrant/hadoopbook.content.txt";

        FileSystem fs = null ;
        try{
            try{
                System.out.println("FileManipulationHadoop : Attaque ! ");
                fs = FileSystem.get(URI.create(uri), conf);
                Path p = new Path("hello.txt");
                OutputStream out = fs.create(p);
                out.write(content.getBytes("UTF-8"));
                System.out.println("FileManipulationHadoop : Fin des haricots ! ");
                out.flush();
                out.close();
            }catch(Exception e ) {
                e.printStackTrace();
            }

        }finally{
            if( fs != null  ) {
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
