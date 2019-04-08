package com.sturmer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BicycleTripCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text bike_id = new Text();

    public void map(LongWritable key, Text value, Context context) {
        try {
            if (key.get() == 0) return;
            else {
                String line = value.toString();
                bike_id.set(line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[3].replaceAll("\"",""));
                context.write(bike_id, new IntWritable(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
