/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.hadoop;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

/**
 *
 * @author ubuntu
 */
public class HdfsClient {
    public static void main(String[]args) throws IOException{
        String hadoopConf = "/home/ubuntu/hadoop-2.7.4/etc/hadoop";
        
        Configuration conf = new Configuration();
        conf.addResource(new Path(hadoopConf+"/core-site.xml"));
        conf.addResource(new Path(hadoopConf+"/hdfs-site.xml"));
        conf.addResource(new Path(hadoopConf+"/mapred-site.xml"));
        conf.set("fs.file.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl",org.apache.hadoop.fs.LocalFileSystem.class.getName());
        FileSystem fileSystem = FileSystem.get(conf);
        RemoteIterator<LocatedFileStatus> iterator = fileSystem.listFiles(new Path("/"), true);
       
        while(iterator.hasNext()){
            LocatedFileStatus fileStatus = iterator.next();
            Path path = fileStatus.getPath();
            System.out.println(path);
        }
        
    }
}
