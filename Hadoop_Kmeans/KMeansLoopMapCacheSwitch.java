package org.apache.hadoop.examples.kmeans;

import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.iterative.LoopMapCacheSwitch;

public class KMeansLoopMapCacheSwitch implements LoopMapCacheSwitch {

        @Override
        public boolean isCacheRead(JobConf conf, int iteration, int step) {
                if (iteration > 0)
                        return true;
                else
                        return false;
        }

        @Override
        public boolean isCacheWritten(JobConf conf, int iteration, int step) {
                if (iteration == 0 && step == 0)
                        return true;
                else
                        return false;
        }

}