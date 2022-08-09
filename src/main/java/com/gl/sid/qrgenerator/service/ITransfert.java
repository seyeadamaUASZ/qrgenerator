package com.gl.sid.qrgenerator.service;

import com.gl.sid.qrgenerator.models.Operation;
import com.gl.sid.qrgenerator.models.Transfert;

public interface ITransfert {
    Operation addTranfert(Transfert transfert);
}
