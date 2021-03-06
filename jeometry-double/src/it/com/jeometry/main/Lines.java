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
package com.jeometry.main;

import com.aljebra.field.impl.doubles.Decimal;
import com.jeometry.model.decimal.DblPoint;
import com.jeometry.render.awt.Awt;
import com.jeometry.twod.Figure;
import com.jeometry.twod.line.Line;
import com.jeometry.twod.line.ParallelLine;
import com.jeometry.twod.line.PtDirLine;
import com.jeometry.twod.line.PtsLine;
import com.jeometry.twod.point.XyPoint;

/**
 * Main lines testing class using {@link Awt} output.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class Lines {

    /**
     * Private constructor.
     */
    private Lines() {
    }

    /**
     * Main start method.
     * @param args Unused args
     */
    public static void main(final String... args) {
        final XyPoint pointa = Lines.random();
        final XyPoint pointp = Lines.random();
        final XyPoint pointk = Lines.random();
        final Line line = new PtsLine(pointa, pointp);
        final Line second = new ParallelLine(line, pointk);
        final XyPoint pointb = Lines.random();
        final Line intersect = new PtsLine(pointa, pointb);
        final Line vert = new PtDirLine(pointb, new DblPoint(0., 1.));
        final Line hor = new PtDirLine(pointp, new DblPoint(1., 0.));
        final Figure figure = new Figure()
            .add(hor).add(vert).add(intersect).add(pointb).add(pointa)
            .add(second).add(line).add(pointp).add(pointk);
        final Awt awt = new Awt().withSize(50, 50);
        awt.render(figure);
        awt.setVisible(true);
    }

    /**
     * Generates a random point.
     * @return A random point
     */
    private static DblPoint random() {
        final Decimal field = new Decimal();
        return new DblPoint(
            field.actual(field.random()), field.actual(field.random())
        );
    }

}
