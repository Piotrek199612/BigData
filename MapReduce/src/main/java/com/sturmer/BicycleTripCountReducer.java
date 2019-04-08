package com.sturmer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class BicycleTripCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    private IntWritable result = new IntWritable();

    @Override
    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context) throws IOException, InterruptedException {
        int count = 0;

        Text sumText = new Text(key);
        for (IntWritable ignored : values) count+=ignored.get();
        result.set(count);
        context.write(sumText, result);
    }
}
