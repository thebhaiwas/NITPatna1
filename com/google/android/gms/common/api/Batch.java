package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.internal.zzpt;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzpt<BatchResult> {
    private final PendingResult<?>[] rA;
    private int rx;
    private boolean ry;
    private boolean rz;
    private final Object zzail;

    public static final class Builder {
        private GoogleApiClient hb;
        private List<PendingResult<?>> rC;

        public Builder(GoogleApiClient googleApiClient) {
            this.rC = new ArrayList();
            this.hb = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.rC.size());
            this.rC.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.hb, null);
        }
    }

    /* renamed from: com.google.android.gms.common.api.Batch.1 */
    class C04241 implements zza {
        final /* synthetic */ Batch rB;

        C04241(Batch batch) {
            this.rB = batch;
        }

        public void zzv(Status status) {
            synchronized (this.rB.zzail) {
                if (this.rB.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.rB.rz = true;
                } else if (!status.isSuccess()) {
                    this.rB.ry = true;
                }
                this.rB.rx = this.rB.rx - 1;
                if (this.rB.rx == 0) {
                    if (this.rB.rz) {
                        super.cancel();
                    } else {
                        this.rB.zzc(new BatchResult(this.rB.ry ? new Status(13) : Status.sg, this.rB.rA));
                    }
                }
            }
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzail = new Object();
        this.rx = list.size();
        this.rA = new PendingResult[this.rx];
        if (list.isEmpty()) {
            zzc(new BatchResult(Status.sg, this.rA));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult pendingResult = (PendingResult) list.get(i);
            this.rA[i] = pendingResult;
            pendingResult.zza(new C04241(this));
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.rA) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.rA);
    }

    public /* synthetic */ Result zzc(Status status) {
        return createFailedResult(status);
    }
}
