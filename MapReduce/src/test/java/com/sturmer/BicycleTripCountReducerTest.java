package com.sturmer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;


public class BicycleTripCountReducerTest {

    @Test
    public void reduce() throws IOException {
        new ReduceDriver<Text, IntWritable, Text, IntWritable>()
                .withReducer(new BicycleTripCountReducer()).
                withInput(new Text("SEA00298"), Arrays.asList(new IntWritable(1), new IntWritable(1)))
                .withOutput(new Text("SEA00298"),new IntWritable(2))
                .runTest();
    }
}