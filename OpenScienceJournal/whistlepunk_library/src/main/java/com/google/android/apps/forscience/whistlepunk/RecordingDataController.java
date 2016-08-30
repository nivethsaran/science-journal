/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.android.apps.forscience.whistlepunk;

import com.google.android.apps.forscience.javalib.FailureListener;
import com.google.android.apps.forscience.javalib.MaybeConsumer;
import com.google.android.apps.forscience.javalib.Success;
import com.google.android.apps.forscience.whistlepunk.metadata.RunStats;

/**
 * Data interface for sensor recorders
 */
public interface RecordingDataController {
    /**
     * @see com.google.android.apps.forscience.whistlepunk.sensordb.SensorDatabase#addScalarReading(String, int, long, double)
     */
    void addScalarReading(String sensorId, final int resolutionTier, long timestampMillis,
            double value);

    /**
     * Set the statistics for the given run and sensor
     *
     * @param runId (previously startLabelId) identifies the run
     */
    void setStats(String runId, String sensorId, RunStats runStats,
            MaybeConsumer<Success> onSuccess);

    /**
     * If an error is encountered storing data or stats for {@code sensorId}, notify {@code
     * listener}
     */
    void setDataErrorListenerForSensor(String sensorId, FailureListener listener);

    /**
     * Clear listener set by earlier call to {@code setDataErrorListener}
     */
    void clearDataErrorListenerForSensor(String sensorId);
}
