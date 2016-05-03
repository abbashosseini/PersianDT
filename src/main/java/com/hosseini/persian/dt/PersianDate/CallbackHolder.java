package com.hosseini.persian.dt.PersianDate;

final class CallbackHolder{

    private final CallBack callBack;

    CallbackHolder(CallBack callBack){
        this.callBack = callBack;
    }

    public final CallBack getCallBack(){
        return callBack;
    }


}
