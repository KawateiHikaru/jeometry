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
package com.jeometry.twod.line.analytics;

import com.aljebra.field.Field;
import com.aljebra.scalar.Add;
import com.aljebra.scalar.Multiplication;
import com.aljebra.scalar.Scalar;
import com.aljebra.scalar.condition.Equals;
import com.aljebra.scalar.condition.Predicate;
import com.aljebra.vector.Vect;
import com.jeometry.twod.line.Line;

/**
 * A predicate to determine if a point belongs to a line.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class PointInLine implements Predicate {

    /**
     * Point.
     */
    private final Vect point;

    /**
     * Line.
     */
    private final Line line;

    /**
     * Constructor.
     * @param point Point
     * @param line Line
     */
    public PointInLine(final Vect point, final Line line) {
        this.point = point;
        this.line = line;
    }

    @Override
    public boolean resolve(final Field<?> field) {
        final Scalar xcoor = this.point.coords()[0];
        final Predicate result;
        if (new Vertical(this.line).resolve(field)) {
            result = new Equals(xcoor, this.line.point().coords()[0]);
        } else {
            final LineAnalytics analytics = new LineAnalytics(this.line);
            result = new Equals(
                this.point.coords()[1],
                new Add(
                    new Multiplication(xcoor, analytics.slope()),
                    analytics.intercept()
                )
            );
        }
        return result.resolve(field);
    }

}
