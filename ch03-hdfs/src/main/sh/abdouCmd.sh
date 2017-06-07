#!/usr/bin/env bash

# First Compile the project
cd /Users/ab186131/workspaces/ideawksp/hadoop-book/ch03-hdfs
mvn clean install
# Then Copy the Jar to the vagrant directory.
cp target/ch03-hdfs-4.0.jar ~/Documents/BootCamp/bootcamp-Mar-2017/vagrant/hadoop-book/chap03/

## Ligne de commande a executer dans la machine vagrant :
hadoop jar ch03-hdfs-4.0.jar  com.tba.training.hadoop.file.FileManipulationHadoop
## Puis il faut verifier que le fichier  ait été correctement ecrit.
hadoop fs -ls .
# ou alors
hadoop fs -ls /

# hdfs dfs -get hdfs://control:8020/vagrant/executable/res.txt /vagrant/executable/res.txt
hdfs dfs -get  hdfs://control:8020/vagrant/hadoopbook/content.txt  /vagrant/hadoopbook/content.txt


