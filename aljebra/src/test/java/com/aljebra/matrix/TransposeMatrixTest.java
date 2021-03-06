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
package com.aljebra.matrix;

import com.aljebra.scalar.Scalar;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Tests for {@link TransposeMatrix}.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class TransposeMatrixTest {

    /**
     * {@link TransposeMatrix} calculates coordinates.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void calculatesTransposedCoordinates() {
        final int lines = 3;
        final int cols = 2;
        final Scalar scala = Mockito.mock(Scalar.class);
        final Scalar scalb = Mockito.mock(Scalar.class);
        final Scalar scalc = Mockito.mock(Scalar.class);
        final Scalar scald = Mockito.mock(Scalar.class);
        final Scalar scale = Mockito.mock(Scalar.class);
        final Scalar scalf = Mockito.mock(Scalar.class);
        final Matrix matrix = new TransposeMatrix(
            new FixedMatrix(
                lines, cols, scala, scalb, scalc, scald, scale, scalf
            )
        );
        MatcherAssert.assertThat(
            matrix.coords(),
            Matchers.array(
                Matchers.equalTo(scala), Matchers.equalTo(scald),
                Matchers.equalTo(scalb), Matchers.equalTo(scale),
                Matchers.equalTo(scalc), Matchers.equalTo(scalf)
            )
        );
    }

    /**
     * {@link TransposeMatrix} can return lines and columns.
     */
    @Test
    public void returnsLinesAndColumns() {
        final int lines = 3;
        final int cols = 4;
        final Matrix matrix = new TransposeMatrix(
            new FixedMatrix(
                lines, cols, TransposeMatrixTest.scalars(lines * cols)
            )
        );
        MatcherAssert.assertThat(matrix.lines(), Matchers.equalTo(cols));
        MatcherAssert.assertThat(matrix.columns(), Matchers.equalTo(lines));
    }

    /**
     * Mocks an array of {@link Scalar} with a given length.
     * @param length Array length
     * @return An array of scalars
     */
    private static Scalar[] scalars(final int length) {
        final Scalar[] result = new Scalar[length];
        for (int idx = 0; idx < result.length; ++idx) {
            result[idx] = Mockito.mock(Scalar.class);
        }
        return result;
    }
}
