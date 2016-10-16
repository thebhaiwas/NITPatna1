package okhttp3.internal.framed;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Source;

class NameValueBlockReader {
    private int compressedLimit;
    private final InflaterSource inflaterSource;
    private final BufferedSource source;

    /* renamed from: okhttp3.internal.framed.NameValueBlockReader.2 */
    class C03232 extends Inflater {
        C03232() {
        }

        public int inflate(byte[] buffer, int offset, int count) throws DataFormatException {
            int result = super.inflate(buffer, offset, count);
            if (result != 0 || !needsDictionary()) {
                return result;
            }
            setDictionary(Spdy3.DICTIONARY);
            return super.inflate(buffer, offset, count);
        }
    }

    /* renamed from: okhttp3.internal.framed.NameValueBlockReader.1 */
    class C05911 extends ForwardingSource {
        C05911(Source x0) {
            super(x0);
        }

        public long read(Buffer sink, long byteCount) throws IOException {
            if (NameValueBlockReader.this.compressedLimit == 0) {
                return -1;
            }
            long read = super.read(sink, Math.min(byteCount, (long) NameValueBlockReader.this.compressedLimit));
            if (read == -1) {
                return -1;
            }
            NameValueBlockReader.this.compressedLimit = (int) (((long) NameValueBlockReader.this.compressedLimit) - read);
            return read;
        }
    }

    public NameValueBlockReader(BufferedSource source) {
        this.inflaterSource = new InflaterSource(new C05911(source), new C03232());
        this.source = Okio.buffer(this.inflaterSource);
    }

    public List<Header> readNameValueBlock(int length) throws IOException {
        this.compressedLimit += length;
        int numberOfPairs = this.source.readInt();
        if (numberOfPairs < 0) {
            throw new IOException("numberOfPairs < 0: " + numberOfPairs);
        } else if (numberOfPairs > AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) {
            throw new IOException("numberOfPairs > 1024: " + numberOfPairs);
        } else {
            List<Header> entries = new ArrayList(numberOfPairs);
            for (int i = 0; i < numberOfPairs; i++) {
                ByteString name = readByteString().toAsciiLowercase();
                ByteString values = readByteString();
                if (name.size() == 0) {
                    throw new IOException("name.size == 0");
                }
                entries.add(new Header(name, values));
            }
            doneReading();
            return entries;
        }
    }

    private ByteString readByteString() throws IOException {
        return this.source.readByteString((long) this.source.readInt());
    }

    private void doneReading() throws IOException {
        if (this.compressedLimit > 0) {
            this.inflaterSource.refill();
            if (this.compressedLimit != 0) {
                throw new IOException("compressedLimit > 0: " + this.compressedLimit);
            }
        }
    }

    public void close() throws IOException {
        this.source.close();
    }
}
