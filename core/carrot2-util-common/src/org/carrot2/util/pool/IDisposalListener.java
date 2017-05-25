
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

package org.carrot2.util.pool;

/**
 * Pooled object disposal listener.
 */
public interface IDisposalListener<T, P>
{
    /**
     * Called before the object is disposed of.
     */
    public void dispose(T object, P parameter);
}
