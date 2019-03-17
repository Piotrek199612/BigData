hadoop fs -copyFromLocal station.csv labs/hadoop/mapreduce/input/station.csv
hadoop jar /usr/hdp/3.0.1.0-187/hadoop-mapreduce/hadoop-streaming.jar -files AvgSizeStationsMap.py,AvgSizeStationsReduce.py  -input labs/hadoop/mapreduce/input/station.csv -output outputStreaming -mapper AvgSizeStationsMap.py -reducer AvgSizeStationsReduce.py
hadoop fs -copyToLocal outputStreaming
hadoop fs -rm -r outputStreaming