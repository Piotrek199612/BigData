package com.sturmer;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.Logger;

public class BicycleTripCount extends Configured implements Tool {

    private static final Logger LOG = Logger.getLogger(BicycleTripCount.class);

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new BicycleTripCount(), args);
        System.exit(res);
    }


    @Override
    public int run(String[] strings) throws Exception {
        Job job = Job.getInstance(getConf(), "BicycleTripCount");
        job.setJarByClass(this.getClass());
        FileInputFormat.addInputPath(job, new Path(strings[0]));
        FileOutputFormat.setOutputPath(job, new Path(strings[1]));
        job.setMapperClass(BicycleTripCountMapper.class);
        job.setCombinerClass(BicycleTripCountReducer.class);
        job.setReducerClass(BicycleTripCountReducer .class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        return job.waitForCompletion(true) ?0:1;
    }
}


