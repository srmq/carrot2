
/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2016, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * http://www.carrot2.org/carrot2.LICENSE
 */

package org.carrot2.clustering.lingo;

import org.carrot2.text.preprocessing.PreprocessingContext;
import org.carrot2.text.preprocessing.PreprocessingContext.AllLabels;
import org.carrot2.text.vsm.ReducedVectorSpaceModelContext;
import org.carrot2.text.vsm.VectorSpaceModelContext;

import com.carrotsearch.hppc.BitSet;

/**
 * Stores intermediate data required during Lingo clustering.
 */
public class LingoProcessingContext
{
    /** Preprocessing context */
    public final PreprocessingContext preprocessingContext;

    /** Vector space model context */
    public final VectorSpaceModelContext vsmContext;

    /** Vector space model context */
    public final ReducedVectorSpaceModelContext reducedVsmContext;

    /** Feature indices (like in {@link AllLabels#featureIndex}) that should form clusters */
    int [] clusterLabelFeatureIndex;

    /** Scores for cluster labels */
    double [] clusterLabelScore;

    /** Documents assigned to clusters */
    BitSet [] clusterDocuments;

    LingoProcessingContext(ReducedVectorSpaceModelContext reducedVsmContext)
    {
        this.reducedVsmContext = reducedVsmContext;
        this.vsmContext = reducedVsmContext.vsmContext;
        this.preprocessingContext = vsmContext.preprocessingContext;
    }
}
