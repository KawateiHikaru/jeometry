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
package com.aljebra.scalar;

import com.aljebra.field.Field;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Tests for {@link Scalar}.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class ScalarTest {

    /**
     * Scalar.Default respects equals on value.
     */
    @Test
    public void respectsEqual() {
        MatcherAssert.assertThat(
            new Scalar.Default<Double>(1.),
            Matchers.equalTo(new Scalar.Default<Double>(1.))
        );
        final String test = "test";
        MatcherAssert.assertThat(
            new Scalar.Default<String>(test),
            Matchers.equalTo(new Scalar.Default<String>(test))
        );
    }

    /**
     * {@link Scalar.Default} relies on field to calculate actual value.
     */
    @Test
    public void delegatesToField() {
        final Scalar first = new Scalar.Default<Double>(1.);
        final Field<?> field = Mockito.mock(Field.class);
        first.value(field);
        Mockito.verify(field).actual(first);
    }

    /**
     * Scalar can build addition.
     */
    @Test
    public void buildsAddition() {
        final Scalar scalar = new Scalar.Default<Object>(null);
        final Scalar other = new Scalar.Default<Object>(null);
        MatcherAssert.assertThat(
            scalar.add(other),
            Matchers.equalTo(new Add(scalar, other))
        );
    }

    /**
     * Scalar can build multiplication.
     */
    @Test
    public void buildsMultiplication() {
        final Scalar scalar = new Scalar.Default<Object>(null);
        final Scalar other = new Scalar.Default<Object>(null);
        MatcherAssert.assertThat(
            scalar.mult(other),
            Matchers.equalTo(new Multiplication(scalar, other))
        );
    }
}
