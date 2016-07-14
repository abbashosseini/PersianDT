package com.hosseini.persian.dt.PersianDate;

import java.util.concurrent.atomic.AtomicReference;

final class CallbackHolder{

    private final AtomicReference<CallBack> callBack = new AtomicReference<>();

    CallbackHolder(CallBack callBack){
        this.callBack.set(callBack);
    }

    public synchronized CallBack getCallBack(){
        return this.callBack.get();
    }
}
