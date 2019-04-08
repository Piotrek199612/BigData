package com.sturmer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Test;
import java.io.IOException;

public class BicycleTripCountMapperTest {

    @Test
    public void map() throws IOException {
        Text record = new Text("431,\"10/13/2014 10:31\",\"10/13/2014 10:48\",\"SEA00298\",985.935,\"2nd Ave & Spring St\",\"Occidental Park / Occidental Ave S & S Washington St\",\"CBD-06\",\"PS-04\",\"Member\",\"Male\",1960");
        new MapDriver<LongWritable, Text, Text, IntWritable>()
                .withMapper(new BicycleTripCountMapper())
                .withInput(new LongWritable(1), record)
                .withOutput(new Text("SEA00298"), new IntWritable(1))
                .runTest();
    }
}