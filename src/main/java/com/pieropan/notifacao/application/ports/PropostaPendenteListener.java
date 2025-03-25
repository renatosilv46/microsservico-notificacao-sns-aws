package com.pieropan.notifacao.application.ports;

import com.pieropan.notifacao.application.domain.Proposta;

public interface PropostaPendenteListener {
    void recebeMensagemToPropostaPendente(Proposta proposta);
}
