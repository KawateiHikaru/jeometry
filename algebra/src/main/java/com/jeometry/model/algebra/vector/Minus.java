/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2016, Hamdi Douss
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.jeometry.model.algebra.vector;

import com.google.common.base.Preconditions;
import com.jeometry.model.algebra.scalar.Diff;
import com.jeometry.model.algebra.scalar.Scalar;

/**
 * A vector represented as the difference between two vectors.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class Minus implements Vect {
    /**
     * First operand.
     */
    private final Vect first;

    /**
     * Second operand.
     */
    private final Vect second;

    /**
     * Constructor.
     * @param first First operand (minuend)
     * @param second Second operand (subtrahend)
     */
    public Minus(final Vect first, final Vect second) {
        Preconditions.checkArgument(
            first.coords().length == second.coords().length,
            "Vectors should have same dimension: %s dim %d, %s dim %d.",
            first, first.coords().length, second, second.coords().length
        );
        this.first = first;
        this.second = second;
    }

    @Override
    public Scalar[] coords() {
        final Scalar[] fcoors = this.first.coords();
        final Scalar[] scoors = this.second.coords();
        final int dim = fcoors.length;
        final Scalar[] result = new Scalar[dim];
        for (int axis = 0; axis < dim; ++axis) {
            result[axis] = new Diff(fcoors[axis], scoors[axis]);
        }
        return result;
    }

}