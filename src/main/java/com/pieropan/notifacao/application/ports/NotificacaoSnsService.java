package com.pieropan.notifacao.application.ports;

public interface NotificacaoSnsService {
    void notificar(String telefone, String mensagem);
}
