/*
 * The MIT License
 *
 * Copyright (c) 2009 The Broad Institute
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package picard.illumina;

import htsjdk.samtools.util.SequenceUtil;
import htsjdk.samtools.util.StringUtil;
import picard.util.AdapterPair;

public class CustomAdapterPair implements AdapterPair {

    private final String fivePrime, threePrime, fivePrimeReadOrder;
    private final byte[] fivePrimeBytes, threePrimeBytes, fivePrimeReadOrderBytes;

    public CustomAdapterPair(final String fivePrime, final String threePrime) {
        this.threePrime = threePrime;
        this.threePrimeBytes = StringUtil.stringToBytes(threePrime);

        this.fivePrime = fivePrime;
        this.fivePrimeReadOrder = SequenceUtil.reverseComplement(fivePrime);
        this.fivePrimeBytes = StringUtil.stringToBytes(fivePrime);
        this.fivePrimeReadOrderBytes = StringUtil.stringToBytes(fivePrimeReadOrder);
    }

    public String get3PrimeAdapter() { return threePrime; }

    public String get5PrimeAdapter() { return fivePrime; }

    public String get3PrimeAdapterInReadOrder() { return threePrime; }

    public String get5PrimeAdapterInReadOrder() { return fivePrimeReadOrder; }

    public byte[] get3PrimeAdapterBytes() { return threePrimeBytes; }

    public byte[] get5PrimeAdapterBytes() { return fivePrimeBytes; }

    public byte[] get3PrimeAdapterBytesInReadOrder() { return threePrimeBytes; }

    public byte[] get5PrimeAdapterBytesInReadOrder() { return fivePrimeReadOrderBytes; }

    public String getName() { return "Custom adapter pair"; }
}