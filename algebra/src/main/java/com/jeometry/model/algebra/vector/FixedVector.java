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

import com.jeometry.model.algebra.scalar.Scalar;
import java.util.Arrays;
import lombok.EqualsAndHashCode;

/**
 * Represents a vector defined by fixed coordinates.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode
public class FixedVector implements Vect {

    /**
     * Coordinates.
     */
    private Scalar[] coors;

    /**
     * Constructor.
     * @param coor Vector coordinates
     */
    public FixedVector(final Scalar... coor) {
        super();
        this.coors = coor;
    }

    /**
     * Modifies a coordinate of the vector.
     * @param axis The base component to which the new coordinate is applied.
     * @param cor New coordinate
     */
    public final void setCoor(final int axis, final Scalar cor) {
        this.coors[axis] = cor;
    }

    @Override
    public final Scalar[] coords() {
        return Arrays.copyOf(this.coors, this.coors.length);
    }

}