package okhttp3.internal.framed;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class FramedStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    long bytesLeftInWriteWindow;
    private final FramedConnection connection;
    private ErrorCode errorCode;
    private final int id;
    private final StreamTimeout readTimeout;
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final FramedDataSink sink;
    private final FramedDataSource source;
    long unacknowledgedBytesRead;
    private final StreamTimeout writeTimeout;

    final class FramedDataSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final long EMIT_BUFFER_SIZE = 16384;
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer;

        static {
            $assertionsDisabled = !FramedStream.class.desiredAssertionStatus() ? true : $assertionsDisabled;
        }

        FramedDataSink() {
            this.sendBuffer = new Buffer();
        }

        public void write(Buffer source, long byteCount) throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(FramedStream.this)) {
                this.sendBuffer.write(source, byteCount);
                while (this.sendBuffer.size() >= EMIT_BUFFER_SIZE) {
                    emitDataFrame($assertionsDisabled);
                }
                return;
            }
            throw new AssertionError();
        }

        private void emitDataFrame(boolean outFinished) throws IOException {
            synchronized (FramedStream.this) {
                FramedStream.this.writeTimeout.enter();
                while (FramedStream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && FramedStream.this.errorCode == null) {
                    try {
                        FramedStream.this.waitForIo();
                    } catch (Throwable th) {
                        FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
                    }
                }
                FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
                FramedStream.this.checkOutNotClosed();
                long toWrite = Math.min(FramedStream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                FramedStream framedStream = FramedStream.this;
                framedStream.bytesLeftInWriteWindow -= toWrite;
            }
            FramedStream.this.writeTimeout.enter();
            try {
                FramedConnection access$500 = FramedStream.this.connection;
                int access$600 = FramedStream.this.id;
                boolean z = (outFinished && toWrite == this.sendBuffer.size()) ? true : $assertionsDisabled;
                access$500.writeData(access$600, z, this.sendBuffer, toWrite);
            } finally {
                FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        public void flush() throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(FramedStream.this)) {
                synchronized (FramedStream.this) {
                    FramedStream.this.checkOutNotClosed();
                }
                while (this.sendBuffer.size() > 0) {
                    emitDataFrame($assertionsDisabled);
                    FramedStream.this.connection.flush();
                }
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return FramedStream.this.writeTimeout;
        }

        public void close() throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(FramedStream.this)) {
                synchronized (FramedStream.this) {
                    if (this.closed) {
                        return;
                    }
                    if (!FramedStream.this.sink.finished) {
                        if (this.sendBuffer.size() > 0) {
                            while (this.sendBuffer.size() > 0) {
                                emitDataFrame(true);
                            }
                        } else {
                            FramedStream.this.connection.writeData(FramedStream.this.id, true, null, 0);
                        }
                    }
                    synchronized (FramedStream.this) {
                        this.closed = true;
                    }
                    FramedStream.this.connection.flush();
                    FramedStream.this.cancelStreamIfNecessary();
                    return;
                }
            }
            throw new AssertionError();
        }
    }

    private final class FramedDataSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled;
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;

        static {
            $assertionsDisabled = !FramedStream.class.desiredAssertionStatus();
        }

        private FramedDataSource(long maxByteCount) {
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = maxByteCount;
        }

        public long read(Buffer sink, long byteCount) throws IOException {
            if (byteCount < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + byteCount);
            }
            long j;
            synchronized (FramedStream.this) {
                waitUntilReadable();
                checkNotClosed();
                if (this.readBuffer.size() == 0) {
                    j = -1;
                } else {
                    j = this.readBuffer.read(sink, Math.min(byteCount, this.readBuffer.size()));
                    FramedStream framedStream = FramedStream.this;
                    framedStream.unacknowledgedBytesRead += j;
                    if (FramedStream.this.unacknowledgedBytesRead >= ((long) (FramedStream.this.connection.okHttpSettings.getInitialWindowSize(AccessibilityNodeInfoCompat.ACTION_CUT) / 2))) {
                        FramedStream.this.connection.writeWindowUpdateLater(FramedStream.this.id, FramedStream.this.unacknowledgedBytesRead);
                        FramedStream.this.unacknowledgedBytesRead = 0;
                    }
                    synchronized (FramedStream.this.connection) {
                        FramedConnection access$500 = FramedStream.this.connection;
                        access$500.unacknowledgedBytesRead += j;
                        if (FramedStream.this.connection.unacknowledgedBytesRead >= ((long) (FramedStream.this.connection.okHttpSettings.getInitialWindowSize(AccessibilityNodeInfoCompat.ACTION_CUT) / 2))) {
                            FramedStream.this.connection.writeWindowUpdateLater(0, FramedStream.this.connection.unacknowledgedBytesRead);
                            FramedStream.this.connection.unacknowledgedBytesRead = 0;
                        }
                    }
                }
            }
            return j;
        }

        private void waitUntilReadable() throws IOException {
            FramedStream.this.readTimeout.enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed && FramedStream.this.errorCode == null) {
                try {
                    FramedStream.this.waitForIo();
                } catch (Throwable th) {
                    FramedStream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
            FramedStream.this.readTimeout.exitAndThrowIfTimedOut();
        }

        void receive(BufferedSource in, long byteCount) throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(FramedStream.this)) {
                while (byteCount > 0) {
                    boolean finished;
                    boolean flowControlError;
                    synchronized (FramedStream.this) {
                        finished = this.finished;
                        flowControlError = this.readBuffer.size() + byteCount > this.maxByteCount;
                    }
                    if (flowControlError) {
                        in.skip(byteCount);
                        FramedStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (finished) {
                        in.skip(byteCount);
                        return;
                    } else {
                        long read = in.read(this.receiveBuffer, byteCount);
                        if (read == -1) {
                            throw new EOFException();
                        }
                        byteCount -= read;
                        synchronized (FramedStream.this) {
                            boolean wasEmpty = this.readBuffer.size() == 0;
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (wasEmpty) {
                                FramedStream.this.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return FramedStream.this.readTimeout;
        }

        public void close() throws IOException {
            synchronized (FramedStream.this) {
                this.closed = true;
                this.readBuffer.clear();
                FramedStream.this.notifyAll();
            }
            FramedStream.this.cancelStreamIfNecessary();
        }

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            } else if (FramedStream.this.errorCode != null) {
                throw new IOException("stream was reset: " + FramedStream.this.errorCode);
            }
        }
    }

    class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        protected void timedOut() {
            FramedStream.this.closeLater(ErrorCode.CANCEL);
        }

        protected IOException newTimeoutException(IOException cause) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (cause != null) {
                socketTimeoutException.initCause(cause);
            }
            return socketTimeoutException;
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }
    }

    static {
        $assertionsDisabled = !FramedStream.class.desiredAssertionStatus();
    }

    FramedStream(int id, FramedConnection connection, boolean outFinished, boolean inFinished, List<Header> requestHeaders) {
        this.unacknowledgedBytesRead = 0;
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        this.errorCode = null;
        if (connection == null) {
            throw new NullPointerException("connection == null");
        } else if (requestHeaders == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.id = id;
            this.connection = connection;
            this.bytesLeftInWriteWindow = (long) connection.peerSettings.getInitialWindowSize(AccessibilityNodeInfoCompat.ACTION_CUT);
            this.source = new FramedDataSource((long) connection.okHttpSettings.getInitialWindowSize(AccessibilityNodeInfoCompat.ACTION_CUT), null);
            this.sink = new FramedDataSink();
            this.source.finished = inFinished;
            this.sink.finished = outFinished;
            this.requestHeaders = requestHeaders;
        }
    }

    public int getId() {
        return this.id;
    }

    public synchronized boolean isOpen() {
        boolean z = false;
        synchronized (this) {
            if (this.errorCode == null) {
                if (!(this.source.finished || this.source.closed) || (!(this.sink.finished || this.sink.closed) || this.responseHeaders == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean isLocallyInitiated() {
        boolean streamIsClient;
        if ((this.id & 1) == 1) {
            streamIsClient = true;
        } else {
            streamIsClient = false;
        }
        return this.connection.client == streamIsClient;
    }

    public FramedConnection getConnection() {
        return this.connection;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public synchronized List<Header> getResponseHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.responseHeaders == null && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.responseHeaders != null) {
        } else {
            throw new IOException("stream was reset: " + this.errorCode);
        }
        return this.responseHeaders;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public void reply(List<Header> responseHeaders, boolean out) throws IOException {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            boolean outFinished = false;
            synchronized (this) {
                if (responseHeaders == null) {
                    throw new NullPointerException("responseHeaders == null");
                } else if (this.responseHeaders != null) {
                    throw new IllegalStateException("reply already sent");
                } else {
                    this.responseHeaders = responseHeaders;
                    if (!out) {
                        this.sink.finished = true;
                        outFinished = true;
                    }
                }
            }
            this.connection.writeSynReply(this.id, outFinished, responseHeaders);
            if (outFinished) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public Source getSource() {
        return this.source;
    }

    public Sink getSink() {
        synchronized (this) {
            if (this.responseHeaders != null || isLocallyInitiated()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public void close(ErrorCode rstStatusCode) throws IOException {
        if (closeInternal(rstStatusCode)) {
            this.connection.writeSynReset(this.id, rstStatusCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.id, errorCode);
        }
    }

    private boolean closeInternal(ErrorCode errorCode) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.errorCode != null) {
                    return false;
                } else if (this.source.finished && this.sink.finished) {
                    return false;
                } else {
                    this.errorCode = errorCode;
                    notifyAll();
                    this.connection.removeStream(this.id);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    void receiveHeaders(List<Header> headers, HeadersMode headersMode) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            ErrorCode errorCode = null;
            boolean open = true;
            synchronized (this) {
                if (this.responseHeaders == null) {
                    if (headersMode.failIfHeadersAbsent()) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.responseHeaders = headers;
                        open = isOpen();
                        notifyAll();
                    }
                } else if (headersMode.failIfHeadersPresent()) {
                    errorCode = ErrorCode.STREAM_IN_USE;
                } else {
                    List<Header> newHeaders = new ArrayList();
                    newHeaders.addAll(this.responseHeaders);
                    newHeaders.addAll(headers);
                    this.responseHeaders = newHeaders;
                }
            }
            if (errorCode != null) {
                closeLater(errorCode);
                return;
            } else if (!open) {
                this.connection.removeStream(this.id);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    void receiveData(BufferedSource in, int length) throws IOException {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            this.source.receive(in, (long) length);
            return;
        }
        throw new AssertionError();
    }

    void receiveFin() {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            boolean open;
            synchronized (this) {
                this.source.finished = true;
                open = isOpen();
                notifyAll();
            }
            if (!open) {
                this.connection.removeStream(this.id);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    private void cancelStreamIfNecessary() throws IOException {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            boolean cancel;
            boolean open;
            synchronized (this) {
                cancel = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
                open = isOpen();
            }
            if (cancel) {
                close(ErrorCode.CANCEL);
                return;
            } else if (!open) {
                this.connection.removeStream(this.id);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    void addBytesToWriteWindow(long delta) {
        this.bytesLeftInWriteWindow += delta;
        if (delta > 0) {
            notifyAll();
        }
    }

    private void checkOutNotClosed() throws IOException {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        } else if (this.sink.finished) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            throw new IOException("stream was reset: " + this.errorCode);
        }
    }

    private void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }
}
